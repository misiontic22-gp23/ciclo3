package com.huellitas.backend.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VetData {
    private int id;
    private double cedula;
    private String nombre;
    private String Usuario;
    private double telefono;
    private double Matricula;
    private String password;
    private String email;
}
