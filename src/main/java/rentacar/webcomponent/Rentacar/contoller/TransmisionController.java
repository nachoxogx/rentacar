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
import rentacar.webcomponent.Rentacar.model.TransmisionModel;
import org.springframework.http.HttpStatus;
import rentacar.webcomponent.Rentacar.Repository.TransmisionRepository;
/**
 *
 * @author Sony
 */
@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
    
    @Autowired
    private TransmisionRepository transmisionRepository;
    
    
    @GetMapping()
    public Iterable<TransmisionModel> list() {
        return transmisionRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TransmisionModel> Mostrar(@PathVariable String id) {
     
         Optional<TransmisionModel> aOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            TransmisionModel CombEncont = aOptional.get();
            return new ResponseEntity<>(CombEncont,HttpStatus.FOUND);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TransmisionModel> Editar(@PathVariable String id, @RequestBody TransmisionModel transEditar ) {
        
        
        
        
        Optional<TransmisionModel> aOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            TransmisionModel CombEncont = aOptional.get();
           
            
           transEditar.setIdTransmision(CombEncont.getIdTransmision());
           
           transmisionRepository.save(transEditar);
           
            return new ResponseEntity<>(transEditar,HttpStatus.OK);
           
           
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
        
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody  TransmisionModel nuevoTrans) {
        
        nuevoTrans =transmisionRepository.save(nuevoTrans);
        
        
        
       Optional<TransmisionModel> aOptional = transmisionRepository.findById(nuevoTrans.getIdTransmision());
        
        if (aOptional.isPresent()) {
            TransmisionModel CombEncont = aOptional.get();
            return new ResponseEntity<>(CombEncont,HttpStatus.CREATED);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
     
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
      
      
       Optional<TransmisionModel> aOptional = transmisionRepository.findById(Integer.parseInt(id));
        
        if (aOptional.isPresent()) {
            TransmisionModel CombEncont = aOptional.get();
            
            transmisionRepository.deleteById(CombEncont.getIdTransmision());
            return new ResponseEntity<>(CombEncont,HttpStatus.OK);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
    }
        
        
}
