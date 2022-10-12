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

import com.huellitas.backend.Services.VetService;
import com.huellitas.backend.data.VetData;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(path = "/api/vet")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class VetController {
    
    @Autowired
    private VetService vetService;
    
    //Listar todos los veterinarios
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(vetService.findAll(), HttpStatus.OK);
    }

    //Listar un veterinario por id
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(vetService.findById(id), HttpStatus.OK);
    }

    //Agregar un veterinario
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody VetData vet) {
        return new ResponseEntity<>(vetService.insert(vet), HttpStatus.CREATED);
    }

    //Editar un veterinario (por id)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody VetData vet) {
        return new ResponseEntity<>(vetService.update(vet), HttpStatus.OK);
    }

    //Eliminar un veterinario (por id)
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(int id) {
        return new ResponseEntity<>(vetService.deleteById(id), HttpStatus.OK);
    }
}