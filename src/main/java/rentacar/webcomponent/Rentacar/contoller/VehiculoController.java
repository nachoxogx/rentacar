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
import rentacar.webcomponent.Rentacar.Repository.VehiculoRepository;
import rentacar.webcomponent.Rentacar.model.VehiculoModel;

/**
 *
 * @author nacho
 */
@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    @Autowired
    private VehiculoRepository vRep;
    @GetMapping()
    public Iterable<VehiculoModel> list() {
        return vRep.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<VehiculoModel> get(@PathVariable String id) {
        Optional<VehiculoModel> vOptional = vRep.findById(Integer.parseInt(id));
        if(vOptional.isPresent()){
            VehiculoModel vEncontrado = vOptional.get();
            return new ResponseEntity<>(vEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody VehiculoModel VehiculoEditar) {
        Optional<VehiculoModel> vOptional = vRep.findById(Integer.parseInt(id));
        if(vOptional.isPresent()){
            VehiculoModel vEncontrado = vOptional.get();
            VehiculoEditar.setIdVehiculo(vEncontrado.getIdVehiculo());
            vRep.save(VehiculoEditar);
            return new ResponseEntity<>(vEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody VehiculoModel nuevoVehiculo) {   
        nuevoVehiculo = vRep.save(nuevoVehiculo);
        Optional<VehiculoModel> vOptional = vRep.findById(nuevoVehiculo.getIdVehiculo());
        if(vOptional.isPresent()){
            VehiculoModel vEncontrado = vOptional.get();
            return new ResponseEntity<>(vEncontrado, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<VehiculoModel> vOptional = vRep.findById(Integer.parseInt(id));
        if(vOptional.isPresent()){
            VehiculoModel vEncontrado = vOptional.get();
            vRep.deleteById(vEncontrado.getIdVehiculo());
            return new ResponseEntity<>(vEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
