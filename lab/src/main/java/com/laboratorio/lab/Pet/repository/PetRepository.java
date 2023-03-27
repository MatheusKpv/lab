package com.laboratorio.lab.Pet.repository;

import com.laboratorio.lab.Pet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
