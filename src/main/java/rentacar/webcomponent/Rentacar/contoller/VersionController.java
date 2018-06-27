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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import rentacar.webcomponent.Rentacar.Repository.VersionRepository;
import rentacar.webcomponent.Rentacar.model.VersionModel;


/**
 *
 * @author nacho
 */
@RestController
@RequestMapping("/version")
public class VersionController {
    @Autowired
    private VersionRepository veRep;
    @GetMapping()
    public Iterable<VersionModel> list() {
        return veRep.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<VersionModel> get(@PathVariable String id) {
        Optional<VersionModel> vOptional = veRep.findById(Integer.parseInt(id));
        
        if (vOptional.isPresent()) {
            VersionModel vEncontrada = vOptional.get();
            return new ResponseEntity<>(vEncontrada,HttpStatus.FOUND);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody VersionModel versionEditar) {
        Optional<VersionModel> vOptional = veRep.findById(Integer.parseInt(id));
        
        if (vOptional.isPresent()) {
            VersionModel vEncontrada = vOptional.get();
            versionEditar.setIdVersion(vEncontrada.getIdVersion());
            veRep.save(versionEditar);
            return new ResponseEntity<>(vEncontrada,HttpStatus.OK);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody VersionModel nuevaVersion) {
        nuevaVersion = veRep.save(nuevaVersion);
        Optional<VersionModel> vOptional = veRep.findById(nuevaVersion.getIdVersion());
        
        if (vOptional.isPresent()) {
            VersionModel vEncontrada = vOptional.get();
            return new ResponseEntity<>(vEncontrada,HttpStatus.FOUND);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<VersionModel> vOptional = veRep.findById(Integer.parseInt(id));
        
        if (vOptional.isPresent()) {
            VersionModel vEncontrada = vOptional.get();
            veRep.deleteById(vEncontrada.getIdVersion());
            return new ResponseEntity<>(vEncontrada,HttpStatus.OK);
            
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        
    }
    }
}