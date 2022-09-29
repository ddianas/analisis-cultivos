package ar.com.estudiocs.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="tramos")
public class Tramos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name="descripcion")
    private String descripcion;
}
