package libreria.demo.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import libreria.demo.entidades.Libro;
import libreria.demo.servicios.LibroService;

@Controller
public class LibroController {
    
    @Autowired
    private LibroService libroService;

    @GetMapping("/libro")
    public String inicio(Model  model){
        var libros = libroService.listarLibros();
        model.addAttribute("libros",libros);
        return "libro.html";
    }

    @GetMapping("/agregarLibro")
    public String agregar(Libro libro){
        return "modificarLibro.html";
    }

    @PostMapping("/guardarLibro")
    public String guardar(@Valid Libro libro, Errors errores){
        if(errores.hasErrors()){
            return "modificarLibro.html";
        }
        libroService.guardarLibros(libro);
        return "redirect:/";
    }

    @GetMapping("/editar/{idlibro}")
    public String editar(Libro libro, Model model){
        libro = libroService.encontrarLibro(libro);
        model.addAttribute("libro",libro);
        return "modificarLibro.html";
    }

    @GetMapping("/eliminar/{idlibro}")
    public String eliminar(Libro libro){
        libroService.eliminarLibros(libro);
        return "redirect:/";
    }
}
