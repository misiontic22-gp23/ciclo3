package com.huellitas.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.huellitas.backend.converters.HistoriaConverter;
import com.huellitas.backend.data.HistoriaData;
import com.huellitas.backend.entities.Historia;
import com.huellitas.backend.repositories.ConsultaRepository;

@Service
public class HistoriaService {
    
    @Autowired
    private ConsultaRepository consultaRepository;

    private HistoriaConverter consultaConverter = new HistoriaConverter();

    //Listar todas las consultas
    public List<HistoriaData> findAll() {
        return consultaConverter.toData(consultaRepository.findAll());
    }

    //Listar una consulta por id
    public HistoriaData findById(int id) {
        Optional<Historia> consulta = consultaRepository.findById(id);
            if(!consulta.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡La consulta no existe!");
            }
        return consultaConverter.toData(consulta.get());
    }

    //Agregar una consulta
    public HistoriaData insert(HistoriaData consulta) {
        if(consultaRepository.existsById(consulta.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡No se puede insertar una consulta con id!");
        }
        Historia consultaEntity = consultaConverter.toEntity(consulta);
        HistoriaData response = consultaConverter.toData(consultaRepository.save(consultaEntity));
        return response;
    }

    //Editar una consulta
    public HistoriaData update(HistoriaData consulta) {
        if(!consultaRepository.existsById(consulta.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede actualizar una consulta que no existe!");
        }
        return consultaConverter.toData(consultaRepository.save(consultaConverter.toEntity(consulta)));
    }

    //Eliminar una consulta
    public HistoriaData deleteById(int id) {
        Optional<Historia> consulta = consultaRepository.findById(id);
            if(!consulta.isPresent()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡No se puede eliminar una consulta que no existe!");
            }
        consultaRepository.deleteById(id);
        return consultaConverter.toData(consulta.get());
    }
}
