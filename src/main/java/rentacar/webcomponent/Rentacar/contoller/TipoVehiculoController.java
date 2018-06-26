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
import rentacar.webcomponent.Rentacar.model.TipoVehiculoModel;

/**
 *
 * @author nacho
 */
@RestController
@RequestMapping("/TipoVehiculo")
public class TipoVehiculoController {
    
    @GetMapping()
    public List<TipoVehiculoModel> list() {
        return TipoVehiculoModel.tipoVehiculo;
    }
    
    @GetMapping("/{id}")
    public TipoVehiculoModel get(@PathVariable String id) {
        TipoVehiculoModel tipoVehiculo = new TipoVehiculoModel();
        return tipoVehiculo.buscarTipoVehiculo(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody TipoVehiculoModel tipoVehiculoEditar) {
         //se instancia un objeto del tipo de la clase modelo que esten editando de la siguiente forma
        // nombredeclasemodel nombredesutablaenlaimagen = new nombredeclasemodel()
        TipoVehiculoModel tipoVehiculo = new TipoVehiculoModel();
        //cambiar persona por el nombredesutablaenlaimagen.elnombredesueditar y personaEditar por nombredesutablaenlaimagen"Editar"
        tipoVehiculo.editarTipoVehiculo(Integer.parseInt(id), tipoVehiculoEditar);
        //cambiar persona.editarPersona por nombredesutablaenlaimagen.elnombredesueditar, y personaEditar por nombredesutablaenlaimagen"Editar"
        return new ResponseEntity<>(tipoVehiculo.editarTipoVehiculo(Integer.parseInt(id), tipoVehiculoEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody TipoVehiculoModel nuevoTipoVehiculo) {
                TipoVehiculoModel tipoVehiculo = new TipoVehiculoModel();
        if ( tipoVehiculo.nuevoTipoVehiculo(nuevoTipoVehiculo)) {
            //si nombredesutablaenlaimagen.nueva"nombredesutablaenlaimagen" viene con datos
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            //en caso contrario
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        //se instancia un objeto del tipo de la clase modelo que esten eliminando de la siguiente forma
        // nombredeclasemodel nombredesutablaenlaimagen = new nombredeclasemodel()
        TipoVehiculoModel tipoVehiculo = new TipoVehiculoModel();
        if (tipoVehiculo.eliminarTipoVehiculo(Integer.parseInt(id))) {
            //si nombredesutablaenlaimagen.eliminar"nombredesutablaenlaimagen" tiene id existente
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            //en caso contrario
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
