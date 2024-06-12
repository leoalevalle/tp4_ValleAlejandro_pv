package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;

@Component
public class CollectionDocente {
	static List<Docente> docentes = new ArrayList<>();

	public static List<Docente> getDocente(){
		if(docentes.isEmpty()) {
			docentes.add(new Docente(123, "Juan Carlos", "Rodriguez", "juancarlos33@fi.unju.edu.ar",388412345));
		}
		return docentes;
	}
	
	public static boolean agregarDocente(Docente docente) {
		return docentes.add(docente) ? true : false;
	}
	
	public static void eliminarDocente(int legajo) {
		Iterator<Docente> iterator = docentes.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getLegajo()==legajo) {
				iterator.remove();
			}
		}
	}
	
	
	public static void modificarDocente(Docente docente) throws Exception{
		boolean encontrado = false;
		try {
			for(Docente d: docentes) {
				if(d.getLegajo()==docente.getLegajo()) {
					d.setNombre(docente.getNombre());
					d.setApellido(docente.getApellido());
					d.setEmail(docente.getEmail());
					d.setTelefono(docente.getTelefono());
				}
			}
			if(!encontrado) {
				throw new Exception("El docente con legajo " + docente.getLegajo() + " no existe");			
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	public static Docente buscarDocente(int legajo) {
		Predicate<Docente> filterLegajo = l -> l.getLegajo()==legajo;
		Optional<Docente> docente = docentes.stream().filter(filterLegajo).findFirst();
		if(docente.isPresent()) {
			return docente.get();
		}else {
			return null;
		}
	}
}
