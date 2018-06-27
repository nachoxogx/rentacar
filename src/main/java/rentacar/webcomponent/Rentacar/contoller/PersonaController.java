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
import rentacar.webcomponent.Rentacar.Repository.PersonaRepository;
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
    @Autowired
    private PersonaRepository personaRep;
    //en el GetMapping se cambia el dato entre <> por el nombre de su clase modelo
    @GetMapping()
    public Iterable<PersonaModel> list() {
        //aqui se retorna el nombredesuclasemodelo.nombredesutablaenlaimagen
        return personaRep.findAll();
    }

    @GetMapping("/{id}")
    //cambiar PersonaModel por nombre de su clase modelo
    public ResponseEntity<PersonaModel> get(@PathVariable String id) {
        Optional<PersonaModel> pOptional = personaRep.findById(Integer.parseInt(id));
        if(pOptional.isPresent()){
            PersonaModel pEncontrado = pOptional.get();
            return new ResponseEntity<>(pEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    //cambiar PersonaModel por el nombre de su clase modelo y personaEditar por  personaEditar por nombredesutablaenlaimagen"Editar"
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody PersonaModel personaEditar) {
                Optional<PersonaModel> pOptional = personaRep.findById(Integer.parseInt(id));
        if(pOptional.isPresent()){
            PersonaModel pEncontrado = pOptional.get();
            personaEditar.setIdPersona(pEncontrado.getIdPersona());
            personaRep.save(personaEditar);
            return new ResponseEntity<>(personaEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    //cambiar PersonaModel nuevaPersona por elnombredesuclasemodel nueva"elnombredesutablaenlaimagen"
    public ResponseEntity<?> post(@RequestBody PersonaModel nuevaPersona) {
        personaRep.save(nuevaPersona);
        Optional<PersonaModel> pOptional = personaRep.findById(nuevaPersona.getIdPersona());
        if(pOptional.isPresent()){
            PersonaModel pEncontrado = pOptional.get();
            return new ResponseEntity<>(pEncontrado, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<PersonaModel> pOptional = personaRep.findById(Integer.parseInt(id));
        if(pOptional.isPresent()){
            PersonaModel pEncontrado = pOptional.get();
            personaRep.deleteById(pEncontrado.getIdPersona());
            return new ResponseEntity<>(pEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
