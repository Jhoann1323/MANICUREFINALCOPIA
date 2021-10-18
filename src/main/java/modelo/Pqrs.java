/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhoann
 */
@Entity
@Table(name = "pqrs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pqrs.findAll", query = "SELECT p FROM Pqrs p"),
    @NamedQuery(name = "Pqrs.findByIdpqrs", query = "SELECT p FROM Pqrs p WHERE p.idpqrs = :idpqrs"),
    @NamedQuery(name = "Pqrs.findByNombreCliente", query = "SELECT p FROM Pqrs p WHERE p.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Pqrs.findByApellidoCliente", query = "SELECT p FROM Pqrs p WHERE p.apellidoCliente = :apellidoCliente"),
    @NamedQuery(name = "Pqrs.findByCorreo", query = "SELECT p FROM Pqrs p WHERE p.correo = :correo"),
    @NamedQuery(name = "Pqrs.findByComentarioCliente", query = "SELECT p FROM Pqrs p WHERE p.comentarioCliente = :comentarioCliente"),
    @NamedQuery(name = "Pqrs.findByComentarioAdmin", query = "SELECT p FROM Pqrs p WHERE p.comentarioAdmin = :comentarioAdmin"),
    @NamedQuery(name = "Pqrs.findByFechaRegistro", query = "SELECT p FROM Pqrs p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Pqrs.findByCalificacion", query = "SELECT p FROM Pqrs p WHERE p.calificacion = :calificacion")})
public class Pqrs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpqrs")
    private Integer idpqrs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreCliente")
    private String nombreCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidoCliente")
    private String apellidoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "comentarioCliente")
    private String comentarioCliente;
    @Size(max = 300)
    @Column(name = "comentarioAdmin")
    private String comentarioAdmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "calificacion")
    private String calificacion;
    @JoinColumn(name = "tipo_pqrs", referencedColumnName = "idtipoPqrs")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipopqrs tipoPqrs;

    public Pqrs() {
    }

    public Pqrs(Integer idpqrs) {
        this.idpqrs = idpqrs;
    }

    public Pqrs(Integer idpqrs, String nombreCliente, String apellidoCliente, String correo, String comentarioCliente, Date fechaRegistro, String calificacion) {
        this.idpqrs = idpqrs;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.correo = correo;
        this.comentarioCliente = comentarioCliente;
        this.fechaRegistro = fechaRegistro;
        this.calificacion = calificacion;
    }

    public Integer getIdpqrs() {
        return idpqrs;
    }

    public void setIdpqrs(Integer idpqrs) {
        this.idpqrs = idpqrs;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getComentarioCliente() {
        return comentarioCliente;
    }

    public void setComentarioCliente(String comentarioCliente) {
        this.comentarioCliente = comentarioCliente;
    }

    public String getComentarioAdmin() {
        return comentarioAdmin;
    }

    public void setComentarioAdmin(String comentarioAdmin) {
        this.comentarioAdmin = comentarioAdmin;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public Tipopqrs getTipoPqrs() {
        return tipoPqrs;
    }

    public void setTipoPqrs(Tipopqrs tipoPqrs) {
        this.tipoPqrs = tipoPqrs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpqrs != null ? idpqrs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pqrs)) {
            return false;
        }
        Pqrs other = (Pqrs) object;
        if ((this.idpqrs == null && other.idpqrs != null) || (this.idpqrs != null && !this.idpqrs.equals(other.idpqrs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pqrs[ idpqrs=" + idpqrs + " ]";
    }
    
}
