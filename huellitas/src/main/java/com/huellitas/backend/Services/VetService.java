package com.huellitas.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.huellitas.backend.converters.VetConverter;
import com.huellitas.backend.data.VetData;
import com.huellitas.backend.entities.Vet;
import com.huellitas.backend.repositories.VetRepository;

@Service
public class VetService {
    
    @Autowired
    private VetRepository vetRepository;

    private VetConverter vetConverter = new VetConverter();

    //Listar todos los Registro de veterinarios
    public List<VetData> findAll() {
        return vetConverter.toData(vetRepository.findAll());
    }

    //Listar un Registro de veterinario por id
    public VetData findById(int id) {
        Optional<Vet> vet = vetRepository.findById(id);
            if(vet.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El registro de veterinario no existe!");
        return vetConverter.toData(vet.get());
    }

    //Crear un Registro de veterinario
    public VetData insert(VetData vet) {
        if(vetRepository.existsById(vet.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡No se puede insertar un registro de veterinario con id!");
        Vet vetEntity = vetConverter.toEntity(vet);
        VetData response = vetConverter.toData(vetRepository.save(vetEntity));
        return response;
    }

    //Editar un Registro de veterinario
    public VetData update(VetData vet) {
        if(!vetRepository.existsById(vet.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede actualizar un registro de veterinario que no existe!");
        Vet vetEntity = vetConverter.toEntity(vet);
        VetData response = vetConverter.toData(vetRepository.save(vetEntity));
        return response;
    }

    //Eliminar un Registro de veterinario
    public VetData deleteById(int id) {
        Optional<Vet> vet = vetRepository.findById(id);
            if(vet.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede eliminar un registro de veterinario que no existe!");
        vetRepository.deleteById(id);
        return vetConverter.toData(vet.get());
    }
}
