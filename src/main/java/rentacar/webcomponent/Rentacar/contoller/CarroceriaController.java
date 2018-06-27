/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.contoller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import rentacar.webcomponent.Rentacar.model.CarroceriaModel;
import org.springframework.http.HttpStatus;
import rentacar.webcomponent.Rentacar.Repository.CarroceriaRepository;

/**
 *
 * @author Sony
 */
@RestController
@RequestMapping("/carroceria")
public class CarroceriaController {
    
    
      
    @Autowired
    private CarroceriaRepository carroceriaRepository;
    
    @GetMapping()
    public Iterable<CarroceriaModel> list() {
        return carroceriaRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CarroceriaModel> Muestra(@PathVariable String id) {
        
         
        Optional<CarroceriaModel> aOptional = carroceriaRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            CarroceriaModel CombEncont = aOptional.get();
            return new ResponseEntity<>(CombEncont,HttpStatus.FOUND);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CarroceriaModel> editar(@PathVariable String id, @RequestBody CarroceriaModel carroceriaEditar) {
        
          
        Optional<CarroceriaModel> aOptional = carroceriaRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            CarroceriaModel CombEncont = aOptional.get();
           
            
           carroceriaEditar.setIdCarroceria(CombEncont.getIdCarroceria());
           
           carroceriaRepository.save(carroceriaEditar);
           
            return new ResponseEntity<>(carroceriaEditar,HttpStatus.OK);
           
           
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
        
       
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody CarroceriaModel nuevoCarroceria) {
        
       nuevoCarroceria =carroceriaRepository.save(nuevoCarroceria);
        
        
        
       Optional<CarroceriaModel> aOptional = carroceriaRepository.findById(nuevoCarroceria.getIdCarroceria());
        
        if (aOptional.isPresent()) {
            CarroceriaModel CombEncont = aOptional.get();
            return new ResponseEntity<>(CombEncont,HttpStatus.CREATED);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
    
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
          Optional<CarroceriaModel> aOptional = carroceriaRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            CarroceriaModel CombEncont = aOptional.get();
            
            carroceriaRepository.deleteById(CombEncont.getIdCarroceria());
            return new ResponseEntity<>(CombEncont,HttpStatus.OK);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
    
        
        
        
      
    
}
}