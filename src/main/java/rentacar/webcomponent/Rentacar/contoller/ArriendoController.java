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
import rentacar.webcomponent.Rentacar.Repository.ArriendoRepository;
import rentacar.webcomponent.Rentacar.model.ArriendoModel;

/**
 *
 * @author nacho
 */
@RestController
@RequestMapping("/arriendo")
public class ArriendoController {
    @Autowired
    private ArriendoRepository arriendoRep;
    //en el GetMapping se cambia el dato entre <> por el nombre de su clase modelo
    @GetMapping()
    public Iterable<ArriendoModel> list() {
        //aqui se retorna el nombredesuclasemodelo.nombredesutablaenlaimagen
        return arriendoRep.findAll();
    }

    @GetMapping("/{id}")
    //cambiar PersonaModel por nombre de su clase modelo
    public ResponseEntity<ArriendoModel> get(@PathVariable String id) {
        Optional<ArriendoModel> aOptional = arriendoRep.findById(Integer.parseInt(id));
        if(aOptional.isPresent()){
            ArriendoModel aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    //cambiar PersonaModel por el nombre de su clase modelo y personaEditar por  personaEditar por nombredesutablaenlaimagen"Editar"
    public ResponseEntity<ArriendoModel> put(@PathVariable String id, @RequestBody ArriendoModel arriendoEditar) {
               Optional<ArriendoModel> aOptional = arriendoRep.findById(Integer.parseInt(id));
        if(aOptional.isPresent()){
            ArriendoModel aEncontrado = aOptional.get();
            arriendoEditar.setIdArriendo(aEncontrado.getIdArriendo());
            arriendoRep.save(arriendoEditar);
            return new ResponseEntity<>(arriendoEditar, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    //cambiar PersonaModel nuevaPersona por elnombredesuclasemodel nueva"elnombredesutablaenlaimagen"
    public ResponseEntity<?> post(@RequestBody ArriendoModel nuevoArriendo) {
        nuevoArriendo = arriendoRep.save(nuevoArriendo);
        Optional<ArriendoModel> aOptional = arriendoRep.findById(nuevoArriendo.getIdArriendo());
        if(aOptional.isPresent()){
            ArriendoModel aEncontrado = aOptional.get();
            return new ResponseEntity<>(aEncontrado, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {    
        
        Optional<ArriendoModel> aOptional = arriendoRep.findById(Integer.parseInt(id));
        if(aOptional.isPresent()){
            ArriendoModel aEncontrado = aOptional.get();
            arriendoRep.deleteById(aEncontrado.getIdArriendo());
            return new ResponseEntity<>(aEncontrado, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    
}
