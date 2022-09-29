package ar.com.estudiocs.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name="tramo")
    private Tramos tramo;

    @Column(name="profesionales")
    private Profesionales profesionales;

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

    public Tramos getTramo() {
        return tramo;
    }

    public void setTramo(Tramos tramo) {
        this.tramo = tramo;
    }

    public Profesionales getProfesionales() {
        return profesionales;
    }

    public void setProfesionales(Profesionales profesionales) {
        this.profesionales = profesionales;
    }
}
