package ar.edu.unju.fi.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Modalidad;

@Controller
@RequestMapping("/materias")
public class MateriaController {
	
	
	@Autowired
	private Carrera carrera;
	@Autowired
	private Docente docente;
	
	
	@GetMapping("/listado")
	public String getMateriasPage(Model model) {
		model.addAttribute("titulo", "Lista de Materias");
		model.addAttribute("materias", CollectionMateria.getMateria());
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "materias";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoPage(Model model) {
	    boolean edicion = false;
	    Materia materia = new Materia();
	    model.addAttribute("modalidad", Modalidad.values());
	    model.addAttribute("docentes", CollectionDocente.getDocente());
	    model.addAttribute("carreras", CollectionCarrera.getCarrera());
	    model.addAttribute("materia", materia);
	    model.addAttribute("edicion", edicion);
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
	    return "nuevaMateria";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@ModelAttribute("materia") Materia materia) {
		ModelAndView modelView = new ModelAndView("materias");
		carrera = CollectionCarrera.buscarCarrera(materia.getCarrera().getCodigo());
		docente = CollectionDocente.buscarDocente(materia.getDocente().getLegajo());
		materia.setCarrera(carrera);
		materia.setDocente(docente);
		CollectionMateria.agregarMateria(materia);
		modelView.addObject("materias", CollectionMateria.getMateria());
		modelView.addObject("exito", false);
		modelView.addObject("mensaje", "");
		return modelView;
		
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable(value="codigo") int codigo) {
		Materia materiaBuscar = new Materia();
		boolean edicion = true;
		materiaBuscar = CollectionMateria.buscarMateria(codigo);
		model.addAttribute("modalidad", Modalidad.values());
		model.addAttribute("edicion", edicion);
		model.addAttribute("materia", materiaBuscar);
		model.addAttribute("docentes", CollectionDocente.getDocente());
		model.addAttribute("carreras", CollectionCarrera.getCarrera());
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "nuevaMateria";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("matria") Materia materia, Model model) {
		carrera = CollectionCarrera.buscarCarrera(materia.getCarrera().getCodigo());
		docente = CollectionDocente.buscarDocente(materia.getDocente().getLegajo());
		materia.setCarrera(carrera);
		materia.setDocente(docente);
		CollectionMateria.modificarMateria(materia);
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "redirect:/materias/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarMateria(@PathVariable(value="codigo") int codigo) {
		CollectionMateria.eliminarMateria(codigo);
		return "redirect:/materias/listado";
	}
}
