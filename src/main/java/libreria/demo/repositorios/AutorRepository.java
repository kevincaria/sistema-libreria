package libreria.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import libreria.demo.entidades.Autor;

public interface AutorRepository extends JpaRepository<Autor,Long>{
    
}
