package com.huellitas.backend.data;

import java.util.Date;

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
public class CitaData {
    private int id;
    private Date Fecha;
    private VetData veterinario;
    private String Tipo;
    private String Observacion;
    private MascotaData Mascota;
}
