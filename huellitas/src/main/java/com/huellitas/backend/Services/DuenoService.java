package com.huellitas.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.huellitas.backend.converters.DuenoConverter;
import com.huellitas.backend.data.DuenoData;
import com.huellitas.backend.entities.Dueno;
import com.huellitas.backend.repositories.DuenoRepository;

@Service
public class DuenoService {
    
    @Autowired
    private DuenoRepository duenoRepository;

    private DuenoConverter duenoConverter = new DuenoConverter();

    //Listar todos los Registro de dueños
    public List<DuenoData> findAll() {
        return duenoConverter.toData(duenoRepository.findAll());
    }

    //Listar un Registro de dueño por id
    public DuenoData findById(int id) {
        Optional<Dueno> dueno = duenoRepository.findById(id);
            if(dueno.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El registro de dueño no existe!");
        return duenoConverter.toData(dueno.get());
    }

    //Crear un Registro de dueño
    public DuenoData insert(DuenoData dueno) {
        if(duenoRepository.existsById(dueno.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡No se puede insertar un registro de dueño con id!");
        return duenoConverter.toData(duenoRepository.save(duenoConverter.toEntity(dueno)));
    }

    //Editar un Registro de dueño
    public DuenoData update(DuenoData dueno) {
        if(!duenoRepository.existsById(dueno.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede actualizar un registro de dueño que no existe!");
        return duenoConverter.toData(duenoRepository.save(duenoConverter.toEntity(dueno)));
    }

    //Eliminar un Registro de dueño
    public DuenoData deleteById(int id) {
        Optional<Dueno> dueno = duenoRepository.findById(id);
            if(dueno.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede eliminar un registro de dueño que no existe!");
        duenoRepository.deleteById(id);
        return duenoConverter.toData(dueno.get());
    }
}
