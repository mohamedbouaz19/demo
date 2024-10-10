package com.firstapp.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstapp.demo.Services.StudentService;
import com.firstapp.demo.entities.Student;


@RestController
public class StudentController {
     //c'est pour l'ajout
    @Autowired
    StudentService ss;

    @GetMapping("student")

    public List<Student> getAllStudents() {
        return ss.getAllStudents();
    }
    //c'est pour enregistrer
        @PostMapping("student")
    public Student addStudent(@RequestBody Student s){
        return ss.addStudent(s);
}
//pour la suppression
@DeleteMapping("student/{id}")
public void deleteStudent(@PathVariable long id){
    ss.deleteStudent(id);

}
//pour la modification
@PutMapping("student")
public Student updateStudent(@RequestBody Student s){
return ss.updateStudent(s);
//save joue les deux roles d'ajout et de suppression si l'element existe ddeja on le modifie si non on l'ajout
// ca c est enregistrer dans h2 c est une base de donnes dans la memoire
}
@GetMapping("student/{page}/{size}/{field}")
public List<Student> getAllStudents(@PathVariable int page,@PathVariable int size,@PathVariable String field){
    return ss.getAllStudents(page, size, field);
}

    }
