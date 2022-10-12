package com.huellitas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huellitas.backend.entities.Historia;

public interface ConsultaRepository extends JpaRepository<Historia, Integer> {

}
