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
import rentacar.webcomponent.Rentacar.model.MediopagoModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Sony
 */
@RestController
@RequestMapping("/mediopago")
public class MediopagoController {
    
    
    
    @GetMapping()
    public List<MediopagoModel> list() {
        return MediopagoModel.medio;
    }
    
    @GetMapping("/{id}")
    public MediopagoModel get(@PathVariable String id) {
        
        MediopagoModel made = new MediopagoModel();
        return made.buscarMediopago(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody MediopagoModel mediopagoEditar) {
        
        MediopagoModel made = new MediopagoModel();
        
        
         return new ResponseEntity<>( made.editarMediopago(Integer.parseInt(id),mediopagoEditar),HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody MediopagoModel nuevoMediopago) {
        MediopagoModel made = new MediopagoModel();
      
      if(made.nuevoMediopago(nuevoMediopago)){
          return new ResponseEntity<>(HttpStatus.CREATED);
      }else{
          return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
      }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        
        MediopagoModel combustible = new MediopagoModel();
  
        if (   combustible.aliminarMediopago(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
         return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
       
    }
        
    }
    

