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

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.model.Alumno;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
	@Autowired
	
	private Alumno alumno;
	
	@GetMapping("/listado")
	public String getAlumnoPage(Model model) {
		model.addAttribute("alumnos", CollectionAlumno.getAlumno());
		model.addAttribute("titulo", "Alumnos");
		model.addAttribute("exito", false);
		model.addAttribute("mensaje", "");
		return "alumnos";
	}
	
	@GetMapping("/nuevo")
	public String getNuevoAlumnoPage(Model model) {
		boolean edicion = false;
		model.addAttribute("alumno", alumno);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nuevo alumno");
		return "alumno";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		ModelAndView modelView = new ModelAndView("alumnos");
		String mensaje;
		boolean exito = CollectionAlumno.agregarAlumno(alumno);
		if(exito) {
			mensaje = " Alumno guardado con exito";
		}else {
			mensaje = " Alumno no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("alumnos", CollectionAlumno.getAlumno());
		return modelView;
	}
	
	@GetMapping("/modificar/{lu}")
	public String getModificarAlumnoPage(Model model, @PathVariable(value="lu") int lu) {
		Alumno alumnoEncontrado = new Alumno();
		boolean edicion = true;
		alumnoEncontrado = CollectionAlumno.buscarAlumno(lu);
		model.addAttribute("edicion", edicion);
		model.addAttribute("alumno", alumnoEncontrado);
		model.addAttribute("titulo", "Modificar Alumno");
		return "nuevoAlumno";
	}
	
	@PostMapping("/modificar")
	public String modificarAlumno(@ModelAttribute("alumno") Alumno alumno, Model model) {
		boolean exito = false;
		String mensaje = "";
		try {
			CollectionAlumno.modificarAlumno(alumno);
			mensaje= "El alumno con LU" + alumno.getLu() + " fue modificado con exito!";
			exito = true;
			}catch(Exception e) {
				mensaje = e.getMessage();
				e.printStackTrace();
			}
		model.addAttribute("exito", exito);
		model.addAttribute("mensaje",mensaje);
		model.addAttribute("alumno", mensaje);
		model.addAttribute("titulo", "Alumno");
		return "redirect:/alumnos/listado";
	}
	
	@GetMapping("/eliminar/{lu}")
	public String eliminarAlumnoPage(@PathVariable(value="lu")int lu) {
		CollectionAlumno.eliminarAlumno(lu);
		return "redirect:/alumnos/listado";
	}
}
