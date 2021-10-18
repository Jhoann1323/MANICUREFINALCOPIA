/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Pqrs;
import modelo.Tipopqrs;

/**
 *
 * @author jhoann
 */
@Stateless
public class PqrsFacade extends AbstractFacade<Pqrs> implements PqrsFacadeLocal {

    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PqrsFacade() {
        super(Pqrs.class);
    }
    @Override
    public boolean actualizarPqrs(Pqrs pIn){
        try {
            Query q = em.createNativeQuery("UPDATE pqrs set comentarioAdmin = ? WHERE(idpqrs=?) ");
            q.setParameter(1, pIn.getComentarioAdmin());
            q.setParameter(2, pIn.getIdpqrs());
            q.executeUpdate(); 
            return true ; 
        } catch (Exception e) {
            return false ; 
        }
   }
    
    @Override
      public boolean registrarPqrs(Pqrs pIn,Tipopqrs fktipo){
        try {
            Query q = em.createNativeQuery("INSERT INTO pqrs nombreCliente, apellidoCliente, correo, comentarioCliente, fechaRegistro, tipo_pqrs, calificacion) VALUES ( ?, ?, ?, ?, ?, ?,?)");
            q.setParameter(1, pIn.getNombreCliente());
            q.setParameter(2, pIn.getApellidoCliente());
            q.setParameter(3, pIn.getCorreo());
            q.setParameter(4, pIn.getComentarioCliente());
            q.setParameter(5, pIn.getFechaRegistro());
            q.setParameter(6, fktipo.getIdtipoPqrs());
            q.setParameter(7, pIn.getCalificacion());
            q.executeUpdate(); 
            return true ; 
        } catch (Exception e) {
            return false ; 
        }
    }


}
