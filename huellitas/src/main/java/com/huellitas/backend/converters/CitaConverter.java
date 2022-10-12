package com.huellitas.backend.converters;

import com.huellitas.backend.data.CitaData;
import com.huellitas.backend.entities.Cita;

public class CitaConverter extends Converter<Cita, CitaData> {

    private MascotaConverter mascotaConverter = new MascotaConverter();
    private VetConverter vetConverter = new VetConverter();

    @Override
    public Cita toEntity(CitaData object) {
        return object == null ? null : Cita.builder()
            .id(object.getId())
            .Fecha(object.getFecha())
            .veterinario(vetConverter.toEntity(object.getVeterinario()))
            .Tipo(object.getTipo())
            .Observacion(object.getObservacion())
            .Mascota(mascotaConverter.toEntity(object.getMascota()))
            .build();
    }

    @Override
    public CitaData toData(Cita object) {
        return object == null ? null : CitaData.builder()
        .id(object.getId())
            .Fecha(object.getFecha())
            .veterinario(vetConverter.toData(object.getVeterinario()))
            .Tipo(object.getTipo())
            .Observacion(object.getObservacion())
            .Mascota(mascotaConverter.toData(object.getMascota()))
            .build();
    }

}
