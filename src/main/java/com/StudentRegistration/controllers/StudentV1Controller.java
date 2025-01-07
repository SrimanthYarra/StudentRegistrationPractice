package com.StudentRegistration.controllers;

import com.StudentRegistration.Entities.StudentResults;
import com.StudentRegistration.Models.StudentMarks;
import com.StudentRegistration.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
public class StudentV1Controller {

    @Qualifier("studentV1ServiceImpl")
    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public StudentMarks saveStudent(@RequestBody StudentMarks studentMarks)  {
        return studentService.save(studentMarks);
    }

    @GetMapping("/findall")
    public List<StudentMarks> getAllStudents(){
        return studentService.finadAll();
    }

    @GetMapping("/{id}")
    public StudentMarks getStudentById(@PathVariable int id)   {
        return studentService.findById(id);
    }

    @GetMapping("/edit/{id}")
    public StudentMarks editStudentById(@PathVariable int id,@RequestBody StudentMarks studentMarks)   {
        return studentService.editById(id,studentMarks);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable int id)   {
        return studentService.deleteById(id);
    }
}
