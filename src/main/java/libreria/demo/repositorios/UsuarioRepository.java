package libreria.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import libreria.demo.entidades.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    Usuario findByUsername(String username);
}
