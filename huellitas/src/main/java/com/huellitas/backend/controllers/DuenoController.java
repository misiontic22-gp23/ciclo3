package com.huellitas.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huellitas.backend.Services.DuenoService;
import com.huellitas.backend.data.DuenoData;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(path = "/api/dueno")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class DuenoController {
    
    @Autowired
    private DuenoService duenoService;
    
    //Listar todos los dueños
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(duenoService.findAll(), HttpStatus.OK);
    }

    //Listar un dueño por id
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(duenoService.findById(id), HttpStatus.OK);
    }

    //Agregar un dueño
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody DuenoData dueno) {
        return new ResponseEntity<>(duenoService.insert(dueno), HttpStatus.CREATED);
    }

    //Editar un dueño (por id)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody DuenoData dueno) {
        return new ResponseEntity<>(duenoService.update(dueno), HttpStatus.OK);
    }

    //Eliminar un dueño (por id)
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(int id) {
        return new ResponseEntity<>(duenoService.deleteById(id), HttpStatus.OK);
    }
}
