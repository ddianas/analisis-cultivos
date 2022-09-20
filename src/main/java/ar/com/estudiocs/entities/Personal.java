package ar.com.estudiocs.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="personal")
public class Personal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="direccion")
    private String direccion;

    @Column(name="email")
    private String email;

    @Column(name="telefono")
    private Integer telefono;

    @Column(name="observacion")
    private String observacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_localidad", referencedColumnName = "id")
    private Localidades localidad;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Localidades getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidades localidad) {
        this.localidad = localidad;
    }

}
