package es.cursojava.springbootmario.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TB_CABALLOS")
public class CaballoEntity {

    public double getMetrosRecorridos() {
		return metrosRecorridos;
	}

	public void setMetrosRecorridos(double metrosRecorridos) {
		this.metrosRecorridos = metrosRecorridos;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nombre;

    @Column(nullable = false)
    private Integer dorsal;

    @Column(nullable = false)
    private Double velocidad;

    @Column(nullable = false)
    private Double peso;

    @Column(nullable = false)
    private Integer experiencia;
    
    private double metrosRecorridos;

    public CaballoEntity() {
    }

    public CaballoEntity(Long id, String nombre, Integer dorsal, Double velocidad, Double peso, Integer experiencia) {
        this.id = id;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.velocidad = velocidad;
        this.peso = peso;
        this.experiencia = experiencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }
    
    

    public CaballoEntity(Long id, String nombre, Integer dorsal, Double velocidad, Double peso, Integer experiencia,
			double metrosRecorridos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.velocidad = velocidad;
		this.peso = peso;
		this.experiencia = experiencia;
		this.metrosRecorridos = metrosRecorridos;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CaballoEntity)) return false;
        CaballoEntity that = (CaballoEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "CaballoEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dorsal=" + dorsal +
                ", velocidad=" + velocidad +
                ", peso=" + peso +
                ", experiencia=" + experiencia +
                '}';
    }
    
    
}

