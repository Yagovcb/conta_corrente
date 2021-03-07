package br.com.yagovcb.conta_corrente.repository;

import br.com.yagovcb.conta_corrente.model.ContaCorrente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

    @Query("SELECT c FROM ContaCorrente c " +
            "LEFT JOIN Transacao t on t.contaCorrente.id = c.id " +
            "WHERE t.id = :idTransacao")
    ContaCorrente findByTransacoes(@Param("idTransacao")Long idTransacao);
}
