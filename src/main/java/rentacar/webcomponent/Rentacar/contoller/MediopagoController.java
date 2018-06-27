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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import rentacar.webcomponent.Rentacar.model.MediopagoModel;
import org.springframework.http.HttpStatus;
import rentacar.webcomponent.Rentacar.Repository.MedioPagoRepository;

/**
 *
 * @author Sony
 */
@RestController
@RequestMapping("/mediopago")
public class MediopagoController {
    
     @Autowired
    private MedioPagoRepository mediopagoRepository;
    
    @GetMapping()
    public Iterable<MediopagoModel> list() {
        return mediopagoRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MediopagoModel> muestra(@PathVariable String id) {
        
       
        
        
        
        Optional<MediopagoModel> aOptional = mediopagoRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            MediopagoModel CombEncont = aOptional.get();
            return new ResponseEntity<>(CombEncont,HttpStatus.FOUND);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
        
        
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MediopagoModel> Editar(@PathVariable String id, @RequestBody MediopagoModel mediopagoEditar) {
        
          
        Optional<MediopagoModel> aOptional = mediopagoRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
             MediopagoModel CombEncont = aOptional.get();
           
            
           mediopagoEditar.setIdMediopago(CombEncont.getIdMediopago());
           
           mediopagoRepository.save(mediopagoEditar);
           
            return new ResponseEntity<>(mediopagoEditar,HttpStatus.OK);
           
           
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MediopagoModel nuevoMediopago) {
        
        
         nuevoMediopago =mediopagoRepository.save(nuevoMediopago);
        
        
        
       Optional<MediopagoModel> aOptional =  mediopagoRepository.findById(nuevoMediopago.getIdMediopago());
        
        if (aOptional.isPresent()) {
            MediopagoModel CombEncont = aOptional.get();
            return new ResponseEntity<>(CombEncont,HttpStatus.CREATED);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        
      Optional<MediopagoModel> aOptional = mediopagoRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            MediopagoModel CombEncont = aOptional.get();
            
          mediopagoRepository.deleteById(CombEncont.getIdMediopago());
            return new ResponseEntity<>(CombEncont,HttpStatus.OK);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
       
    }
        
    }
    

