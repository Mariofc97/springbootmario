package es.cursojava.springbootmario.servicios;

import org.springframework.stereotype.Service;

import es.cursojava.springbootmario.models.EstudianteDto;

@Service
public class EstudianteService {

	public void comprobadorEdad(EstudianteDto e) {
		if(e.getEdad()>=18) {
			System.out.println("Alta del estudiante realizada correctamente.");
		} else {
			System.err.println("Ha ocurrido un error, el estudiante debe de tener minimo 18 años");
		}
	}
}
