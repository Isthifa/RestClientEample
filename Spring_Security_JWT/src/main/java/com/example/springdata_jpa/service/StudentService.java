package com.example.springdata_jpa.service;

import com.example.springdata_jpa.entity.Student;
import com.example.springdata_jpa.entity.UserInfo;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> listall();
    Student save(Student student);
    void deleteById(long id);
    Optional<Student> findByid(long id);
    String addUser(UserInfo userInfo);
}
