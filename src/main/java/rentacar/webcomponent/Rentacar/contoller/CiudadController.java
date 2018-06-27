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

import rentacar.webcomponent.Rentacar.model.CiudadModel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import rentacar.webcomponent.Rentacar.Repository.CiudadRepository;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/Ciudades")
public class CiudadController {
    
    @Autowired
    private CiudadRepository  ciudadRespository;
    
    
    @GetMapping()
    public Iterable<CiudadModel> listarTodos() {
        
        return ciudadRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<CiudadModel> muestraUnaCiudad(@PathVariable String id) {
        
        Optional<CiudadModel> aOptional;
        aOptional = ciudadRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CiudadModel> editaCiudad(@PathVariable String id, @RequestBody CiudadModel ciudadEditar) {
        
        Optional<CiudadModel> aOptional = ciudadRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            CiudadModel aEncontrado = aOptional.get();
            
            ciudadEditar.setIdCiudad(aEncontrado.getIdCiudad());
            
            ciudadRespository.save(ciudadEditar);
            
            return new ResponseEntity<>(ciudadEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarCiudad(@RequestBody CiudadModel nuevaCiudad) {
      
        nuevaCiudad = ciudadRespository.save(nuevaCiudad);
        
        Optional<CiudadModel> aOptional = ciudadRespository.findById(nuevaCiudad.getIdCiudad());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<CiudadModel> aOptional = ciudadRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            ciudadRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
}
