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

import rentacar.webcomponent.rentacar.model.DevolucionModel;
import org.springframework.http.HttpStatus;
import rentacar.webcomponent.Rentacar.Repository.DevolucionRepository;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/Devolucion")
public class DevolucionController {
    
    @Autowired
    private DevolucionRepository  devolucionRespository;
    
    
    @GetMapping()
    public Iterable<DevolucionModel> listarTodos() {
        
        return devolucionRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<DevolucionModel> muestraUnaDevolucion(@PathVariable String id) {
        
        Optional<DevolucionModel> aOptional = devolucionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DevolucionModel> editaDevolucion(@PathVariable String id, @RequestBody DevolucionModel devolucionEditar) {
        
        Optional<DevolucionModel> aOptional = devolucionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            DevolucionModel aEncontrado = aOptional.get();
            
          devolucionEditar.setIdDevolucion(aEncontrado.getIdDevolucion());
            
            devolucionRespository.save(devolucionEditar);
            
            return new ResponseEntity<>(devolucionEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarDevolucion(@RequestBody DevolucionModel nuevaDevolucion) {
      
        nuevaDevolucion = devolucionRespository.save(nuevaDevolucion);
        
        Optional<DevolucionModel> aOptional = devolucionRespository.findById(nuevaDevolucion.getIdDevolucion());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<DevolucionModel> aOptional = devolucionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            devolucionRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
}

