package com.example.registroestudiante2.service;

import com.example.registroestudiante2.model.Estudiante;
import com.example.registroestudiante2.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> listarEstudiantes() {
        return estudianteRepository.findAll();
    }

    public Estudiante buscarEstudiantePorId(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public Estudiante agregarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }
}