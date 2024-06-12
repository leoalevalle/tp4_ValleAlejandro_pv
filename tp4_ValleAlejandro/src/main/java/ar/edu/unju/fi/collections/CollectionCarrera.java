package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class CollectionCarrera {
	private static List<Carrera> carreras = new ArrayList<>();
	
	public static List<Carrera> getCarrera(){
		if(carreras.isEmpty()) {
			carreras.add(new Carrera(1,"A.P.U",3,true));
		}
		return carreras;
	}
	
	public static boolean agregarCarrera(Carrera carrera) {
		return carreras.add(carrera) ? true : false;
	}
	
	public static void eliminarCarrera(int codigoCarrera) {
		Iterator<Carrera> iterator = carreras.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCodigo()==codigoCarrera) {
				iterator.remove();
			}
		}
	}
	
	public static void modificarCarrera(Carrera carrera)throws Exception {
		boolean encontrado = false;
		try {
			for(Carrera carre : carreras) {
				if(carre.getCodigo() == carrera.getCodigo()) {
					carre.setNombre(carrera.getNombre());
					carre.setCant_anios(carrera.getCant_anios());
					carre.setEstado(carrera.isEstado());
					
				}
			}
			if(!encontrado) {
				throw new Exception("La carrera con codigo " + carrera.getCodigo() + " no existe");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	public static Carrera buscarCarrera(int codigo) {
		Predicate<Carrera> filterCodigo = c -> c.getCodigo()==codigo;
		Optional<Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
		if(carrera.isPresent()) {
			return carrera.get();
		}else {
			return null;
		}
	}
}
