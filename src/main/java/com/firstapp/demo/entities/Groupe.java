package com.firstapp.demo.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data


@Entity
public class Groupe {
    @Id
    long id;
    String nom;
    @OneToMany(mappedBy="groupe")
    @JsonIgnore
    List<Student> students;




}
    //mapped by se trouve dans le cas de oneToMany (un groupe pour many students) on utilise mapped by pour les cles etrangers
