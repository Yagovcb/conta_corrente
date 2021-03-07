package br.com.yagovcb.conta_corrente.model;

import br.com.yagovcb.conta_corrente.service.ContaCorrenteService;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")

    private Long id;

    @NonNull
    private LocalDate data;

    @NonNull
    private double valor;

    @ManyToOne(fetch = FetchType.LAZY)
    private ContaCorrente contaCorrente;
}
