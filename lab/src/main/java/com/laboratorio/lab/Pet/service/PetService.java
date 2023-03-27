package com.laboratorio.lab.Pet.service;

import com.laboratorio.lab.Pet.entity.Pet;
import com.laboratorio.lab.Pet.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;
    public Pet salvar(Pet pet){
        return petRepository.save(pet);
    }
    public List<Pet> listaPet(){
        return petRepository.findAll();
    }
    public Optional<Pet> buscarPorId(Long id){
        return petRepository.findById(id);
    }
    public void removerPorId(Long id){
        petRepository.deleteById(id);
    }
}
