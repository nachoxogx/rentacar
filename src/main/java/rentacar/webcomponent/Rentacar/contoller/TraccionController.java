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
import rentacar.webcomponent.Rentacar.model.TraccionModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Sony
 */
@RestController
@RequestMapping("/traccion")
public class TraccionController {
    
    @GetMapping()
    public List<TraccionModel> list() {
        return TraccionModel.trac;
    }
    
    @GetMapping("/{id}")
    public TraccionModel get(@PathVariable String id) {
        TraccionModel traca = new TraccionModel();
        
        return traca.buscarTraccion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody TraccionModel traccionEditar) {
        
        TraccionModel traca = new TraccionModel();
        
        
        
        return new  ResponseEntity<>( traca.editarTraccion(Integer.parseInt(id),traccionEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TraccionModel nuevoTraccion) {
        
         TraccionModel traca = new TraccionModel();
      
      if(traca.nuevoTraccion(nuevoTraccion)){
          return new ResponseEntity<>(HttpStatus.CREATED);
      }else{
          return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
      }
        
        
        
        
        
  
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        
        
            
        TraccionModel traca = new TraccionModel();
  
        if (   traca.aliminarTraccion(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
         return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
       
    }
        
       
    }
    

