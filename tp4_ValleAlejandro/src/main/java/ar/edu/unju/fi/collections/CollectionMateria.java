package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Modalidad;

@Component
public class CollectionMateria {
	private static List<Materia> materias = new ArrayList<Materia>();
	
	public static List <Materia> getMateria(){
		if(materias.isEmpty()) {
			materias.add(new Materia(0, "Programacion Visual", 2, 100,new Docente(0, "Juan Carlos", "Rodriguez", "juancarlos33@fi.unju.edu.ar", 388412345),new Carrera(0, "APU", 3, true),Modalidad.VIRTUAL));
		}
		return materias;
	}
	
	public static void agregarMateria(Materia materia) {
		materias.add(materia);
	}
	
	public static void modificarMateria(Materia materia) {
		for(Materia m: materias) {
			if(m.getCodigo() == materia.getCodigo()) {
				m.setCarrera(materia.getCarrera());
				m.setCurso(materia.getCurso());
				m.setDocente(m.getDocente());
				m.setHoras(materia.getHoras());
				m.setModalidad(materia.getModalidad());
				m.setNombre(materia.getNombre());
			}
		}
	}
	
	public static void eliminarMateria(int codigo) {
		Iterator<Materia> iterator = materias.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCodigo()==codigo) {
				iterator.remove();
			}
		}
	}
	
	public static Materia buscarMateria(int codigo) {
		 Predicate<Materia> filterCodigo = c -> c.getCodigo() == codigo;
		 Optional <Materia> materia = materias.stream().filter(filterCodigo).findFirst();
		 if(materia.isPresent()) {
			 return materia.get();
		 }else {
			 return null;
		 }
	}
	
	
}
