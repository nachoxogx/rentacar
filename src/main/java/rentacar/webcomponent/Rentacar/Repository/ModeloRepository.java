/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.Repository;

import rentacar.webcomponent.Rentacar.model.ModeloModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jose
 */
public interface ModeloRepository extends CrudRepository<ModeloModel, Integer> {
    
}
