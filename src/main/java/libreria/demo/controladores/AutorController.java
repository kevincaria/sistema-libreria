package libreria.demo.controladores;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import libreria.demo.entidades.Autor;
import libreria.demo.servicios.AutorService;

@Controller
public class AutorController {
    
    @Autowired
    private AutorService autorService;

    @GetMapping("/autor")
    public String inicio(Model  model){
        var autores = autorService.listarAutor();
        model.addAttribute("autores",autores);
        return "autor.html";
    }

    @GetMapping("/agregarAutor")
    public String agregar(Autor autor){
        return "modificarAutor.html";
    }

    @PostMapping("/guardarAutor")
    public String guardar(@Valid Autor autor, Errors errores){
        if(errores.hasErrors()){
            return "modificarAutor.html";
        }
        autorService.guardarAutor(autor);
        return "redirect:/";
    }

    @GetMapping("/editar/{idAutor}")
    public String editar(Autor autor, Model model){
        autor = autorService.encontrarAutor(autor);
        model.addAttribute("autor",autor);
        return "modificarAutor.html";
    }

    @GetMapping("/eliminar/{idAutor}")
    public String eliminar(Autor autor){
        autorService.eliminarAutor(autor);
        return "redirect:/";
    }
}
