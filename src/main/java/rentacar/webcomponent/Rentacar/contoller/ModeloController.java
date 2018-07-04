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

import rentacar.webcomponent.Rentacar.model.ModeloModel;
import org.springframework.http.HttpStatus;
import rentacar.webcomponent.Rentacar.Repository.ModeloRepository;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/Modelo")
public class ModeloController {
    
    @Autowired
    private ModeloRepository  modeloRespository;
    
    
    @GetMapping()
    public Iterable<ModeloModel> listarTodos() {
        
        return modeloRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ModeloModel> muestraUnaModelo(@PathVariable String id) {
        
        Optional<ModeloModel> aOptional = modeloRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ModeloModel> editaModelo(@PathVariable String id, @RequestBody ModeloModel modeloEditar) {
        
        Optional<ModeloModel> aOptional = modeloRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            ModeloModel aEncontrado = aOptional.get();
            
            modeloEditar.setIdModelo(aEncontrado.getModeloModel());
            
            modeloRespository.save(modeloEditar);
            
            return new ResponseEntity<>(modeloEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarModelo(@RequestBody ModeloModel nuevaModelo) {
      
        nuevaModelo = modeloRespository.save(nuevaModelo);
        
        Optional<ModeloModel> aOptional = modeloRespository.findById(nuevaModelo.getIdModelo());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<ModeloModel> aOptional = modeloRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            modeloRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
}

