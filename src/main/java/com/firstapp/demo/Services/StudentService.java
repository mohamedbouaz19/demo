package com.firstapp.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.firstapp.demo.Repository.StudentRepository;
import com.firstapp.demo.entities.Student;

@Service
public class StudentService {
        @Autowired
    StudentRepository sr;
    public List<Student> getAllStudents() {
        return sr.findAll();
    }
    //c'est pour enregistrer
    public Student addStudent(Student s){
        return sr.save(s);
}
//pour la suppression
public void deleteStudent(long id){
    sr.deleteById(id);

}
//pour la modification
public Student updateStudent(Student s){
return sr.save(s);
//save joue les deux roles d'ajout et de suppression si l'element existe ddeja on le modifie si non on l'ajout
// ca c est enregistrer dans h2 c est une base de donnes dans la memoire
}
public List<Student> getAllStudents(int page,int size,String field){
    Pageable pg=PageRequest.of(page, size, Sort.by(field));
    Page<Student> studentsPage=sr.findAll(pg);
    return studentsPage.getContent();

}



}
