package es.cursojava.springbootmario.models;

public class CaballoDto {

	public Double getMetrosRecorridos() {
		return metrosRecorridos;
	}

	public void setMetrosRecorridos(Double metrosRecorridos) {
		this.metrosRecorridos = metrosRecorridos;
	}

	@Override
	public String toString() {
		return "CaballoDto [id=" + id + ", nombre=" + nombre + ", dorsal=" + dorsal + ", velocidad=" + velocidad
				+ ", peso=" + peso + ", experiencia=" + experiencia + "]";
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

	private Long id;
	private String nombre;
	private Integer dorsal;
	private Double velocidad;
	private Double peso;
	private Integer experiencia;
	private Double metrosRecorridos;
	
	public CaballoDto() {
		super();
	}

	public CaballoDto(Long id, String nombre, Integer dorsal, Double velocidad, Double peso, Integer experiencia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.velocidad = velocidad;
		this.peso = peso;
		this.experiencia = experiencia;
	}

	public CaballoDto(Long id, String nombre, Integer dorsal, Double velocidad, Double peso, Integer experiencia,
			Double metrosRecorridos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.velocidad = velocidad;
		this.peso = peso;
		this.experiencia = experiencia;
		this.metrosRecorridos = metrosRecorridos;
	}
	
	
	
	
	
	
	
}
