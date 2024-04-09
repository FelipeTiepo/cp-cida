package br.com.fiap.eventomvc.controllers;

import br.com.fiap.eventomvc.services.CidadeService;
import br.com.fiap.eventomvc.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eventos")
public class EventoController{


    @Autowired
    private EventoService service;

    @Autowired
    private CidadeService serviceCidade;




}
