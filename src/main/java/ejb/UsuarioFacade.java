/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Usuario;

/**
 *
 * @author Frederick Bosa S
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario recuperarClave(String correoIn) {
        try {
            Query qt = em.createQuery("SELECT u FROM Usuario u WHERE u.correo = :correo");
            qt.setParameter("correo", correoIn);
            return (Usuario) qt.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
   

    @Override
    public Usuario encontrarUsuarioCorreo(String correo){
        Query q = em.createNamedQuery("Usuario.findByCorreo", Usuario.class).setParameter("correo", correo);
        
        List<Usuario> listado = q.getResultList();
        
        if(!listado.isEmpty()){
            return listado.get(0);
        }
        return null;
    }
     @Override
    public List<String> leerCorreosAdmin() {
        Query q = em.createNativeQuery("SELECT correo FROM usuario where rol_id_rol = 3");
        
        List<Usuario> listado = q.getResultList();
        
        if(!listado.isEmpty()){
            return q.getResultList();
        }
        return null;
    }
    
    
}
