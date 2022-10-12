package com.huellitas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huellitas.backend.entities.Dueno;

@Repository
public interface DuenoRepository extends JpaRepository<Dueno, Integer> {

}
