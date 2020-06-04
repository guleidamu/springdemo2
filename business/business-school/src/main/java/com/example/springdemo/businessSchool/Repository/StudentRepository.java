package com.example.springdemo.businessSchool.Repository;

import com.example.springdemo.businessSchool.data.entity.StudentForJPA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentForJPA,Integer> {
}
