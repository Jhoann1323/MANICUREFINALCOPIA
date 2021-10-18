package controlador;

import ejb.EntradaFacadeLocal;
import ejb.InventarioFacadeLocal;
import ejb.SalidaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import javax.inject.Named;
import modelo.Entrada;
import modelo.Inventario;
import modelo.Salida;



@Named(value = "inventarioBeanss")

/**
 *
 * @author Frederick Bosa S
 */
@SessionScoped
public class InventarioView implements Serializable{
   
    @EJB
    private InventarioFacadeLocal inventarioFacadeLocal;
    
    @EJB
    private SalidaFacadeLocal salidaFacadeLocal;
    
    @EJB
    private EntradaFacadeLocal entradaFacadeLocal;
    
    private Inventario inventario;
    private List<Inventario> inventarios;
    
    @Inject
    private Salida salida;
    private List<Salida> salidas;
    
    @Inject
    private Entrada entrada;
    private List<Entrada> entradas;
    
    @PostConstruct
    public void init() {
        //Usar para estructura local 
        entradas = entradaFacadeLocal.findAll();
        salidas = salidaFacadeLocal.findAll();
        inventarios = inventarioFacadeLocal.leerTodos();
    }

    public InventarioFacadeLocal getInventarioFacadeLocal() {
        return inventarioFacadeLocal;
    }

    public void setInventarioFacadeLocal(InventarioFacadeLocal inventarioFacadeLocal) {
        this.inventarioFacadeLocal = inventarioFacadeLocal;
    }

    public SalidaFacadeLocal getSalidaFacadeLocal() {
        return salidaFacadeLocal;
    }

    public void setSalidaFacadeLocal(SalidaFacadeLocal salidaFacadeLocal) {
        this.salidaFacadeLocal = salidaFacadeLocal;
    }

    public EntradaFacadeLocal getEntradaFacadeLocal() {
        return entradaFacadeLocal;
    }

    public void setEntradaFacadeLocal(EntradaFacadeLocal entradaFacadeLocal) {
        this.entradaFacadeLocal = entradaFacadeLocal;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    public List<Salida> getSalidas() {
        return salidas;
    }

    public void setSalidas(List<Salida> salidas) {
        this.salidas = salidas;
    }

    public Entrada getEntrada() {
        return entrada;
    }

    public void setEntrada(Entrada entrada) {
        this.entrada = entrada;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    
    
    

}