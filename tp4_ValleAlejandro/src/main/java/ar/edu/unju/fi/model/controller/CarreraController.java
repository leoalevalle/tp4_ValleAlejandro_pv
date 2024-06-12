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
import ar.edu.unju.fi.model.Carrera;

@Controller
@RequestMapping("/carreras")
public class CarreraController {
	@Autowired
	
	private Carrera carrera;
	
	@GetMapping("/listado")
	public String getCarreraPage(Model model) {
		model.addAttribute("carreras", CollectionCarrera.getCarrera());
		model.addAttribute("titulo", "Carrerras");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "carreras";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		boolean edicion = false;
		model.addAttribute("carrera", carrera);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva Carrera");
		return "carrera";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@ModelAttribute("carrera") Carrera carrera) { //objeto
		ModelAndView modelView = new ModelAndView("carreras"); //pagina html
		String mensaje;
		carrera.setEstado(true);
		boolean exito = CollectionCarrera.agregarCarrera(carrera);
		if(exito) {
			mensaje= "Carrera guardada con exito";
		}else {
			mensaje = "Carrera no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje",mensaje);
		modelView.addObject("carreras",CollectionCarrera.getCarrera()); //el primer parametro "carreras" hace referencia al "${carreras}" de mi html de carreras en donde se hace un th:each
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="codigo") int codigo) {
		Carrera carreraEncontrada = new Carrera();
		boolean edicion = true;
		carreraEncontrada = CollectionCarrera.buscarCarrera(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("carrera", carreraEncontrada); //objeto
		model.addAttribute("titulo", "Modificar Carrera");
		return "carrera";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") Carrera carrera, Model model) {
		boolean exito = false;
		String mensaje = "";
		try {
			CollectionCarrera.modificarCarrera(carrera);
			mensaje = "La carrera con codigo " + carrera.getCodigo() + " fue modificado con exito!";
			exito = true;
		} catch (Exception e) {
			mensaje = e.getMessage();
			e.printStackTrace();
		}
		model.addAttribute("exito",exito);
		model.addAttribute("mensaje", mensaje);
		model.addAttribute("carrera", CollectionCarrera.getCarrera());
		model.addAttribute("titulo", "Carreras");
		return "redirect:/carreras/listado";
	}
	
	@GetMapping("/eliminar/{codigo}")
	public String eliminarCarrer(@PathVariable(value="codigo") int codigo) {
		CollectionCarrera.eliminarCarrera(codigo);
		return "redirect:/carreras/listado";
		
	}
}
