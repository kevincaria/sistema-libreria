package libreria.demo.servicios;

import java.util.List;

import libreria.demo.entidades.Editorial;

public interface EditorialService {
    
    public List<Editorial> listarEditoriales();

    public void guardarEditorial(Editorial editorial);

    public void eliminarEditorial(Editorial editorial);

    public Editorial encontrarEditorial(Editorial editorial);

}
