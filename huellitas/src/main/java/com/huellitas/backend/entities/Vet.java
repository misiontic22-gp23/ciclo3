package com.huellitas.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vet {
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private double cedula;
    
    @Column(nullable = false)
    private double telefono;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String Usuario;

    @Column(nullable = false, unique = true)
    private double Matricula;

    @Getter(value = AccessLevel.NONE)
    @Column(nullable = false)
    private String password;
}
