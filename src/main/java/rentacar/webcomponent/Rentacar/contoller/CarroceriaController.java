/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.contoller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import rentacar.webcomponent.Rentacar.model.CarroceriaModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Sony
 */
@RestController
@RequestMapping("/carroceria")
public class CarroceriaController {
    
    @GetMapping()
    public List<CarroceriaModel> list() {
        return CarroceriaModel.carro;
    }
    
    @GetMapping("/{id}")
    public CarroceriaModel get(@PathVariable String id) {
        
        CarroceriaModel carros = new CarroceriaModel();
        
        
        
        
        
        return carros.buscarCarroceria(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody CarroceriaModel carroceriaEditar) {
        
        CarroceriaModel carros = new CarroceriaModel();
        
        
        
        
        return new ResponseEntity<>(carros.editarCarroceria(Integer.parseInt(id),carroceriaEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody CarroceriaModel nuevoCarroceria) {
        
        
         CarroceriaModel carros = new CarroceriaModel();
      
      if(carros.nuevoCarroceria(nuevoCarroceria)){
          return new ResponseEntity<>(HttpStatus.CREATED);
      }else{
          return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
      }
        
    
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        
        
        
        
          CarroceriaModel carros = new CarroceriaModel();
  
        if (   carros.aliminarCarroceria(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
         return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
    }
    
}
