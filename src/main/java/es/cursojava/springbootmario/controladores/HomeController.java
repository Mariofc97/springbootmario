package es.cursojava.springbootmario.controladores;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class HomeController {

	@GetMapping("/") // con esto mapeamos el controlador a la raiz del proyecto
	//  @GetMapping("/welcome")
	public String welcome() {
		return "index";
	}
	
//	@RequestMapping("/test")
//	public String test(Model model, HttpServletRequest request) {
//		request.getParameter("");
//		model.addAttribute("mensaje","Hello from Spring Boot");
//		model.addAttribute("numero",6);
//		return "test";
//	}
}
