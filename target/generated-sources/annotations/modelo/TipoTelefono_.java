package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-17T21:14:53")
@StaticMetamodel(TipoTelefono.class)
public class TipoTelefono_ { 

    public static volatile SingularAttribute<TipoTelefono, Integer> idTelefono;
    public static volatile SingularAttribute<TipoTelefono, String> tipoTelefono;
    public static volatile CollectionAttribute<TipoTelefono, Usuario> usuarioCollection;

}