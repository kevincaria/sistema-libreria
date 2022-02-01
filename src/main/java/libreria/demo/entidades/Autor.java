package libreria.demo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "autor")
public class Autor implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAutor;

    @NotEmpty
    private String nombre;

    private Boolean alta;

    @OneToMany(mappedBy = "autor")
    @JoinColumn(name = "id_libro",referencedColumnName = "id_libro")
    private List<Libro> libros;
}
