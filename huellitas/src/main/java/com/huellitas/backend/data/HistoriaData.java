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
public class HistoriaData {
    private int id;
    private CitaData Cita;
    private DuenoData Dueno;
    private MascotaData Mascota;
    private int temperatura;
    private int peso;
    private int frecuenciaCardiaca;
    private int frecuenciaRespiratoria;
    private String recomendaciones;
    private VetData veterinario;

}
