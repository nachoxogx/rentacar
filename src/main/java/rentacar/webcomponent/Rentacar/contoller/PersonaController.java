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
//se importan los datos de la clase modelo que se este editando
import rentacar.webcomponent.Rentacar.model.PersonaModel;

/**
 *
 * @author nacho
 */
//RECUERDEN QUE PARA CREAR ESTA CLASE SE DEBE DENTRO DEL PACKAGE CLICK DERECHO...NEW...OTHER...SPRING FRAMEWORK..REST CONTROLLER 
//AL CREAR ESTA CLASE RECUERDE MARCAR GENERATE CRUD METHODS
@RestController
//se cambia dond la url del RequestMapping por un / y el nombre de su tabla en la imagen
@RequestMapping("/persona")
public class PersonaController {

    //en el GetMapping se cambia el dato entre <> por el nombre de su clase modelo
    @GetMapping()
    public List<PersonaModel> list() {
        //aqui se retorna el nombredesuclasemodelo.nombredesutablaenlaimagen
        return PersonaModel.persona;
    }

    @GetMapping("/{id}")
    //cambiar PersonaModel por nombre de su clase modelo
    public PersonaModel get(@PathVariable String id) {
        //se instancia un objeto del tipo de la clase modelo que esten editando de la siguiente forma
        // nombredeclasemodel nombredesutablaenlaimagen = new nombredeclasemodel()
        PersonaModel persona = new PersonaModel();
        //cambair persona por el nombre de objeto de arriba y buscarPersona por el nombre de buscar en su clase model
        return persona.buscarPersona(Integer.parseInt(id));
    }

    @PutMapping("/{id}")
    //cambiar PersonaModel por el nombre de su clase modelo y personaEditar por  personaEditar por nombredesutablaenlaimagen"Editar"
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody PersonaModel personaEditar) {
        //se instancia un objeto del tipo de la clase modelo que esten editando de la siguiente forma
        // nombredeclasemodel nombredesutablaenlaimagen = new nombredeclasemodel()
        PersonaModel persona = new PersonaModel();
        //cambiar persona por el nombredesutablaenlaimagen.elnombredesueditar y personaEditar por nombredesutablaenlaimagen"Editar"
        persona.editarPersona(Integer.parseInt(id), personaEditar);
        //cambiar persona.editarPersona por nombredesutablaenlaimagen.elnombredesueditar, y personaEditar por nombredesutablaenlaimagen"Editar"
        return new ResponseEntity<>(persona.editarPersona(Integer.parseInt(id), personaEditar), HttpStatus.OK);
    }

    @PostMapping
    //cambiar PersonaModel nuevaPersona por elnombredesuclasemodel nueva"elnombredesutablaenlaimagen"
    public ResponseEntity<?> post(@RequestBody PersonaModel nuevaPersona) {
        //se instancia un objeto del tipo de la clase modelo que esten creando de la siguiente forma
        // nombredeclasemodel nombredesutablaenlaimagen = new nombredeclasemodel()
        PersonaModel persona = new PersonaModel();
        if (persona.nuevaPersona(nuevaPersona)) {
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
        PersonaModel persona = new PersonaModel();
        if (persona.eliminarPersona(Integer.parseInt(id))) {
            //si nombredesutablaenlaimagen.eliminar"nombredesutablaenlaimagen" tiene id existente
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            //en caso contrario
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
