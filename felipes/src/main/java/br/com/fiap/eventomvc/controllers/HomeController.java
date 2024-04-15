package br.com.fiap.eventomvc.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
    //Felipe Tiepo - RM 95026
    //Felipe Adriano - RM 93015
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("msg", "Bem vinda ao meu checkpoint Cida S2");
        return "/evento/index";
    }
}
