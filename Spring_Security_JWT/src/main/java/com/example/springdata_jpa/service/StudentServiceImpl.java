package com.example.springdata_jpa.service;

import com.example.springdata_jpa.dao.StudentDAO;
import com.example.springdata_jpa.dao.UserInfoRepo;
import com.example.springdata_jpa.entity.Student;
import com.example.springdata_jpa.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private UserInfoRepo userInfoRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private StudentDAO studentDAO;
    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO)
    {
        this.studentDAO=studentDAO;
    }
    @Override
    public List<Student> listall() {
        return studentDAO.findAll();
    }

    @Override
    public Student save(Student student)
    {
        return studentDAO.save(student);
    }


    @Override
    public void deleteById(long id) {
        studentDAO.deleteById(id);
    }

    @Override
    public Optional<Student> findByid(long id) {
        Optional<Student> student= studentDAO.findById(id);
        if(!student.isPresent())
        {
            throw new RuntimeException("Not found");
        }
        else
        {
            return student;
        }
    }

    public String addUser(UserInfo userInfo)
    {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepo.save(userInfo);
        return "user is added";
    }



}
