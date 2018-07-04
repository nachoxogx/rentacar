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

import rentacar.webcomponent.Rentacar.model.MarcaModel;
import org.springframework.http.HttpStatus;
import rentacar.webcomponent.Rentacar.Repository.MarcaRepository;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/marca")
public class MarcaController {
    
    @Autowired
    private MarcaRepository  marcaRespository;
    
    
    @GetMapping()
    public Iterable<MarcaModel> listarTodos() {
        
        return marcaRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<MarcaModel> muestraUnaMarca(@PathVariable String id) {
        
        Optional<MarcaModel> aOptional = marcaRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MarcaModel> editaMarca(@PathVariable String id, @RequestBody MarcaModel marcaEditar) {
        
        Optional<MarcaModel> aOptional = marcaRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            MarcaModel aEncontrado = aOptional.get();
            
            marcaEditar.setIdMarca(aEncontrado.getIdMarca());
            
            marcaRespository.save(marcaEditar);
            
            return new ResponseEntity<>(marcaEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarMarca(@RequestBody MarcaModel nuevaMarca) {
      
        nuevaMarca = marcaRespository.save(nuevaMarca);
        
        Optional<MarcaModel> aOptional = marcaRespository.findById(nuevaMarca.getIdMarca());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<MarcaModel> aOptional = marcaRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            marcaRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
}

