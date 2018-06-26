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
import rentacar.webcomponent.Rentacar.model.VersionModel;


/**
 *
 * @author nacho
 */
@RestController
@RequestMapping("/version")
public class VersionController {
    
    @GetMapping()
    public List<VersionModel> list() {
        return VersionModel.version;
    }
    
    @GetMapping("/{id}")
    public VersionModel get(@PathVariable String id) {
        VersionModel version = new VersionModel();
        return version.buscarVersion(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody VersionModel versionEditar) {
        VersionModel version = new VersionModel();
        //cambiar persona por el nombredesutablaenlaimagen.elnombredesueditar y personaEditar por nombredesutablaenlaimagen"Editar"
        version.editarVersion(Integer.parseInt(id), versionEditar);
        //cambiar persona.editarPersona por nombredesutablaenlaimagen.elnombredesueditar, y personaEditar por nombredesutablaenlaimagen"Editar"
        return new ResponseEntity<>(version.editarVersion(Integer.parseInt(id), version), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody VersionModel nuevaVersion) {
                VersionModel version = new VersionModel();
        if (version.nuevaVersion(nuevaVersion)) {
            //si nombredesutablaenlaimagen.nueva"nombredesutablaenlaimagen" viene con datos
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            //en caso contrario
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        VersionModel version = new VersionModel();
        if (version.eliminarVersion(Integer.parseInt(id))) {
            //si nombredesutablaenlaimagen.eliminar"nombredesutablaenlaimagen" tiene id existente
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            //en caso contrario
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
    
}
