/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentacar.webcomponent.Rentacar.contoller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import rentacar.webcomponent.Rentacar.model.VehiculoModel;

/**
 *
 * @author nacho
 */
@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {
    
    @GetMapping()
    public List<VehiculoModel> list() {
        return VehiculoModel.vehiculo;
    }
    
    @GetMapping("/{id}")
    public VehiculoModel get(@PathVariable String id) {
        VehiculoModel vehiculo = new VehiculoModel();
        return vehiculo.buscarVehiculo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody VehiculoModel VehiculoEditar) {
//se instancia un objeto del tipo de la clase modelo que esten editando de la siguiente forma
        // nombredeclasemodel nombredesutablaenlaimagen = new nombredeclasemodel()
        VehiculoModel vehiculo = new VehiculoModel();
        //cambiar persona por el nombredesutablaenlaimagen.elnombredesueditar y personaEditar por nombredesutablaenlaimagen"Editar"
        vehiculo.editarVehiculo(Integer.parseInt(id), VehiculoEditar);
        //cambiar persona.editarPersona por nombredesutablaenlaimagen.elnombredesueditar, y personaEditar por nombredesutablaenlaimagen"Editar"
        return new ResponseEntity<>(vehiculo.editarVehiculo(Integer.parseInt(id), vehiculo), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody VehiculoModel nuevoVehiculo) {
                VehiculoModel vehiculo = new VehiculoModel();
        if (vehiculo.nuevoVehiculo(nuevoVehiculo)) {
            //si nombredesutablaenlaimagen.nueva"nombredesutablaenlaimagen" viene con datos
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            //en caso contrario
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        VehiculoModel vehiculo = new VehiculoModel();
        if (vehiculo.eliminarVehiculo(Integer.parseInt(id))) {
            //si nombredesutablaenlaimagen.eliminar"nombredesutablaenlaimagen" tiene id existente
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            //en caso contrario
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
