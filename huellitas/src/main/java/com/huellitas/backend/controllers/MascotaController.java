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

import com.huellitas.backend.Services.MascotaService;
import com.huellitas.backend.data.MascotaData;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(path = "/api/mascota")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class MascotaController {
    
    @Autowired
    private MascotaService mascotaService;

    //Listar todas las mascotas
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(mascotaService.findAll(), HttpStatus.OK);
    }

    //Listar una mascota por id
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(mascotaService.findById(id), HttpStatus.OK);
    }

    //Agregar una mascota
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody MascotaData mascota) {
        return new ResponseEntity<>(mascotaService.insert(mascota), HttpStatus.CREATED);
    }

    //Editar una mascota (por id)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody MascotaData mascota) {
        return new ResponseEntity<>(mascotaService.update(mascota), HttpStatus.OK);
    }

    //Eliminar una mascota (por id)
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(int id) {
        return new ResponseEntity<>(mascotaService.deleteById(id), HttpStatus.OK);
    }
}