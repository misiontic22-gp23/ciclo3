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
import org.springframework.web.bind.annotation.RequestMethod;

import com.huellitas.backend.Services.HistoriaService;
import com.huellitas.backend.data.HistoriaData;

@RestController
@RequestMapping(path = "/api/historia")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class HistoriaController {
    
    @Autowired
    private HistoriaService consultaService;

    //Listar todas las consultas
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(consultaService.findAll(), HttpStatus.OK);
    }

    //Listar una consulta por id
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(consultaService.findById(id), HttpStatus.OK);
    }

    //Agregar una consulta
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody HistoriaData consulta) {
        return new ResponseEntity<>(consultaService.insert(consulta), HttpStatus.CREATED);
    }

    //Editar una consulta (por id)
    @PutMapping
    public ResponseEntity<?> update(@RequestBody HistoriaData consulta) {
        return new ResponseEntity<>(consultaService.update(consulta), HttpStatus.OK);
    }

    //Eliminar una consulta (por id)
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(int id) {
        return new ResponseEntity<>(consultaService.deleteById(id), HttpStatus.OK);
    }
}
