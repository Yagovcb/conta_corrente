package br.com.yagovcb.conta_corrente.web.rest;

import br.com.yagovcb.conta_corrente.service.ContaCorrenteService;
import br.com.yagovcb.conta_corrente.service.dto.ClienteDTO;
import br.com.yagovcb.conta_corrente.service.dto.ContaCorrenteDTO;
import br.com.yagovcb.conta_corrente.service.dto.TransacaoDTO;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class ContaCorrenteController {

    @Autowired
    public ContaCorrenteService service;


    /**
     * {@code POST  /cad_cliente} : Create a new Cliente.
     *
     * @param cliente the Cliente to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new Cliente, or with status {@code 400 (Bad Request)} if the Cliente has already an ID
     */
    @Valid
    @PostMapping("/cad_cliente")
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO cliente){
        log.debug("REST request to save Cliente : {}", cliente);
        ClienteDTO resultado = service.cadastraCliente(cliente);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    /**
     * {@code PUT  /atualiza_cliente} : Update a Cliente.
     *
     * @param cliente the Cliente to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new Cliente, or with status {@code 400 (Bad Request)} if the Cliente has already an ID
     */
    @Valid
    @PutMapping("/atualiza_cliente")
    public ResponseEntity<ClienteDTO> updateCliente(@RequestBody ClienteDTO cliente){
        log.debug("REST request to update Cliente : {}", cliente);
        ClienteDTO resultado = service.atualizaCliente(cliente);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    /**
     * {@code PUT  /sacar} : Create a TransacaoDTO.
     *
     * @param transacaoDTO the TransacaoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new TransacaoDTO, or with status {@code 400 (Bad Request)} if the TransacaoDTO has already an ID
     */
    @Valid
    @PutMapping("/sacar")
    public ResponseEntity<TransacaoDTO> sacar(@RequestBody TransacaoDTO transacaoDTO) throws Exception {
        log.debug("REST request to save Transacao : {}", transacaoDTO);
        TransacaoDTO resultado = service.efetuaSaque(transacaoDTO);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    /**
     * {@code PUT  /depositar} : Create a TransacaoDTO.
     *
     * @param transacaoDTO the TransacaoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new TransacaoDTO, or with status {@code 400 (Bad Request)} if the TransacaoDTO has already an ID
     */
    @Valid
    @PutMapping("/depositar")
    public ResponseEntity<TransacaoDTO> depositar(@RequestBody TransacaoDTO transacaoDTO) {
        log.debug("REST request to save Transacao : {}", transacaoDTO);
        TransacaoDTO resultado = service.depositar(transacaoDTO);
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    /**
     * {@code GET  /{id}} : Create a ContaCorrenteDTO.
     *
     * @param id the ContaCorrenteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new TransacaoDTO, or with status {@code 400 (Bad Request)} if the TransacaoDTO has already an ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ContaCorrenteDTO> getSaldo(@PathVariable Long id) {
        log.debug("REST request to get Premio : {}", id);
        @NonNull double contaCorrenteDTO = service.getSaldoContaCorrente(id);
        return new ResponseEntity(contaCorrenteDTO, HttpStatus.OK);
    }

    /**
     * {@code GET  /transacao/{id}} : Create a ContaCorrenteDTO.
     *
     * @param id the ContaCorrenteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new TransacaoDTO, or with status {@code 400 (Bad Request)} if the TransacaoDTO has already an ID
     */
    @GetMapping("/transacao/{id}")
    public ResponseEntity<List<TransacaoDTO>> getExtrato(@PathVariable Long id ) {
        log.debug("REST request to get Premio : {}", id);
        List<TransacaoDTO> transacoes = service.buscaTransacoesPorContaCorrente(id);
        return new ResponseEntity(transacoes, HttpStatus.OK);
    }

}

