package dev.Zerphyis.monitoramento.Controller;

import dev.Zerphyis.monitoramento.Entity.MovimentStock.MovimentStock;
import dev.Zerphyis.monitoramento.Entity.MovimentStock.TypeMoviment;
import dev.Zerphyis.monitoramento.Service.MovimentStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movimentacoes")
public class MovimentoStockController {
    @Autowired
    MovimentStockService service;

    @GetMapping
    public String listarMovimentacoes(Model model) {
        model.addAttribute("movimentacoes", service.getAllMoviments());
        return "movimentacoes/listar";
    }

    @GetMapping("/novo")
    public String exibirFormularioMovimentacao(Model model) {
        model.addAttribute("produtos", service.getAllMoviments());
        model.addAttribute("movimentacao", new MovimentStock());
        return "movimentacoes/form";
    }

    @PostMapping
    public String registrarMovimentacao(@RequestParam Long productId,
                                        @RequestParam TypeMoviment typeMoviment,
                                        @RequestParam Integer amounts) {
        service.registerMoviment(productId, typeMoviment, amounts);
        return "redirect:/movimentacoes";
    }

    @GetMapping("/editar/{id}")
    public String editarMovimentacao(@PathVariable Long id, Model model) {
        MovimentStock movimentacao = service.getMovimentById(id);
        model.addAttribute("movimentacao", movimentacao);
        model.addAttribute("produtos", service.getAllMoviments());
        return "movimentacoes/edit";
    }

    @PostMapping("/editar/{id}")
    public String atualizarMovimentacao(@PathVariable Long id,
                                        @RequestParam Long productId,
                                        @RequestParam TypeMoviment typeMoviment,
                                        @RequestParam Integer amounts) {
        service.updateMoviment(id, typeMoviment, amounts);
        return "redirect:/movimentacoes";
    }

    @GetMapping("/deletar/{id}")
    public String deletarMovimentacao(@PathVariable Long id) {
        service.deleteMoviment(id);
        return "redirect:/movimentacoes";
    }
}
