package com.laboratorio.lab.tutor.http.controller;

import com.laboratorio.lab.tutor.entity.Tutor;
import com.laboratorio.lab.tutor.service.TutorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tutor")
public class TutorController {
    @Autowired
    private TutorService tutorService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor salvar(@RequestBody Tutor tutor){
        return tutorService.salvar(tutor);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Tutor> listaTutor(){
        return tutorService.listaTutor();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tutor buscarTutorPorId(@PathVariable("id") Long id){
        return tutorService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor nao encontrado"));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerTutor(@PathVariable("id") Long id){
        tutorService.buscarPorId(id)
                .map(tutor -> {
                    tutorService.removerPorId(tutor.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor nao encontrado"));
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarTutor(@PathVariable("id") Long id, @RequestBody Tutor tutor){
        tutorService.buscarPorId(id)
                .map(tutorBase -> {
                    modelMapper.map(tutor, tutorBase);
                    tutorService.salvar(tutorBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor nao encontrado"));
    }
}
