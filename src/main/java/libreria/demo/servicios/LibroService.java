package libreria.demo.servicios;

import java.util.List;

import libreria.demo.entidades.Libro;

public interface LibroService {
    
    public List<Libro> listasLibros();

    public void guardarLibros(Libro libro);

    public void eliminarLibros(Libro libro);

    public Libro encontrarLibro(Libro libro);
}
