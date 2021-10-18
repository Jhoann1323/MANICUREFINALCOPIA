package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-17T21:14:53")
@StaticMetamodel(OrdenPago.class)
public class OrdenPago_ { 

    public static volatile SingularAttribute<OrdenPago, Usuario> usuarioIdUsuario;
    public static volatile SingularAttribute<OrdenPago, String> razonSocial;
    public static volatile SingularAttribute<OrdenPago, Float> valorTotal;
    public static volatile SingularAttribute<OrdenPago, Integer> nit;
    public static volatile SingularAttribute<OrdenPago, String> proveedor;
    public static volatile SingularAttribute<OrdenPago, Integer> idOrden;
    public static volatile SingularAttribute<OrdenPago, Date> fechaOrden;
    public static volatile SingularAttribute<OrdenPago, Integer> insumoIdInsumo;

}