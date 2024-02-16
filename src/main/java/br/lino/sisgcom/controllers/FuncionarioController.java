package br.lino.sisgcom.controllers;

import br.lino.sisgcom.models.Funcionario;
import br.lino.sisgcom.services.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public String ViewBusca(Model model) {
        model.addAttribute("funcionarios", funcionarioService.findAll());
        return "lista-busca";
    }

    @GetMapping("/cadastroFuncionario")
    public String ViewCadastro(Model model) {
        Funcionario funcionario = new Funcionario();
        model.addAttribute("funcionario", funcionario);
        return "funcionario";
    }

    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario) {
        funcionarioService.save(funcionario);
        return "redirect:/funcionarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") String id, Model model) {
        try {
            UUID uuid = UUID.fromString(id);
            model.addAttribute("funcionario", funcionarioService.findById(uuid));
            return "funcionario";
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", "Funcionário não encontrado");
            return "redirect:/funcionarios";
        }
    }

    @DeleteMapping("/excluir/{id}")
    public String deletar(@PathVariable("id") String id) {
        try {
            UUID uuid = UUID.fromString(id);
            funcionarioService.deleteById(uuid);
            return "redirect:/funcionarios";
        } catch (IllegalArgumentException e) {
            return "redirect:/funcionarios";
        } catch (Exception e) {
            return "redirect:/funcionarios";
        }
    }
}
