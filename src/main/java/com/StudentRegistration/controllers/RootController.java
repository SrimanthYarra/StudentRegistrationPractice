package com.StudentRegistration.controllers;

import com.StudentRegistration.Models.StudentMarks;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
public class RootController {

    @GetMapping("/")
    public List<StudentMarks> home(){
        List<StudentMarks> list=new ArrayList<>();
        StudentMarks srimanth=new StudentMarks("Srimanth",95);
        StudentMarks teju=new StudentMarks("Teju",95);
        list.add(srimanth);
        list.add(teju);
        return list;
    }

    @GetMapping("/{id}")
    public String student(@PathVariable("id") String  id){
        return "The Path variable is "+id;
    }

    @GetMapping("/requestparam")
    public String studentDetails(@RequestParam(required = false) String name){
        if(name == null){
            return "No data found";
        }
        return "My name is "+name;
    }
}
