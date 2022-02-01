package libreria.demo.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import libreria.demo.entidades.Autor;
import libreria.demo.repositorios.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService{

    @Autowired
    private AutorRepository autorRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Autor> listarAutor() {
        return (List<Autor>) autorRepository.findAll();
    }

    @Override
    @Transactional
    public void guardarAutor(Autor autor) {
        autorRepository.save(autor);
    }

    @Override
    @Transactional
    public void eliminarAutor(Autor autor) {
        autorRepository.delete(autor); 
    }

    @Override
    @Transactional(readOnly = true)
    public Autor encontrarAutor(Autor autor) {
        return autorRepository.findById(autor.getIdAutor()).orElse(null);
    }
    
}
