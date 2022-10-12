package com.huellitas.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.huellitas.backend.converters.MascotaConverter;
import com.huellitas.backend.data.MascotaData;
import com.huellitas.backend.entities.Mascota;
import com.huellitas.backend.repositories.MascotaRepository;

@Service
public class MascotaService {
    
    @Autowired
    private MascotaRepository mascotaRepository;

    private MascotaConverter mascotaConverter = new MascotaConverter();

    //Listar todos los Registro de mascotas
    public List<MascotaData> findAll() {
        return mascotaConverter.toData(mascotaRepository.findAll());
    }

    //Listar un Registro de mascota por id
    public MascotaData findById(int id) {
        Optional<Mascota> mascota = mascotaRepository.findById(id);
            if(mascota.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El registro de mascota no existe!");
        return mascotaConverter.toData(mascota.get());
    }

    //Crear un Registro de mascota
    public MascotaData insert(MascotaData mascota) {
        if(mascotaRepository.existsById(mascota.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡No se puede insertar un registro de mascota con id!");
        return mascotaConverter.toData(mascotaRepository.save(mascotaConverter.toEntity(mascota)));
    }

    //Editar un Registro de mascota
    public MascotaData update(MascotaData mascota) {
        if(!mascotaRepository.existsById(mascota.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede actualizar un registro de mascota que no existe!");
        return mascotaConverter.toData(mascotaRepository.save(mascotaConverter.toEntity(mascota)));
    }

    //Eliminar un Registro de mascota
    public MascotaData deleteById(int id) {
        Optional<Mascota> mascota = mascotaRepository.findById(id);
            if(mascota.isEmpty())
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede eliminar un registro de mascota que no existe!");
        mascotaRepository.deleteById(id);
        return mascotaConverter.toData(mascota.get());
    }
}
