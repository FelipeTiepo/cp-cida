package br.com.fiap.eventomvc.repository;

import br.com.fiap.eventomvc.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    //Felipe Tiepo - RM 95026
    //Felipe Adriano - RM 93015
}
