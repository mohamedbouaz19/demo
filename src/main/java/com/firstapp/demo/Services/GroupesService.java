package com.firstapp.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstapp.demo.Repository.GroupeRepository;

import com.firstapp.demo.Repository.StudentRepository;
import com.firstapp.demo.entities.Groupe;
import com.firstapp.demo.entities.Student;

@Service
public class GroupesService {
    @Autowired
    GroupeRepository rs;
    @Autowired
    StudentRepository sr;
//afficher la liste de goupe ajouter par add
    public List<Groupe> getAllGroupes(){
        return rs.findAll();
        }

        public Groupe addGroupe(Groupe g) {
            return rs.save(g);
        }

        public Groupe getGroupeById (Long id){
            return rs.findById(id).get();
        }
        
                //reccuperer les students d un groupe par id du groupe
        
        public List<Student> getAllStudentByGroupeId(Long id){
            Groupe g=rs.findById(id).get();
            return sr.findByGroupe(g);
        }
        public Student addStudentByGroupeId(Long id, Student s){
            Groupe g=rs.findById(id).get();
            s.setGroupe(g);
            return sr.save(s);
            //on ajoute un student entre par l utilisateur a un groupe en specifions l id du groupe
        }
/*
    public void deleteGroupe(Long id){
        List<Student> students=getAllStudentByGroupeId(id);
            students.forEach(s->{
                s.setGroupe(null);
            });
            rs.deleteById(id);
            
        }
    }*/
}


