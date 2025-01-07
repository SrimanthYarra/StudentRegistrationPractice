package com.StudentRegistration.Services;

import com.StudentRegistration.Models.StudentMarks;

import java.util.List;

public interface StudentService {

    StudentMarks save(StudentMarks studentMarks);

    List<StudentMarks> finadAll();

    StudentMarks findById(int id) ;

    StudentMarks editById(int id, StudentMarks studentMarks) ;

    String deleteById(int id) ;
}
