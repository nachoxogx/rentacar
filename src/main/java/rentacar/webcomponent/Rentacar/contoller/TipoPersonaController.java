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

import rentacar.webcomponent.Rentacar.model.TipoPersonaModel;
import org.springframework.http.HttpStatus;
import rentacar.webcomponent.Rentacar.Repository.TipoPersonaRepository;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/tipopersona")
public class TipoPersonaController {
    
    @Autowired
    private TipoPersonaRepository  tipopersonaRespository;
    
    
    @GetMapping()
    public Iterable<TipoPersonaModel> listarTodos() {
        
        return tipopersonaRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> muestraUnaTipoPersona(@PathVariable String id) {
        
        Optional<TipoPersonaModel> aOptional = tipopersonaRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TipoPersonaModel> editaTipoPersona(@PathVariable String id, @RequestBody TipoPersonaModel tipopersonaEditar) {
        
        Optional<TipoPersonaModel> aOptional = tipopersonaRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            TipoPersonaModel aEncontrado = aOptional.get();
            
            tipopersonaEditar.setIdTipoPersona(aEncontrado.getIdTipoPersona());
            
            tipopersonaRespository.save(tipopersonaEditar);
            
            return new ResponseEntity<>(tipopersonaEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarTipoPersona(@RequestBody TipoPersonaModel nuevaTipoPersona) {
      
        nuevaTipoPersona= tipopersonaRespository.save(nuevaTipoPersona);
        
        Optional<TipoPersonaModel> aOptional = tipopersonaRespository.findById(nuevaTipoPersona.getIdTipoPersona());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TipoPersonaModel> aOptional = tipopersonaRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            tipopersonaRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
}

