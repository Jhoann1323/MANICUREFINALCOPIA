package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-19T06:10:15")
@StaticMetamodel(TipoDireccion.class)
public class TipoDireccion_ { 

    public static volatile SingularAttribute<TipoDireccion, String> descripcion;
    public static volatile SingularAttribute<TipoDireccion, Integer> idDireccion;
    public static volatile CollectionAttribute<TipoDireccion, Usuario> usuarioCollection;

}