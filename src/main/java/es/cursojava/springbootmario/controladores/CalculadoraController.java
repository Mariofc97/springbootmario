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
		super();
		this.calcService = calcService;
	}


	@GetMapping("/calculadora")
	public String calculadora() {
		@RequestParam("num1") double num1,
		@RequestParam("num2") double num2,
		@RequestParam("op") String op,
		Model model){
			
		}
	}
}
