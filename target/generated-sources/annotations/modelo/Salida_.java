package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-17T21:14:53")
@StaticMetamodel(Salida.class)
public class Salida_ { 

    public static volatile SingularAttribute<Salida, Integer> salCantidad;
    public static volatile SingularAttribute<Salida, String> salFactura;
    public static volatile SingularAttribute<Salida, Producto> salProCodigo;
    public static volatile SingularAttribute<Salida, String> salFecha;
    public static volatile SingularAttribute<Salida, Integer> salId;

}