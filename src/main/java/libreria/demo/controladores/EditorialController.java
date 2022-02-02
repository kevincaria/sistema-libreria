package libreria.demo.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import libreria.demo.entidades.Editorial;
import libreria.demo.servicios.EditorialService;

@Controller
public class EditorialController {
    
    @Autowired
    private EditorialService editorialService;

    @GetMapping("/Editorial")
    public String inicio(Model  model){
        var editoriales = editorialService.listarEditoriales();
        model.addAttribute("Editoriales",editoriales);
        return "Editorial.html";
    }

    @GetMapping("/agregarEditorial")
    public String agregar(Editorial editorial){
        return "modificarEditorial.html";
    }

    @PostMapping("/guardarEditorial")
    public String guardar(@Valid Editorial editorial, Errors errores){
        if(errores.hasErrors()){
            return "modificarEditorial.html";
        }
        editorialService.guardarEditorial(editorial);
        return "redirect:/";
    }

    @GetMapping("/editar/{idEditorial}")
    public String editar(Editorial editorial, Model model){
        editorial = editorialService.encontrarEditorial(editorial);
        model.addAttribute("Editorial",editorial);
        return "modificarEditorial.html";
    }

    @GetMapping("/eliminar/{idEditorial}")
    public String eliminar(Editorial editorial){
        editorialService.eliminarEditorial(editorial);
        return "redirect:/";
    }
}
