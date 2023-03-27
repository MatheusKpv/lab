package com.laboratorio.lab.Pet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity

public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String raca;
    private String cor;
    private Float peso;
    private Date dt_nasc;
    private Date dt_vac1;
    private Date dt_vac2;
    private Date dt_vac3;
    private String vacina;

}
