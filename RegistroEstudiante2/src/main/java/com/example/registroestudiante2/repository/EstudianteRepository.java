package com.example.registroestudiante2.repository;

import com.example.registroestudiante2.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}