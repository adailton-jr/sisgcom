package br.lino.sisgcom.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping("/")
public class PrincipalController {

    @RequestMapping
    public String index(Model model) {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        model.addAttribute("message", "Olá mundo caralho!!");
        model.addAttribute("data", localDate);
        model.addAttribute("hora", localTime);
        return "index";
    }
}
