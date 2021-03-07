package br.com.yagovcb.conta_corrente.repository;

import br.com.yagovcb.conta_corrente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
