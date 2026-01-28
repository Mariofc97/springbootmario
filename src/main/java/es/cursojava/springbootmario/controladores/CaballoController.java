package es.cursojava.springbootmario.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carreracaballos")
public class CaballoController {

	@GetMapping()
	public ModelAndView caballoModelView() {
		System.out.println("Acceso a pagina de caballos");
		
		return new ModelAndView("caballo","myCaballo");
	}
	
	@PostMapping("/")
	
}
