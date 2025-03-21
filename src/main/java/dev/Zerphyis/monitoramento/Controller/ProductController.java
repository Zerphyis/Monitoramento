package dev.Zerphyis.monitoramento.Controller;

import dev.Zerphyis.monitoramento.Entity.Data.DataProductEntry;
import dev.Zerphyis.monitoramento.Entity.Product.Product;
import dev.Zerphyis.monitoramento.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "produtos/list";
    }

    @GetMapping("/novo")
    public String createProductForm(Model model) {
        model.addAttribute("dataProductEntry", new DataProductEntry("", 0.0, 0, null, 0L, 0));
        return "produtos/form";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute DataProductEntry dataProductEntry) {
        if (dataProductEntry.name() == null || dataProductEntry.name().isEmpty()) {
            return "redirect:/produtos";
        }

        if (dataProductEntry.providerId() == null || dataProductEntry.providerId() == 0L) {
            productService.createProduct(dataProductEntry);
        } else {
            Optional<Product> existingProduct = productService.getProductById(dataProductEntry.providerId());
            if (existingProduct.isPresent()) {
                productService.updateProduct(existingProduct.get().getId(), dataProductEntry);
            } else {
                productService.createProduct(dataProductEntry);
            }
        }

        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Optional<Product> productOptional = productService.getProductById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            DataProductEntry dataProductEntry = new DataProductEntry(
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity(),
                    product.getCategoryProduct(),
                    product.getProvider().getId(),
                    product.getStockAlert()
            );
            model.addAttribute("dataProductEntry", dataProductEntry);
            return "produtos/form";
        } else {
            return "redirect:/produtos";
        }
    }

    @GetMapping("/deletar/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/produtos";
    }
}
