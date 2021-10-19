package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Pqrs;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-19T06:10:15")
@StaticMetamodel(Tipopqrs.class)
public class Tipopqrs_ { 

    public static volatile SingularAttribute<Tipopqrs, String> descripcion;
    public static volatile SingularAttribute<Tipopqrs, Integer> idtipoPqrs;
    public static volatile ListAttribute<Tipopqrs, Pqrs> pqrsList;

}