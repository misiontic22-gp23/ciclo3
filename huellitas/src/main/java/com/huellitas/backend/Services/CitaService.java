package com.huellitas.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.huellitas.backend.converters.CitaConverter;
import com.huellitas.backend.data.CitaData;
import com.huellitas.backend.entities.Cita;
import com.huellitas.backend.repositories.CitaRepository;

@Service
public class CitaService {
    
    @Autowired
    CitaRepository clinicaRepository;

    CitaConverter clinicaConverter = new CitaConverter();
    
    //Listar todas las historias clinicas
    public List<CitaData> findAll() {
        return clinicaConverter.toData(clinicaRepository.findAll());
    }

    //Listar una historia clinica por id
    public CitaData findById(int id) {
        Optional <Cita> clinica = clinicaRepository.findById(id);
            if(!clinica.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡La historia clinica no existe!");
            }   
        return clinicaConverter.toData(clinica.get());
    }

    //Crear una historia clinica
    public CitaData insert(CitaData clinica) {
        if(clinicaRepository.existsById(clinica.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡No se puede insertar una historia clinica con id!");
        }
        Cita clinicaEntity = clinicaConverter.toEntity(clinica);
        CitaData response = clinicaConverter.toData(clinicaRepository.save(clinicaEntity));
        return response;
    }

    //Editar una historia clinica
    public CitaData update(CitaData clinica) {
        if(!clinicaRepository.existsById(clinica.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede actualizar una historia clinica que no existe!");
        }
        Cita clinicaEntity = clinicaConverter.toEntity(clinica);
        CitaData response = clinicaConverter.toData(clinicaRepository.save(clinicaEntity));
        return response;
    }

    //Eliminar una historia clinica
    public CitaData deleteById(int id) {
        Optional<Cita> clinica = clinicaRepository.findById(id); 
        if(clinica.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede eliminar una historia clinica que no existe!");
        }
        clinicaRepository.deleteById(id);
        return clinicaConverter.toData(clinica.get());
    }
}
