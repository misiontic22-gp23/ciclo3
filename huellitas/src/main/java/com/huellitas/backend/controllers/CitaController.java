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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.huellitas.backend.Services.CitaService;
import com.huellitas.backend.data.CitaData;

@RestController
@RequestMapping(path = "/api/cita")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class CitaController {
    
    @Autowired
    private CitaService clinicaService;

    //Listar todas las consultas
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(clinicaService.findAll(), HttpStatus.OK);
    }

    //Listar una consulta por id
    @GetMapping(path = "{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(clinicaService.findById(id), HttpStatus.OK);
    }

    //Agregar una consulta
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody CitaData clinica) {
        return new ResponseEntity<>(clinicaService.insert(clinica), HttpStatus.CREATED);
    }

    //Editar una consulta (por id)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody CitaData clinica) {
        return new ResponseEntity<>(clinicaService.update(clinica), HttpStatus.OK);
    }

    //Eliminar una consulta (por id)
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(int id) {
        return new ResponseEntity<>(clinicaService.deleteById(id), HttpStatus.OK);
    }
}
