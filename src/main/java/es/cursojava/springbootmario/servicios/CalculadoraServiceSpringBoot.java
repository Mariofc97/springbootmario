package es.cursojava.springbootmario.servicios;

import org.springframework.stereotype.Service;

import es.cursojava.springbootmario.beans.Division;
import es.cursojava.springbootmario.beans.Multiplicacion;
import es.cursojava.springbootmario.beans.Resta;
import es.cursojava.springbootmario.beans.Suma;

@Service
public class CalculadoraServiceSpringBoot {

    private final Suma suma;
    private final Resta resta;
    private final Multiplicacion multiplicacion;
    private final Division division;

    public CalculadoraServiceSpringBoot(Suma suma, Resta resta,
                                        Multiplicacion multiplicacion, Division division) {
        this.suma = suma;
        this.resta = resta;
        this.multiplicacion = multiplicacion;
        this.division = division;
    }

    public double calcular(double a, double b, String simbolo) {
        return switch (simbolo) {
            case "+" -> suma.ejecutar(a, b);
            case "-" -> resta.ejecutar(a, b);
            case "*" -> multiplicacion.ejecutar(a, b);
            case "/" -> division.ejecutar(a, b);
            default -> throw new IllegalArgumentException("Operación no válida: " + simbolo);
        };
    }
}