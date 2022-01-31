package libreria.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import libreria.demo.entidades.Editorial;

public interface EditorialRepository extends JpaRepository<Editorial,Long>{
    
}
