package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class Alumno {
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	private LocalDate fechaNac;
	private int lu;
	
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	

	public Alumno(int dni, String nombre, String apellido, String email, int telefono, LocalDate fechaNac, int lu) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.lu = lu;
	}



	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public LocalDate getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}



	public int getLu() {
		return lu;
	}



	public void setLu(int lu) {
		this.lu = lu;
	}



	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", fechaNac=" + fechaNac + ", lu=" + lu + "]";
	}
	
	
	


	
	
	
}
