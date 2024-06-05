package ar.edu.unju.fi.model;

public class Carrera {
	public int codigo;
	public String nombre;
	public int cantAnios;
	public String estado;
	
	public Carrera(int codigo, String nombre, int cantAnios, String estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantAnios = cantAnios;
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
	public int getCantAnios() {
		return cantAnios;
	}
	public void setCantAnios(int cantAnios) {
		this.cantAnios = cantAnios;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
