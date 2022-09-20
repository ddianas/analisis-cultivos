package ar.com.estudiocs.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tipo_muestras")
public class TipoDeMuestras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="nombre_cientifico")
    private String nombreCientifico;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_categoria", referencedColumnName = "id")
    private Categorias categoria;

    @Column(name="observacion")
    private String observacion;

    @Column(name="estado")
    private boolean estado;

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

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
