package mx.uv.fei.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin (origins = "*")
@RestController 
public class SaludarControlador {
    static String nombre;
    Saludador saludador; // Variable de clase
    
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

    @GetMapping ("/saludador/{nombre}")
    public Saludador met3(@PathVariable String nombre){

        return new Saludador(nombre);
    }

    @RequestMapping ("/saludador2/{nombrep}")
    public Saludador met4(@PathVariable("nombrep")String nombre){
        System.out.println("get: " + nombre);
        saludador = new Saludador(nombre);
        return saludador;
    }

    @RequestMapping("/")
    public String indice(){
        return """
            <h1>Menú principal</h1>
            <ul>
                <li><a href=/saludos>saludos</a></li>
                <li><a href=/despedidas>/despedidas</a></li>
                <li>nombramientos (Post | Put | Delete)</li>
                <li><a href=/saludador/default>/saludador</a></li>
                <li><a href=/saludador2/default2>/saludador2</a></li>
                <li>/crearSaludador (Post)</li>
                <li><a href=/obtenerSaludador>/obtenerSaludador</a></li>
                <li><a href=getQuery>/getQuery?nombre=xxx&paterno=yyy</a></li>
                <li><a href=getQuery2>/getQuery2?nombre=xxx[&paterno=yyy]</a></li>

            </ul>
        """;
    }

    @PostMapping ("/crearSaludador") // Setter
    public void crearSaludador(@RequestBody Saludador nombre){
        System.out.println("post: " + nombre);
        saludador = nombre;
    }

    @GetMapping ("/obtenerSaludador") // Getter
    public Saludador obtenerSaludador(){
        return saludador;
    }
   
    // ------- @RequestParam --------

    @GetMapping ("/getQuery")
    public String getQuerySreing(@RequestParam String nombre, @RequestParam String paterno){
        return nombre + " " + paterno;
    }

    @GetMapping ("/getQuery2")
    public String getQuerySreing2(@RequestParam String nombre, @RequestParam (defaultValue = "")String paterno){
        return nombre + " " + paterno;
    }
}

