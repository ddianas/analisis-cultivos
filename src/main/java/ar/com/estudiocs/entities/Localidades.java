package ar.com.estudiocs.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="localidades")
public class Localidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="cod_postal")
    private Integer codigoPostal;

    @Column(name = "orden")
    private Integer orden;

    @Column(name="calle")
    private String calle;

    @Column(name="altura")
    private String altura;

    @Column(name="provincia")

    private Provincias provincia;

    @Column(name="localidad")
    private String descrip;

    public String getDescrip() {
        return descrip;
    }

    public void setLocalidad(String descrip) {
        this.descrip = descrip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public Provincias getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincias provincia) {
        this.provincia = provincia;
    }
}
