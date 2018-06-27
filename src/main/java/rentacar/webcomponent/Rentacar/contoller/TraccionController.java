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
import rentacar.webcomponent.Rentacar.model.TraccionModel;
import org.springframework.http.HttpStatus;
import rentacar.webcomponent.Rentacar.Repository.TraccionRepository;

/**
 *
 * @author Sony
 */
@RestController
@RequestMapping("/traccion")
public class TraccionController {
    
    @Autowired
    private TraccionRepository traccionRepository;
    
    @GetMapping()
    public Iterable<TraccionModel> list() {
        return traccionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TraccionModel> Mostrar(@PathVariable String id) {
        
        
          Optional<TraccionModel> aOptional = traccionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            TraccionModel CombEncont = aOptional.get();
            return new ResponseEntity<>(CombEncont,HttpStatus.FOUND);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
        
        
        
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody TraccionModel traccionEditar) {
        
        
        
        
        Optional<TraccionModel> aOptional = traccionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            TraccionModel CombEncont = aOptional.get();
           
            
           traccionEditar.setIdTraccion(CombEncont.getIdTraccion());
           
          traccionRepository.save(traccionEditar);
           
            return new ResponseEntity<>(traccionEditar,HttpStatus.OK);
           
           
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
       
    }
    
    @PostMapping
    public ResponseEntity<TraccionModel> Editar(@RequestBody TraccionModel nuevoTraccion) {
        
       
          
       nuevoTraccion =traccionRepository.save(nuevoTraccion);
        
        
        
       Optional<TraccionModel> aOptional = traccionRepository.findById(nuevoTraccion.getIdTraccion());
        
        if (aOptional.isPresent()) {
            TraccionModel CombEncont = aOptional.get();
            return new ResponseEntity<>(CombEncont,HttpStatus.CREATED);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
      
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        
         Optional<TraccionModel> aOptional = traccionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            TraccionModel CombEncont = aOptional.get();
            
            traccionRepository.deleteById(CombEncont.getIdTraccion());
            return new ResponseEntity<>(CombEncont,HttpStatus.OK);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
            

       
    }
        
       
    }
    

