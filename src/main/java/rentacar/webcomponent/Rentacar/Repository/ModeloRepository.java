/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.Repository;

import inacap.webcomponent.rentacar.model.ModeloModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author chechela
 */
public interface ModeloRepository extends CrudRepository<ModeloModel, Integer> {
    
}
