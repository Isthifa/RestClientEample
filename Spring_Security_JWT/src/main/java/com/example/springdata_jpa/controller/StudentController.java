package com.example.springdata_jpa.controller;

import com.example.springdata_jpa.dao.UserInfoRepo;
import com.example.springdata_jpa.dto.Authrequest;
import com.example.springdata_jpa.entity.Student;
import com.example.springdata_jpa.entity.UserInfo;
import com.example.springdata_jpa.service.JwtService;
import com.example.springdata_jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserInfoRepo userInfoRepo;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/u/new")
    public String add(@RequestBody UserInfo userInfo) {
        return studentService.addUser(userInfo);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Student student) {
        Student student1 = studentService.save(student);
        return new ResponseEntity(student1, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> studen = studentService.findByid(id);
        Student student1 = studen.get();
        student1.setName(student.getName());
        student1.setEmail(student.getName());
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
    }

    @GetMapping("/list")
    public List<Student> listall() {
        List<Student> students = studentService.listall();
        return students;
    }

    @GetMapping("/{id}")
    public Optional<Student> findbyid(@PathVariable long id) {
        Optional<Student> student = studentService.findByid(id);
        return student;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        studentService.deleteById(id);
        return "Deleted " + id;
    }

    @PostMapping("/authenticate")
    public String authenticateandgetoken(@RequestBody Authrequest authrequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authrequest.getUsername(), authrequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return "token: "+jwtService.generateToken(authrequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request");
        }
    }
}
