package com.laboratorio.lab.Pet.http.controller;

import com.laboratorio.lab.Pet.entity.Pet;
import com.laboratorio.lab.Pet.service.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet salvar(@RequestBody Pet pet){
        return petService.salvar(pet);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Pet> listaPet(){
        return petService.listaPet();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pet buscarPetPorId(@PathVariable("id") Long id){
        return petService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet nao encontrado"));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPet(@PathVariable("id") Long id){
        petService.buscarPorId(id)
                .map(pet -> {
                    petService.removerPorId(pet.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet nao encontrado"));
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPet(@PathVariable("id") Long id, @RequestBody Pet pet){
        petService.buscarPorId(id)
                .map(petBase -> {
                    modelMapper.map(pet, petBase);
                    petService.salvar(petBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet nao encontrado"));
    }
}
