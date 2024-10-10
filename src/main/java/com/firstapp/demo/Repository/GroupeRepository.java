package com.firstapp.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstapp.demo.entities.Groupe;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe,Long>{

}
