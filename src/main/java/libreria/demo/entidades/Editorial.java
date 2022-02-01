package libreria.demo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "editorial")
public class Editorial implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEditorial;

    @NotEmpty
    private String nombre;

    private Boolean alta;

    @OneToMany(mappedBy = "editorial")
    @JoinColumn(name = "id_libro",referencedColumnName = "id_libro")
    private List<Libro> libros;
}
