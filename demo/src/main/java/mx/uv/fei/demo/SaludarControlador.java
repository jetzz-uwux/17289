package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class SaludarControlador {
    static String nombre;
    
	@GetMapping ("/saludos")
	public static String saludar (){
		return "olaaa " + nombre + " :D"; 
	}
    @GetMapping ("/despedidas")
    public String despedirse(){
        System.out.println("adios:c");
        return "adios:c";
    }

    @PostMapping ("/nombramientos")
    public void nombre(){
        nombre = "Jetzaly";
    }

    @PutMapping("/nombramientos")
    public void met1() {
        nombre = "Nuevo Nombre";
    }

    @DeleteMapping("/nombramientos")
    public void met2() {
        nombre = null;
    }

}

