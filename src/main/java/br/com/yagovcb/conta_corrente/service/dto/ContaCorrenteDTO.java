package br.com.yagovcb.conta_corrente.service.dto;

import br.com.yagovcb.conta_corrente.model.Agencia;
import br.com.yagovcb.conta_corrente.model.Cliente;
import br.com.yagovcb.conta_corrente.model.Transacao;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaCorrenteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NonNull
    private int numero_conta;

    @NonNull
    private double saldo_atual;

    @NonNull
    private Cliente cliente;

    @NonNull
    private Agencia agencia;

    @NonNull
    private Transacao transacao;
}
