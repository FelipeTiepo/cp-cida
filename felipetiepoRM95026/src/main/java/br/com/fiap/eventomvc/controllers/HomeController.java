package br.com.fiap.eventomvc.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("msg", "Bem vinda ao meu checkpoint Cida S2");
        return "/evento/index";
    }
}
