/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import ejb.OrdenPagoFacadeLocal;
import ejb.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.OrdenPago;
import modelo.Usuario;

/**
 *
 * @author dacue
 */
@Named(value = "ordenPagoSesion")
@SessionScoped
public class OrdenPagoSesion implements Serializable {

    @EJB
    private OrdenPagoFacadeLocal ordenPagoFacadeLocal;
   
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;

    private OrdenPago ordenPago;
    
    @Inject
    private Usuario usuario;

    private List<OrdenPago> ordenPagos;
    private List<Usuario> usuarios;

    private OrdenPago orReg = new OrdenPago();
    private OrdenPago orTemporal = new OrdenPago();

    @PostConstruct
    public void init() {
        ordenPagos = ordenPagoFacadeLocal.findAll();
        usuarios = usuarioFacadeLocal.findAll();
        ordenPago = new OrdenPago();

    }

    public void registrarOrdenPago() {
        try {
            orReg.setUsuarioIdUsuario(usuario);
            ordenPagoFacadeLocal.create(orReg);
            ordenPagos = ordenPagoFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }

    public void guardarTemporal(OrdenPago o) {
        orTemporal = o;
    }

    public void editarOrdenPago() {
        try {
            orTemporal.setUsuarioIdUsuario(usuario);
            ordenPagoFacadeLocal.edit(orTemporal);
            ordenPagos = ordenPagoFacadeLocal.findAll();
        } catch (Exception e) {
        }

    }

    public void eliminarOrdenPago(OrdenPago o) {
        try {
            ordenPagoFacadeLocal.remove(o);
            ordenPagos = ordenPagoFacadeLocal.findAll();
        } catch (Exception e) {
        }

    }

    public OrdenPago getOrdenPago() {
        return ordenPago;
    }

    public void setOrdenPago(OrdenPago ordenPago) {
        this.ordenPago = ordenPago;
    }

       public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<OrdenPago> getOrdenPagos() {
        return ordenPagos;
    }

    public void setOrdenPagos(List<OrdenPago> ordenPagos) {
        this.ordenPagos = ordenPagos;
    }

   
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public OrdenPago getOrReg() {
        return orReg;
    }

    public void setOrReg(OrdenPago orReg) {
        this.orReg = orReg;
    }

    public OrdenPagoFacadeLocal getOrdenPagoFacadeLocal() {
        return ordenPagoFacadeLocal;
    }

    public void setOrdenPagoFacadeLocal(OrdenPagoFacadeLocal ordenPagoFacadeLocal) {
        this.ordenPagoFacadeLocal = ordenPagoFacadeLocal;
    }

    public UsuarioFacadeLocal getUsuarioFacadeLocal() {
        return usuarioFacadeLocal;
    }

    public void setUsuarioFacadeLocal(UsuarioFacadeLocal usuarioFacadeLocal) {
        this.usuarioFacadeLocal = usuarioFacadeLocal;
    }

    public OrdenPago getOrTemporal() {
        return orTemporal;
    }

    public void setOrTemporal(OrdenPago orTemporal) {
        this.orTemporal = orTemporal;
    }

   
    

}
