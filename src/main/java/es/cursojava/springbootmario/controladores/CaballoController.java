package es.cursojava.springbootmario.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import es.cursojava.springbootmario.models.CaballoDto;
import es.cursojava.springbootmario.servicios.CaballoService;
import jakarta.servlet.http.HttpSession;

@Controller

public class CaballoController {

	private final CaballoService caballoService;

	public CaballoController(CaballoService caballoService) {
		super();
		this.caballoService = caballoService;
	}

	// si no hay caballos ir a registroCaballos para darlo de alta, si ya hay ir a
	// datos caballos para ver los que ya estan dados de alta en la base de datos
	@GetMapping("/carreracaballos")
	public String entrarCarreras() {
		int total = caballoService.findAll().size();
		if (total == 0)
			return "redirect:/registroCaballos";
		return "redirect:/datosCaballos";
	}

	@GetMapping("/registroCaballos")
	public String registroCaballos(Model model) {
		if (!model.containsAttribute("caballo")) {
			model.addAttribute("caballo", new CaballoDto());
		}
		return "/registroCaballos";
	}

	// al crear caballo ir a datosCaballos y si hay un error volver a
	// registroCaballos
	@PostMapping("/registroCaballos")
	public String crearCaballo(@ModelAttribute("caballo") CaballoDto caballo, Model model) {
		try {
			caballoService.create(caballo);
			return "redirect:/datosCaballos";
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error","Error al añadir caballo " + caballo.getNombre() + " a la base de datos");
			return "/registroCaballos";
		}
	}
	
	@GetMapping("/datosCaballos")
	public String datosCaballos(Model model) {
		List<CaballoDto> caballos = caballoService.findAll();
		model.addAttribute("caballos",caballos);
		return "/datosCaballos";
	}
	
	@PostMapping("/correr")
	public String correr(Model model, HttpSession session) {
		var result = caballoService.correr();
		model.addAttribute("ganador", result);
		return "/ganador";
	}
	
	
	
	
}
