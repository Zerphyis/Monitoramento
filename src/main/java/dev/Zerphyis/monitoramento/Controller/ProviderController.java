package dev.Zerphyis.monitoramento.Controller;

import dev.Zerphyis.monitoramento.Entity.Data.DataProvider;
import dev.Zerphyis.monitoramento.Entity.Provider.Provider;
import dev.Zerphyis.monitoramento.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/fornecedores")
public class ProviderController {
    @Autowired
    ProviderService service;

    @GetMapping("/listar")
    public String listarFornecedores(Model model) {
        List<Provider> providers = service.getAllProviders();
        model.addAttribute("providers", providers);
        return "fornecedores/list";
    }

    @GetMapping("/novo")
    public String showCreateForm(Model model) {
        model.addAttribute("dataProvider", new DataProvider("", "", ""));
        return "fornecedores/form";
    }

    @PostMapping
    public String createProvider(@ModelAttribute DataProvider dataProvider) {
        service.createProvider(dataProvider);
        return "redirect:/fornecedores/listar";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Optional<Provider> provider = service.getProviderById(id);
        if (provider.isPresent()) {
            model.addAttribute("dataProvider", new DataProvider(
                    provider.get().getName(),
                    provider.get().getPhone(),
                    provider.get().getEmail()
            ));
            model.addAttribute("id", id);
            return "fornecedores/form";
        }
        return "redirect:/fornecedores/listar";
    }

    @PostMapping("/atualizar/{id}")
    public String updateProvider(@PathVariable("id") Long id, @ModelAttribute DataProvider dataProvider) {
        service.updateProvider(id, dataProvider);
        return "redirect:/fornecedores/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deleteProvider(@PathVariable("id") Long id) {
        service.deleteProvider(id);
        return "redirect:/fornecedores/listar";
    }
}
