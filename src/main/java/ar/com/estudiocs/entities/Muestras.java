package ar.com.estudiocs.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="muestras")
public class Muestras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="num_ope")
    private Integer numeroOperacion;

    @Column(name="f_ingreso")
    private Date fechaIngreso;

    @Column(name="f_cierre")
    private Date fechaCierre;

    @Column(name="con_ingreso")
    private String conceptoIngreso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_tipomuestra",referencedColumnName = "id")
    private TipoDeMuestras tipoMuestra;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "fk_persona", referencedColumnName = "id",nullable=false)
    private Personal persona;

    @Column(name="estado")
    private boolean estado;

    @Column(name="observacion")
    private String observacion;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "fk_profesional", referencedColumnName = "id",nullable=false)
    private Profesionales profesionales;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroOperacion() {
        return numeroOperacion;
    }

    public void setNumeroOperacion(Integer numeroOperacion) {
        this.numeroOperacion = numeroOperacion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public String getConceptoIngreso() {
        return conceptoIngreso;
    }

    public void setConceptoIngreso(String conceptoIngreso) {
        this.conceptoIngreso = conceptoIngreso;
    }

    public TipoDeMuestras getTipoMuestra() {
        return tipoMuestra;
    }

    public void setTipoMuestra(TipoDeMuestras tipoMuestra) {
        this.tipoMuestra = tipoMuestra;
    }

    public Personal getPersona() {
        return persona;
    }

    public void setPersona(Personal persona) {
        this.persona = persona;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Profesionales getprofesionales() {
        return profesionales;
    }

    public void setprofesionales( Profesionales profesionales) {
        this.profesionales = profesionales;
    }

}
