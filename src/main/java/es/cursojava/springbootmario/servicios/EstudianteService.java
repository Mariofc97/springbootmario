package es.cursojava.springbootmario.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.cursojava.springbootmario.models.EstudianteDto;

@Service
public class EstudianteService {

	private List<EstudianteDto> estudiantes = new ArrayList<>();
	
	public String comprobadorEdad(EstudianteDto e) {
		if(e.getEdad()>=18) {
			estudiantes.add(e);
			String mensaje = "Alta del estudiante realizada correctamente";
			return mensaje;
		} else {
			String mensaje = "Ha ocurrido un error, el estudiante debe de tener minimo 18 años";
			return mensaje;
		}
	}
	
    public List<EstudianteDto> getEstudiantes() {
        return estudiantes;
    }
}
