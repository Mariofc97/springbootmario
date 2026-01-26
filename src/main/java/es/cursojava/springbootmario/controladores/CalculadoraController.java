package es.cursojava.springbootmario.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.cursojava.springbootmario.servicios.CalculadoraServiceSpringBoot;

@Controller
public class CalculadoraController {

    private final CalculadoraServiceSpringBoot calcService;

    public CalculadoraController(CalculadoraServiceSpringBoot calcService) {
        this.calcService = calcService;
    }

    @GetMapping("/calculadora")
    public String calculadora(
            @RequestParam("num1") double num1,
            @RequestParam("num2") double num2,
            @RequestParam("op") String op,
            Model model
    ) {
        double resultado = calcService.calcular(num1, num2, op);

        model.addAttribute("numero1", num1);
        model.addAttribute("numero2", num2);
        model.addAttribute("op", op);
        model.addAttribute("resultado", resultado);
        model.addAttribute("mensaje", "Resultado de " + num1 + " " + op + " " + num2);

        return "calculadora"; // templates/calculadora.html
    }
}
