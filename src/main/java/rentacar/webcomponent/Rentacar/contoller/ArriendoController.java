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
import rentacar.webcomponent.Rentacar.model.ArriendoModel;

/**
 *
 * @author nacho
 */
@RestController
@RequestMapping("/arriendo")
public class ArriendoController {
    
    //en el GetMapping se cambia el dato entre <> por el nombre de su clase modelo
    @GetMapping()
    public List<ArriendoModel> list() {
        //aqui se retorna el nombredesuclasemodelo.nombredesutablaenlaimagen
        return ArriendoModel.arriendo;
    }

    @GetMapping("/{id}")
    //cambiar PersonaModel por nombre de su clase modelo
    public ArriendoModel get(@PathVariable String id) {
        //se instancia un objeto del tipo de la clase modelo que esten editando de la siguiente forma
        // nombredeclasemodel nombredesutablaenlaimagen = new nombredeclasemodel()
        ArriendoModel arriendo = new ArriendoModel();
        //cambair persona por el nombre de objeto de arriba y buscarPersona por el nombre de buscar en su clase model
        return arriendo.buscarArriendo(Integer.parseInt(id));
    }
    @PutMapping("/{id}")
    //cambiar PersonaModel por el nombre de su clase modelo y personaEditar por  personaEditar por nombredesutablaenlaimagen"Editar"
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody ArriendoModel arriendoEditar) {
        //se instancia un objeto del tipo de la clase modelo que esten editando de la siguiente forma
        // nombredeclasemodel nombredesutablaenlaimagen = new nombredeclasemodel()
        ArriendoModel arriendo = new ArriendoModel();
        //cambiar persona por el nombredesutablaenlaimagen.elnombredesueditar y personaEditar por nombredesutablaenlaimagen"Editar"
        arriendo.editarArriendo(Integer.parseInt(id), arriendoEditar);
        //cambiar persona.editarPersona por nombredesutablaenlaimagen.elnombredesueditar, y personaEditar por nombredesutablaenlaimagen"Editar"
        return new ResponseEntity<>(arriendo.editarArriendo(Integer.parseInt(id), arriendoEditar), HttpStatus.OK);
    }

    @PostMapping
    //cambiar PersonaModel nuevaPersona por elnombredesuclasemodel nueva"elnombredesutablaenlaimagen"
    public ResponseEntity<?> post(@RequestBody ArriendoModel nuevoArriendo) {
        //se instancia un objeto del tipo de la clase modelo que esten creando de la siguiente forma
        // nombredeclasemodel nombredesutablaenlaimagen = new nombredeclasemodel()
        ArriendoModel arriendo = new ArriendoModel();
        if (arriendo.nuevoArriendo(nuevoArriendo)) {
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
        ArriendoModel arriendo = new ArriendoModel();
        if (arriendo.eliminarArriendo(Integer.parseInt(id))) {
            //si nombredesutablaenlaimagen.eliminar"nombredesutablaenlaimagen" tiene id existente
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            //en caso contrario
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
