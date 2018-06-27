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
import rentacar.webcomponent.Rentacar.model.TransmisionModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author Sony
 */
@RestController
@RequestMapping("/transmision")
public class TransmisionController {
    
    
    
    
    @GetMapping()
    public List<TransmisionModel> list() {
        return TransmisionModel.transmition;
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
      TransmisionModel  transu = new  TransmisionModel();
        
        return transu.buscatrans(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody TransmisionModel transEditar ) {
        
        
        TransmisionModel trans = new TransmisionModel();
      
        
        
        
        return new ResponseEntity<>(trans.editartrans(Integer.parseInt(id),transEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody  TransmisionModel nuevoTrans) {
        
        TransmisionModel transi = new TransmisionModel();
        
        if(transi.nuevoTrans(nuevoTrans)){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }else{
    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        TransmisionModel transu = new TransmisionModel();
        
       if(transu.eliminarTrans(Integer.parseInt(id))){
           return new ResponseEntity<>(HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
       }
        
    }
    
}
