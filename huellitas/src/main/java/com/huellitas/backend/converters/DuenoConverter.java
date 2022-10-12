package com.huellitas.backend.converters;

import com.huellitas.backend.data.DuenoData;
import com.huellitas.backend.entities.Dueno;

public class DuenoConverter extends Converter<Dueno, DuenoData> {

    @Override
    public Dueno toEntity(DuenoData object) {
        return object == null ? null : Dueno.builder()
            .id(object.getId())
            .cedula(object.getCedula())
            .nombre(object.getNombre())
            .Usuario(object.getUsuario())
            .telefono(object.getTelefono())
            .email(object.getEmail())
            .password(object.getPassword())
            .build();
    }

    @Override
    public DuenoData toData(Dueno object) {
        return object == null ? null : DuenoData.builder()
            .id(object.getId())
            .cedula(object.getCedula())
            .nombre(object.getNombre())
            .Usuario(object.getUsuario())
            .telefono(object.getTelefono())
            .email(object.getEmail())
            .password(null)
            .build();
    }

}
