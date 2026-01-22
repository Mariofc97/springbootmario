package es.cursojava.springbootmario.servicios;

import org.springframework.stereotype.Service;

import es.cursojava.springbootmario.beans.Operacion;

@Service
public class CalculadoraServiceSpringBoot {
	private Operacion suma;
	private Operacion resta;
	private Operacion multiplicacion;
	private Operacion division;
	
	public CalculadoraServiceSpringBoot(Operacion suma, Operacion resta, Operacion multiplicacion, Operacion division) {
		super();
		this.suma = suma;
		this.resta = resta;
		this.multiplicacion = multiplicacion;
		this.division = division;
	}

	public double calcular(double a, double b, String simbolo) {
		return 
		switch (simbolo) {
		case "+" -> suma.ejecutar(a, b);
		case "-" -> resta.ejecutar(a, b);
		case "*" -> multiplicacion.ejecutar(a, b);
		case "/" -> division.ejecutar(a, b);
		default -> throw new IllegalArgumentException("Unexpected value: " + simbolo);
		};
	}
}
