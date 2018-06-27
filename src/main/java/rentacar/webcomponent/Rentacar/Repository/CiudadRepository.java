/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.Repository;

import org.springframework.data.repository.CrudRepository;
import rentacar.webcomponent.Rentacar.model.CiudadModel;

/**
 *
 * @author chechela
 */
public interface CiudadRepository extends CrudRepository<CiudadModel, Integer> {
    
}
