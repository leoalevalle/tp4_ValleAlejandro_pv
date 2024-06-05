package ar.edu.unju.fi.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	 
	@GetMapping("/")
	    public String home() {
	        return "index"; // Nombre de la plantilla Thymeleaf (index.html)
	    }
}
