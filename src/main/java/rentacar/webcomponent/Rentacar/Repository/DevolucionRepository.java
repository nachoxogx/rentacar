/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.Repository;

import org.springframework.data.repository.CrudRepository;
import rentacar.webcomponent.rentacar.model.DevolucionModel;

/**
 *
 * @author jose
 */
public interface DevolucionRepository extends CrudRepository<DevolucionModel , Integer> {
    
}