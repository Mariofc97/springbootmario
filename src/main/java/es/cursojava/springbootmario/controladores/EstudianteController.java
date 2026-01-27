package es.cursojava.springbootmario.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import es.cursojava.springbootmario.models.EstudianteDto;
import es.cursojava.springbootmario.servicios.EstudianteService;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("estudiante", new EstudianteDto());
        model.addAttribute("mensaje", "");
        model.addAttribute("estudiantes", estudianteService.getEstudiantes());
        return "estudiante";
    }

    @PostMapping
    public String altaEstudiante(@ModelAttribute("estudiante") EstudianteDto estudianteDto, Model model) {

        String mensaje = estudianteService.comprobadorEdad(estudianteDto);

        
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("estudiante", new EstudianteDto());
        model.addAttribute("estudiantes", estudianteService.getEstudiantes());

        return "estudiante";
    }
}
