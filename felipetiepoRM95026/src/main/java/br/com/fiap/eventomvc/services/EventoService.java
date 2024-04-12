package br.com.fiap.eventomvc.services;

import br.com.fiap.eventomvc.models.Evento;
import br.com.fiap.eventomvc.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    @Transactional(readOnly = true)
    public List<Evento> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Evento insert(Evento evento) {
        return repository.save(evento);
    }

    @Transactional(readOnly = true)
    public Evento findById(Long id) {

        Evento evento = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso inválido - " + id)
        );

        return evento;
    }

    @Transactional
    public Evento update(Long id, Evento entity) {

        try {
            Evento evento = repository.getReferenceById(id);
            copyToEvento(entity, evento);
            evento = repository.save(evento);
            return evento;
        }catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado!");
        }
    }

    private void copyToEvento(Evento entity, Evento evento){

        evento.setNome(entity.getNome());
        evento.setData(entity.getData());
        evento.setUrl(entity.getUrl());

    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Recurso inválido - id: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Falha de integridade referencial - id: " + id);
        }
    }

}