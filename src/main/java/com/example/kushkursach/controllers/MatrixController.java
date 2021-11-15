package com.example.kushkursach.controllers;

import com.example.kushkursach.domain.Operation;
import com.example.kushkursach.services.MatrixService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MatrixController {
    private final MatrixService matrixService;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("operation", new Operation());
        return "index";
    }

    @PostMapping("/process")
    public String process(Model model, @ModelAttribute("operation") Operation operation) {
        try {
            operation.setResult(matrixService.process(operation));
            model.addAttribute("operation", operation);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getClass().getSimpleName() + ": " + e.getMessage());
            e.printStackTrace();
        }
        return "index";
    }
}
