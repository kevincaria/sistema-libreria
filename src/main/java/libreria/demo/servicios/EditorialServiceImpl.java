package libreria.demo.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import libreria.demo.entidades.Editorial;
import libreria.demo.repositorios.EditorialRepository;

@Service
public class EditorialServiceImpl implements EditorialService{

    @Autowired
    private EditorialRepository editorialRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {
        return (List<Editorial>)editorialRepository.findAll();
    }

    @Override
    @Transactional
    public void guardarEditorial(Editorial editorial) {
        editorialRepository.save(editorial);
    }

    @Override
    @Transactional
    public void eliminarEditorial(Editorial editorial) {
        editorialRepository.delete(editorial);
    }

    @Override
    @Transactional(readOnly = true)
    public Editorial encontrarEditorial(Editorial editorial) {
        return editorialRepository.findById(editorial.getIdEditorial()).orElse(null);
    }
    
}
