package com.huellitas.backend.converters;

import com.huellitas.backend.data.VetData;
import com.huellitas.backend.entities.Vet;

public class VetConverter extends Converter<Vet, VetData> {

    @Override
    public Vet toEntity(VetData object) {
        return object == null ? null : Vet.builder()
            .id(object.getId())
            .cedula(object.getCedula())
            .nombre(object.getNombre())
            .Usuario(object.getUsuario())
            .telefono(object.getTelefono())
            .Matricula(object.getMatricula())
            .password(object.getPassword())
            .email(object.getEmail())
            .build();
    }

    @Override
    public VetData toData(Vet object) {
        return object == null ? null : VetData.builder()
        .id(object.getId())
        .cedula(object.getCedula())
        .nombre(object.getNombre())
        .Usuario(object.getUsuario())
        .telefono(object.getTelefono())
        .Matricula(object.getMatricula())
        .password(null)
        .email(object.getEmail())
        .build();
    }

}