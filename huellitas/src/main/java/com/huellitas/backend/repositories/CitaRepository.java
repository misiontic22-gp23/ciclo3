package com.huellitas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huellitas.backend.entities.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

}
