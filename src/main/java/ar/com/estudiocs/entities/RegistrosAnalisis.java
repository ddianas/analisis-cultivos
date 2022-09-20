package ar.com.estudiocs.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="analisis")
public class RegistrosAnalisis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="fecha")
    private Date fecha;

    @Column(name="resultado")
    private String resultado;

    @Column(name="parametros")
    private String parametros;

    @Column(name="observacion")
    private String observacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_tramos")
    private List<Tramos> tramo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fk_profesional")
    private List<Profesionales> profesionales;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public List<Tramos> getTramo() {
        return tramo;
    }

    public void setTramo(List<Tramos> tramo) {
        this.tramo = tramo;
    }

    public List<Profesionales> getProfesionales() {
        return profesionales;
    }

    public void setProfesionales(List<Profesionales> profesionales) {
        this.profesionales = profesionales;
    }
}
