package com.huellitas.backend.converters;

import com.huellitas.backend.data.MascotaData;
import com.huellitas.backend.entities.Mascota;

public class MascotaConverter extends Converter<Mascota, MascotaData> {

    private DuenoConverter duenoConverter = new DuenoConverter();

    @Override
    public Mascota toEntity(MascotaData object) {
        return object == null ? null : Mascota.builder()
            .id(object.getId())
            .Nombre(object.getNombre())
            .Especie(object.getEspecie())
            .Edad(object.getEdad())
            .Sexo(object.getSexo())
            .Foto(object.getFoto())
            .dueno(duenoConverter.toEntity(object.getDueno()))
            .build();
    }

    @Override
    public MascotaData toData(Mascota object) {
        return object == null ? null : MascotaData.builder()
            .id(object.getId())
            .Nombre(object.getNombre())
            .Especie(object.getEspecie())
            .Edad(object.getEdad())
            .Sexo(object.getSexo())
            .Foto(object.getFoto())
            .dueno(duenoConverter.toData(object.getDueno()))
            .build();
    }

}
