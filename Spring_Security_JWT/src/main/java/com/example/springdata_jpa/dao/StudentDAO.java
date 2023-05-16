package com.example.springdata_jpa.dao;

import com.example.springdata_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<Student,Long> {
}
