package com.firstapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.demo.Services.GroupesService;
import com.firstapp.demo.entities.Groupe;
import com.firstapp.demo.entities.Student;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class GroupeController {
    @Autowired
    GroupesService gs;

    @GetMapping("groupe")
    public List<Groupe> getAllGroupes(){
        return gs.getAllGroupes();
        }
    @PostMapping("groupe")
        public Groupe addGroupe(@RequestBody Groupe g) {
            
            return gs.addGroupe(g);
        }
        @GetMapping("groupe/{id}")
        public Groupe getGroupeById (@PathVariable Long id){
            return gs.getGroupeById(id);

        }
        
        @GetMapping("groupe/{id}/student")

                //reccuperer les students d un groupe par id du groupe
        
        public List<Student> getAllStudentByGroupeId(@PathVariable Long id){
            return gs.getAllStudentByGroupeId(id);
        }
        @PostMapping("groupe/{id}/student")
        public Student addStudentByGroupeId(@PathVariable Long id, @RequestBody Student s){
            return gs.addStudentByGroupeId(id, s);
            //on ajoute un student entre par l utilisateur a un groupe en specifions l id du groupe
        }
        @DeleteMapping("groupe/{id}")
        public void deleteGroupe(@PathVariable Long id){

            gs.deleteGroupe(id);
        }


}
    
