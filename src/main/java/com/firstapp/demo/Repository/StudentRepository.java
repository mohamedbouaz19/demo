package com.firstapp.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstapp.demo.entities.Groupe;
import com.firstapp.demo.entities.Student;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
List<Student> findByGroupe(Groupe g);
}
