package br.com.yagovcb.conta_corrente.service.dto;

import br.com.yagovcb.conta_corrente.model.ContaCorrente;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NonNull
    private LocalDate data;

    @NonNull
    private double valor;

    @NonNull
    private ContaCorrente contaCorrente;
}
