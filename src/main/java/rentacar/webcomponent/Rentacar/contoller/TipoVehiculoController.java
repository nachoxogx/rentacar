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
import rentacar.webcomponent.Rentacar.Repository.TipoVehiculoRepository;
import rentacar.webcomponent.Rentacar.model.TipoVehiculoModel;

/**
 *
 * @author nacho
 */
@RestController
@RequestMapping("/TipoVehiculo")
public class TipoVehiculoController {
    @Autowired
    private TipoVehiculoRepository tvRep;
            
    @GetMapping()
    public Iterable<TipoVehiculoModel> list() {
        return tvRep.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TipoVehiculoModel> get(@PathVariable String id) {
        Optional<TipoVehiculoModel> tvOptional = tvRep.findById(Integer.parseInt(id));
        if(tvOptional.isPresent()){
            TipoVehiculoModel tvEncontrado = tvOptional.get();
            return new ResponseEntity<>(tvEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody TipoVehiculoModel tipoVehiculoEditar) {
         Optional<TipoVehiculoModel> tvOptional = tvRep.findById(Integer.parseInt(id));
        if(tvOptional.isPresent()){
            TipoVehiculoModel tvEncontrado = tvOptional.get();
            tipoVehiculoEditar.setIdTipoVehiculo(tvEncontrado.getIdTipoVehiculo());
            tvRep.save(tipoVehiculoEditar);
            return new ResponseEntity<>(tvEncontrado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculoModel nuevoTipoVehiculo) {
        tvRep.save(nuevoTipoVehiculo);
        Optional<TipoVehiculoModel> tvOptional = tvRep.findById(nuevoTipoVehiculo.getIdTipoVehiculo());
        if(tvOptional.isPresent()){
            TipoVehiculoModel tvEncontrado = tvOptional.get();
            return new ResponseEntity<>(tvEncontrado, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
  
        Optional<TipoVehiculoModel> tvOptional = tvRep.findById(Integer.parseInt(id));
        if(tvOptional.isPresent()){
            TipoVehiculoModel tvEncontrado = tvOptional.get();
            tvRep.deleteById(tvEncontrado.getIdTipoVehiculo());
            return new ResponseEntity<>(tvEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
