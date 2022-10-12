package com.huellitas.backend.converters;

import com.huellitas.backend.data.HistoriaData;
import com.huellitas.backend.entities.Historia;

public class HistoriaConverter extends Converter<Historia, HistoriaData> {

    private CitaConverter citaConverter = new CitaConverter();
    private VetConverter vetConverter = new VetConverter();
    private MascotaConverter mascotaConverter = new MascotaConverter();
    private DuenoConverter duenoConverter = new DuenoConverter();

    @Override
    public Historia toEntity(HistoriaData object) {
        return object == null ? null : Historia.builder()
            .id(object.getId())
            .Cita(citaConverter.toEntity(object.getCita()))
            .Dueno(duenoConverter.toEntity(object.getDueno()))
            .Mascota(mascotaConverter.toEntity(object.getMascota()))
            .temperatura(object.getTemperatura())
            .peso(object.getPeso())
            .frecuenciaCardiaca(object.getFrecuenciaCardiaca())
            .frecuenciaRespiratoria(object.getFrecuenciaRespiratoria())
            .recomendaciones(object.getRecomendaciones())
            .veterinario(vetConverter.toEntity(object.getVeterinario()))
            .build();
    }

    @Override
    public HistoriaData toData(Historia object) {
        return object == null ? null : HistoriaData.builder()
        .id(object.getId())
            .Cita(citaConverter.toData(object.getCita()))
            .Dueno(duenoConverter.toData(object.getDueno()))
            .Mascota(mascotaConverter.toData(object.getMascota()))
            .temperatura(object.getTemperatura())
            .peso(object.getPeso())
            .frecuenciaCardiaca(object.getFrecuenciaCardiaca())
            .frecuenciaRespiratoria(object.getFrecuenciaRespiratoria())
            .recomendaciones(object.getRecomendaciones())
            .veterinario(vetConverter.toData(object.getVeterinario()))
            .build();
    }

}
