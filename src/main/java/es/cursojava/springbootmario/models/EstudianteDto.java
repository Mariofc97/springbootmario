package es.cursojava.springbootmario.models;

public class EstudianteDto {

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	private String nombre;
	private String email;
	private int edad;
	private String curso;
	public EstudianteDto(String nombre, String email, int edad, String curso) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
		this.curso = curso;
	}
	
	
}
