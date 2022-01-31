package libreria.demo.servicios;

import java.util.List;

import libreria.demo.entidades.Autor;

public interface AutorService {
    
    public List<Autor> listarAutor();

    public void guardarAutor(Autor autor);

    public void eliminarAutor(Autor autor);

    public Autor encontrarAutor(Autor autor);
}
