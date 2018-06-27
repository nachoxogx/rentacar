/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.contoller;

import rentacar.webcomponent.rentacar.model.DevolucionModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import rentacar.webcomponent.Rentacar.Repository.DevolucionRepository;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/devolucion")
public class DevolucionController {
   
   @Autowired
   private DevolucionRepository devolucionRepository;
   
   @GetMapping()
    public List<DevolucionModel> list() {
        return DevolucionModel.find all;
    }
    
    
    @GetMapping("/{id}")
    public DevolucionModel get(@PathVariable String id) {
        DevolucionModel devolucion = new DevolucionModel();
        return devolucion.buscarDevolucion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody DevolucionModel devolucionEditar) {
        DevolucionModel devolucion = new DevolucionModel();
        devolucion.editarDevolucion(Integer.parseInt(id), devolucionEditar);
        return new ResponseEntity<>(devolucion.editarDevolucion(Integer.parseInt(id), devolucionEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody DevolucionModel nuevoDevolucion) {
        DevolucionModel devolucion = new DevolucionModel();
        if (devolucion.nuevoDevolucion(nuevoDevolucion)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        DevolucionModel devolucion = new DevolucionModel();
        if (devolucion.eliminarDevolucion(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
