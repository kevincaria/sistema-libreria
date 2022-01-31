package libreria.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import libreria.demo.entidades.Libro;

public interface LibroRepository extends JpaRepository<Libro,Long>{
    
}
