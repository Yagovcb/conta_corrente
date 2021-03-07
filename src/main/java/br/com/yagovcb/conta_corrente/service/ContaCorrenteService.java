package br.com.yagovcb.conta_corrente.service;

import br.com.yagovcb.conta_corrente.model.Cliente;
import br.com.yagovcb.conta_corrente.model.ContaCorrente;
import br.com.yagovcb.conta_corrente.model.Transacao;
import br.com.yagovcb.conta_corrente.repository.ClienteRepository;
import br.com.yagovcb.conta_corrente.repository.ContaCorrenteRepository;
import br.com.yagovcb.conta_corrente.repository.TransacaoRepository;
import br.com.yagovcb.conta_corrente.service.dto.ClienteDTO;
import br.com.yagovcb.conta_corrente.service.dto.TransacaoDTO;
import br.com.yagovcb.conta_corrente.service.mapper.ClienteMapper;
import br.com.yagovcb.conta_corrente.service.mapper.TransacaoMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ContaCorrenteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    private final ClienteMapper clienteMapper;

    private final TransacaoMapper transacaoMapper;

    @Transactional
    public ClienteDTO cadastraCliente(ClienteDTO clienteDTO) {
        log.debug("Request to save Festival : {}", clienteDTO);
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente.setContaCorrente(new ContaCorrente());
        cliente.getContaCorrente().setTransacoes(new ArrayList<>());
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDto(cliente);
    }

    @Transactional
    public ClienteDTO atualizaCliente(ClienteDTO clienteDTO) {
        log.debug("Request to save Festival : {}", clienteDTO);
        Cliente cliente = clienteRepository.save(clienteMapper.toEntity(clienteDTO));
        return clienteMapper.toDto(cliente);
    }

    public TransacaoDTO efetuaSaque(TransacaoDTO transacaoDTO) throws Exception {
        double saldo_final = 0.0;
        Transacao transacao = transacaoRepository.save(transacaoMapper.toEntity(transacaoDTO));
        ContaCorrente contaCorrente = contaCorrenteRepository.findByTransacoes(transacao.getId());

        if (contaCorrente.getSaldo_atual() >= transacao.getValor()){
            transacaoRepository.save(transacao);
            saldo_final = contaCorrente.getSaldo_atual() - transacao.getValor();
            contaCorrente.setSaldo_atual(saldo_final);
            log.debug("Transação allowed : {}", saldo_final);
        } else {
            throw new Exception("Você não possui saldo suficiente para realizar a transação");
        }
        return transacaoMapper.toDto(transacao);
    }

    public TransacaoDTO depositar(TransacaoDTO transacaoDTO) {
        Transacao transacao = transacaoRepository.save(transacaoMapper.toEntity(transacaoDTO));
        ContaCorrente contaCorrente = contaCorrenteRepository.findByTransacoes(transacao.getId());

        contaCorrente.setSaldo_atual(transacao.getValor());

        return transacaoMapper.toDto(transacao);
    }
    @Transactional(readOnly = true)
    public @NonNull double getSaldoContaCorrente(Long id) {
        log.debug("Request to get Saldo of ContaCorrente : {}", id);
        ContaCorrente contaCorrente = contaCorrenteRepository.getOne(id);
        return contaCorrente.getSaldo_atual();
    }

    public List<TransacaoDTO> buscaTransacoesPorContaCorrente(Long id) {
        log.debug("Request to get all Transações of ContaCorrente : {}", id);
        List<Transacao> transacoes = transacaoRepository.findAllByContaCorrenteId(id);
        List<TransacaoDTO> tDTO = new ArrayList<>();
        transacoes.forEach(transacao -> tDTO.add(transacaoMapper.toDto(transacao)));

        return tDTO;
    }
}
