package libreria.demo.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import libreria.demo.entidades.Libro;
import libreria.demo.repositorios.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{


    @Autowired
    private LibroRepository libroRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {
        return (List<Libro>) libroRepository.findAll();
    }

    @Override
    @Transactional
    public void guardarLibros(Libro libro) {
       libroRepository.save(libro);
    }

    @Override
    @Transactional
    public void eliminarLibros(Libro libro) {
        libroRepository.delete(libro);
    }

    @Override
    @Transactional(readOnly = true)
    public Libro encontrarLibro(Libro libro) {
        return libroRepository.findById(libro.getIdLibro()).orElse(null);
    }
    
}
