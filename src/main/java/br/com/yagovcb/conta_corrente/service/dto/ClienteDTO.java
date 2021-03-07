package br.com.yagovcb.conta_corrente.service.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NonNull
    private String nome;

    @NonNull
    private String documento;

    @NonNull
    private ContaCorrenteDTO contaCorrenteDTO;
}
