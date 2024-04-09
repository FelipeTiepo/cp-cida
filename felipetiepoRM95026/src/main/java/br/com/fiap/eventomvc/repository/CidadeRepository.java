package br.com.fiap.eventomvc.repository;

import br.com.fiap.eventomvc.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
