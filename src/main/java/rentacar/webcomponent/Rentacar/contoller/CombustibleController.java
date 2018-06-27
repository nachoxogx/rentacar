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
import rentacar.webcomponent.Rentacar.model.CombustibleModel;
import org.springframework.http.HttpStatus;
import rentacar.webcomponent.Rentacar.Repository.CombustibleRepository;

/**
 *
 * @author Sony
 */
@RestController
@RequestMapping("/combustible")
public class CombustibleController {
    
    
    @Autowired
    private CombustibleRepository combustibleRepository;
    
    @GetMapping()
    public Iterable<CombustibleModel> list() {
        return combustibleRepository.findAll();
    }
    
    
    
    @GetMapping("/{id}")
    public ResponseEntity<CombustibleModel> muestra(@PathVariable String id) {
        
        Optional<CombustibleModel> aOptional = combustibleRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            CombustibleModel CombEncont = aOptional.get();
            return new ResponseEntity<>(CombEncont,HttpStatus.FOUND);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CombustibleModel> EditarCombustible(@PathVariable String id, @RequestBody CombustibleModel combustibleEditar ) {
       
        
    
        
        Optional<CombustibleModel> aOptional = combustibleRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            CombustibleModel CombEncont = aOptional.get();
           
            
           combustibleEditar.setIdCombustible(CombEncont.getIdCombustible());
           
           combustibleRepository.save(combustibleEditar);
           
            return new ResponseEntity<>(combustibleEditar,HttpStatus.OK);
           
           
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
        
        
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody CombustibleModel nuevoCombustible ) {
        
       nuevoCombustible =combustibleRepository.save(nuevoCombustible);
        
        
        
       Optional<CombustibleModel> aOptional = combustibleRepository.findById(nuevoCombustible.getIdCombustible());
        
        if (aOptional.isPresent()) {
            CombustibleModel CombEncont = aOptional.get();
            return new ResponseEntity<>(CombEncont,HttpStatus.CREATED);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
       Optional<CombustibleModel> aOptional = combustibleRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            CombustibleModel CombEncont = aOptional.get();
            
            combustibleRepository.deleteById(CombEncont.getIdCombustible());
            return new ResponseEntity<>(CombEncont,HttpStatus.OK);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
    
    }
}
