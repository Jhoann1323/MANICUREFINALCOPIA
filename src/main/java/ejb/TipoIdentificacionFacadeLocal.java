/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoIdentificacion;

/**
 *
 * @author Frederick Bosa S
 */
@Local
public interface TipoIdentificacionFacadeLocal {

    void create(TipoIdentificacion tipoIdentificacion);

    void edit(TipoIdentificacion tipoIdentificacion);

    void remove(TipoIdentificacion tipoIdentificacion);

    TipoIdentificacion find(Object id);

    List<TipoIdentificacion> findAll();

    List<TipoIdentificacion> findRange(int[] range);

    int count();
    
}
