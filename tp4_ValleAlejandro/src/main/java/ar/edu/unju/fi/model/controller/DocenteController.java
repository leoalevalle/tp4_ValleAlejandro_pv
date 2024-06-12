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

import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.model.Docente;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
	@Autowired
	
	private Docente docente;
	
	@GetMapping("/listado")
	public String getDocentePage(Model model) {
		model.addAttribute("docentes", CollectionDocente.getDocente());
		model.addAttribute("titulo", "Docentes");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "docentes";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoDocentePage(Model model) {
		boolean edicion = false;
		model.addAttribute("docente", docente);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva carrera");
		return "nuevoDocente";
	}
	
	
	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@ModelAttribute("docente") Docente docente) {
		ModelAndView modelView = new ModelAndView("docentes");
		String mensaje;
		boolean exito = CollectionDocente.agregarDocente(docente);
		if(exito) {
			mensaje ="Docente agregado con exito";
		}else {
			mensaje = "Docente no se pudo agregar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("docentes",CollectionDocente.getDocente());
		return modelView;
	}
	
	@GetMapping("/modificar/{legajo}")
	public String getmodificarDocente(Model model, @PathVariable(value="legajo")int legajo) {
		Docente docenteEncontrado = new Docente();
		boolean edicion = true;
		docenteEncontrado = CollectionDocente.buscarDocente(legajo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("docente", docenteEncontrado);
		model.addAttribute("titulo", "Modificar Docente");
		return "nuevoDocente";
	}
	
	@PostMapping("/modificar")
	public String modificarDocente(@ModelAttribute("docente")Docente docente, Model model) {
		boolean exito = false;
		String mensaje= "";
		try {
			CollectionDocente.modificarDocente(docente);
			mensaje = "El docente con legajo " + docente.getLegajo() + " fue modificado con exito";
			exito = true;
			}catch(Exception e) {
			mensaje = e.getMessage();
			e.printStackTrace();
		}
		model.addAttribute("exito", exito);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("docentes", CollectionDocente.getDocente());
		model.addAttribute("titulo", "Docentes");
		return "redirect:/docentes/listado";
	}
	
	
	@GetMapping("/eliminar/{legajo}")
	public String eliminarDocente(@PathVariable(value="legajo") int legajo) {
		CollectionDocente.eliminarDocente(legajo);
		return "redirect:/docentes/listado";
	}
	
	
}
