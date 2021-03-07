package br.com.yagovcb.conta_corrente.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conta_corrente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NonNull
    private int numero_conta;

    @NonNull
    private double saldo_atual;

    @OneToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agencia agencia;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Transacao> transacoes;

}
