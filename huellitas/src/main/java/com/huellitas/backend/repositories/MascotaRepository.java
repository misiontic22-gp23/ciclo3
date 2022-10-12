package com.huellitas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huellitas.backend.entities.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

}
