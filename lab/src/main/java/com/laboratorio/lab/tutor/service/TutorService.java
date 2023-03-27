package com.laboratorio.lab.tutor.service;

import com.laboratorio.lab.tutor.entity.Tutor;
import com.laboratorio.lab.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {
    @Autowired
    private TutorRepository tutorRepository;
    public Tutor salvar(Tutor tutor){
        return tutorRepository.save(tutor);
    }
    public List<Tutor> listaTutor(){
        return tutorRepository.findAll();
    }
    public Optional<Tutor> buscarPorId(Long id){
        return tutorRepository.findById(id);
    }
    public void removerPorId(Long id){
        tutorRepository.deleteById(id);
    }
}
