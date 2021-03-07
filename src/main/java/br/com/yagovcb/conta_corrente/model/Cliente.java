package br.com.yagovcb.conta_corrente.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NonNull
    private String nome;

    @NonNull
    private String documento;

    @OneToOne(fetch = FetchType.LAZY)
    private ContaCorrente contaCorrente;
}
