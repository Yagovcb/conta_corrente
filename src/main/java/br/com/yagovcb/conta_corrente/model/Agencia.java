package br.com.yagovcb.conta_corrente.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "agencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @NonNull
    private int numero;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Cliente> clientes;
}
