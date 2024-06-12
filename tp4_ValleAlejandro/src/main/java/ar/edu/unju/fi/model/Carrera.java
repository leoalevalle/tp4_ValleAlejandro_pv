package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {
	private int codigo;
	private String nombre;
	private int cant_anios;
	private boolean estado;
	
	public Carrera() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Carrera(int codigo, String nombre, int cant_anios, boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cant_anios = cant_anios;
		this.estado = estado;
	}




	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCant_anios() {
		return cant_anios;
	}

	public void setCant_anios(int cant_anios) {
		this.cant_anios = cant_anios;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}




	@Override
	public String toString() {
		return "Carrera [codigo=" + codigo + ", nombre=" + nombre + ", cant_anios=" + cant_anios + ", estado=" + estado
				+ "]";
	}
}
