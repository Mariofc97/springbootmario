package es.cursojava.springbootmario.beans;

import org.springframework.stereotype.Component;

@Component("sumaOp")
public class Suma implements Operacion {

	@Override
	public String simbolo() {
		// TODO Auto-generated method stub
		return "+";
	}

	@Override
	public double ejecutar(double a, double b) {
		// TODO Auto-generated method stub
		return a + b;
	}

}
