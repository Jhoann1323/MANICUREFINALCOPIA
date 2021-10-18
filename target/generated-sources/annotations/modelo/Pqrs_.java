package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Tipopqrs;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-17T21:14:53")
@StaticMetamodel(Pqrs.class)
public class Pqrs_ { 

    public static volatile SingularAttribute<Pqrs, String> comentarioAdmin;
    public static volatile SingularAttribute<Pqrs, Tipopqrs> tipoPqrs;
    public static volatile SingularAttribute<Pqrs, String> calificacion;
    public static volatile SingularAttribute<Pqrs, String> nombreCliente;
    public static volatile SingularAttribute<Pqrs, String> comentarioCliente;
    public static volatile SingularAttribute<Pqrs, Date> fechaRegistro;
    public static volatile SingularAttribute<Pqrs, String> apellidoCliente;
    public static volatile SingularAttribute<Pqrs, String> correo;
    public static volatile SingularAttribute<Pqrs, Integer> idpqrs;

}