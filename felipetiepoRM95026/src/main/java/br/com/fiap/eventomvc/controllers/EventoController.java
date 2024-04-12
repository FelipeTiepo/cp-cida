package br.com.fiap.eventomvc.controllers;

import br.com.fiap.eventomvc.models.Cidade;
import br.com.fiap.eventomvc.models.Evento;
import br.com.fiap.eventomvc.services.CidadeService;
import br.com.fiap.eventomvc.services.EventoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @Autowired
    private CidadeService serviceCidade;

    @ModelAttribute("eventos")
    public List<Cidade> cidades() {
        return serviceCidade.findAll();
    }

    @GetMapping("/form")
    public String loadFormEvento(Model model) {
        model.addAttribute("evento", new Evento());
        return "evento/novo-evento";
    }

    @PostMapping()
    @Transactional
    public String insert(@Valid Evento evento,
                         BindingResult result,
                         RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "evento/novo-evento";
        }
        evento = service.insert(evento);
        attributes.addFlashAttribute("mensagem", "Evento salvo com sucesso!");
        return "redirect:/eventos";
    }

    @GetMapping()
    public String findAll(Model model) {
        List<Evento> eventos = service.findAll();
        model.addAttribute("eventos", eventos);
        return "/evento/listar-eventos";
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public String findById(@PathVariable("id") Long id, Model model) {


        Evento evento = service.findById(id);
        model.addAttribute("evento", evento);
        return "/evento/editar-evento";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid Evento evento,
                         BindingResult result) {
        if (result.hasErrors()) {
            evento.setId(id);
            return "/evento/editar-evento";
        }
        service.update(id, evento);
        return "redirect:/eventos";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        service.delete(id);
        return "redirect:/eventos";
    }

}










