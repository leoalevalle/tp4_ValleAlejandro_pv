package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class CollectionAlumno {
	private static List<Alumno> alumnos = new ArrayList<>();
	
	public static List<Alumno> getAlumno(){
		if(alumnos.isEmpty()) {
			alumnos.add(new Alumno(123456,"Alejandro","Valle","valle@ejemplo.com",388412345,LocalDate.of(1997, 4, 19), 1234));
		}
		return alumnos;
	}
	
	public static boolean agregarAlumno(Alumno alumno) {
		return alumnos.add(alumno) ? true : false;
	}
	
	public static void eliminarAlumno(int lu) {
		Iterator<Alumno> iterator = alumnos.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getLu()==lu) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarAlumno(Alumno alumno) throws Exception{
		boolean encontrado = false;
		try {
			for(Alumno a: alumnos) {
				if(a.getLu() == alumno.getLu()) {
					a.setDni(alumno.getDni());
					a.setNombre(alumno.getNombre());
					a.setApellido(alumno.getApellido());
					a.setEmail(alumno.getApellido());
					a.setTelefono(alumno.getTelefono());
					a.setFechaNac(a.getFechaNac());
					a.setLu(alumno.getLu());
				}
			}
			if(!encontrado) {
				throw new Exception("El alumno no existe");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	public static Alumno buscarAlumno(int LU) {
		Predicate<Alumno> filterLU = l -> l.getLu() == LU;
		Optional<Alumno> alumno = alumnos.stream().filter(filterLU).findFirst();
		if(alumno.isPresent()) {
			return alumno.get();
		}else {
			return null;
		}
	}
}
