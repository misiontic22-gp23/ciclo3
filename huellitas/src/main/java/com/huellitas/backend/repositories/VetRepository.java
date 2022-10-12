package com.huellitas.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huellitas.backend.entities.Vet;

@Repository
public interface VetRepository extends JpaRepository<Vet, Integer> {

}
