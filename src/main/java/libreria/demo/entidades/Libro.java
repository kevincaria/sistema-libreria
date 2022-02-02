package libreria.demo.entidades;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "libro")
public class Libro implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    @NotEmpty
    private Long isbn;

    @NotEmpty
    private String titulo;

    @NotEmpty
    private Integer anio;

    private Integer ejemplares;
    private Integer ejemplaresPrestados;
    private Integer ejemplaresRestantes;
    private Boolean Alta;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor",referencedColumnName = "id_autor")
    private Autor autor;
    
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_editorial",referencedColumnName = "id_autor")
    private Editorial editorial;
    
}
