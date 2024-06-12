package ar.edu.unju.fi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Materia {
	private int codigo;
	private String nombre;
	private int curso;
	private int horas;
	@Autowired
	private Docente docente;
	@Autowired
	private Carrera carrera;
	private Modalidad modalidad;

	public Materia() {
		// TODO Auto-generated constructor stub
	}

	public Materia(int codigo, String nombre, int curso, int horas, Docente docente, Carrera carrera, Modalidad modalidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.curso = curso;
		this.horas = horas;
		this.docente = docente;
		this.carrera = carrera;
		this.modalidad = modalidad;
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
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	public Modalidad getModalidad() {
		return modalidad;
	}
	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	
	
}

