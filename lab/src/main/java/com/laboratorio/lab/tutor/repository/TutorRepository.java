package com.laboratorio.lab.tutor.repository;

import com.laboratorio.lab.tutor.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
