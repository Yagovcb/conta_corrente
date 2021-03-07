package br.com.yagovcb.conta_corrente.repository;

import br.com.yagovcb.conta_corrente.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findAllByContaCorrenteId(@Param("id") long id);
}
