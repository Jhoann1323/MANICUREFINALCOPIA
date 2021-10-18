/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author dacue
 */
@Entity
@Table(name = "orden_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenPago.findAll", query = "SELECT o FROM OrdenPago o"),
    @NamedQuery(name = "OrdenPago.findByIdOrden", query = "SELECT o FROM OrdenPago o WHERE o.idOrden = :idOrden"),
    @NamedQuery(name = "OrdenPago.findByFechaOrden", query = "SELECT o FROM OrdenPago o WHERE o.fechaOrden = :fechaOrden"),
    @NamedQuery(name = "OrdenPago.findByNit", query = "SELECT o FROM OrdenPago o WHERE o.nit = :nit"),
    @NamedQuery(name = "OrdenPago.findByProveedor", query = "SELECT o FROM OrdenPago o WHERE o.proveedor = :proveedor"),
    @NamedQuery(name = "OrdenPago.findByRazonSocial", query = "SELECT o FROM OrdenPago o WHERE o.razonSocial = :razonSocial"),
    @NamedQuery(name = "OrdenPago.findByValorTotal", query = "SELECT o FROM OrdenPago o WHERE o.valorTotal = :valorTotal"),
    @NamedQuery(name = "OrdenPago.findByInsumoIdInsumo", query = "SELECT o FROM OrdenPago o WHERE o.insumoIdInsumo = :insumoIdInsumo")})
public class OrdenPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_orden")
    private Integer idOrden;
    @Column(name = "fecha_orden")
    @Temporal(TemporalType.DATE)
    private Date fechaOrden;
    @Column(name = "nit")
    private Integer nit;
    @Size(max = 45)
    @Column(name = "proveedor")
    private String proveedor;
    @Size(max = 255)
    @Column(name = "razon_social")
    private String razonSocial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total")
    private Float valorTotal;
    @Column(name = "insumo_id_insumo")
    private Integer insumoIdInsumo;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioIdUsuario;

    public OrdenPago() {
    }

    public OrdenPago(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    
    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenPago)) {
            return false;
        }
        OrdenPago other = (OrdenPago) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.OrdenPago[ idOrden=" + idOrden + " ]";
    }
    
}
