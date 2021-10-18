/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import ejb.PqrsFacadeLocal;
import ejb.TipopqrsFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Pqrs;
import modelo.Tipopqrs;
// import utilidades.PqrsMailRespuesta;

//import utilidades.PqrsNotificacionAdministrador; 

/**
 *
 * @author maye 
 */
@Named(value="pqrsSesion")
@SessionScoped
public class PqrsSesion implements Serializable {
    
    
    @EJB
    private PqrsFacadeLocal  pqrsFacadeLocal ;
    
    //estructura para las llaves foraneas
    
    @EJB 
    private TipopqrsFacadeLocal tipopqrsFacadeLocal ; 
    private Pqrs pqrs ; 
   
    
    //inyeccion de dependecias (llaves foraneas ) 
    @Inject 
    private Tipopqrs tipopqrs ;
   
    
    
    private List<Pqrs> pqrss ; 
    

    
    
    //Estructura para listas de llaves foraneas (inyeccion de dependencias)
    private List<Tipopqrs> tipopqrss; 
    
  
    
    
    private Pqrs pqr  ; 
    private Pqrs pqrtemporal = new Pqrs () ; 
    
    
    
    @PostConstruct 
    
    public void init(){
        
        
         pqrs = new Pqrs() ; 
        //estructura para renderizado llaves foraneas 
        tipopqrss=tipopqrsFacadeLocal.findAll();
        
        pqrss=pqrsFacadeLocal.findAll();
    
        
        
         
    }
    
    public void registrarPqrs(){
        
        try {
            
            pqr.setTipoPqrs(tipopqrs);
         
            pqrsFacadeLocal.create(pqr) ;
            
            tipopqrs = new Tipopqrs() ; 
          
            pqr = new Pqrs() ; 
            pqrss=pqrsFacadeLocal.findAll();
            
            
                        
            
            
         } catch (Exception e) {
        }
    }
    
    public void guardarTemporal(Pqrs t){
        
        pqrtemporal = t;
        
    }
    
  /*  
    public void avisarEmailCliente(Pqrs p){
        try {
            (p.getIdCliente().toString());
            PqrsMailRespuesta.correoPqrs(
                    p.getIdCliente().getNombre(),
                    p.getIdCliente().getApellido(),
                    p.getIdCliente().getCorreo(),
                    p.getFechaRegistro(),
                    p.getComentarioAdmin()
                    );
        } catch (Exception e) {
        }
        
        
    }
    */
    public void editarPqrs () {
        
        try {
            pqrtemporal.setTipoPqrs(tipopqrs);
        
            pqrsFacadeLocal.edit(pqrtemporal);
            
            tipopqrs = new Tipopqrs() ; 
         
            pqrtemporal= new Pqrs(); 
            pqrss=pqrsFacadeLocal.findAll();
        } catch (Exception e) {
        }
    }
    public void eliminarPqrs (Pqrs t){
        
        try {
            pqrsFacadeLocal.remove(t);
            pqrss=pqrsFacadeLocal.findAll(); 
            
        } catch (Exception e) {
        }
    }

    public Pqrs getPqrs() {
        return pqrs;
    }

    public void setPqrs(Pqrs pqrs) {
        this.pqrs = pqrs;
    }

    public Tipopqrs getTipopqrs() {
        return tipopqrs;
    }

    public void setTipopqrs(Tipopqrs tipopqrs) {
        this.tipopqrs = tipopqrs;
    }

    public List<Pqrs> getPqrss() {
        return pqrss;
    }

    public void setPqrss(List<Pqrs> pqrss) {
        this.pqrss = pqrss;
    }

    public List<Tipopqrs> getTipopqrss() {
        return tipopqrss;
    }

    public void setTipopqrss(List<Tipopqrs> tipopqrss) {
        this.tipopqrss = tipopqrss;
    }

    public Pqrs getPqr() {
        return pqr;
    }

    public void setPqr(Pqrs pqr) {
        this.pqr = pqr;
    }

    public Pqrs getPqrtemporal() {
        return pqrtemporal;
    }

    public void setPqrtemporal(Pqrs pqrtemporal) {
        this.pqrtemporal = pqrtemporal;
    }

  
    
    
}
