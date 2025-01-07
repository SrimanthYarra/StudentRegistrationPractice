package com.StudentRegistration.Services;

import com.StudentRegistration.Exceptions.StudentNotFoundException;
import com.StudentRegistration.Models.StudentMarks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StudentServiceImpl implements StudentService{

    List<StudentMarks> students=new ArrayList<>();

    @Override
    public StudentMarks save(StudentMarks studentMarks) {
        if(studentMarks.getId()==null){
            int id=generateId();
            if(students.stream().filter(student -> student.getId() == id).toList().isEmpty()){
                studentMarks.setId(id);
            }else{
                save(studentMarks);
            }
        }
        students.add(studentMarks);
        return studentMarks;
    }

    @Override
    public List<StudentMarks> finadAll() {
        return students;
    }

    @Override
    public StudentMarks findById(int id)  {
        return students.stream().filter(student->student.getId()==id).findFirst()
                .orElseThrow(()->new StudentNotFoundException("Student not found with id: "+id));
    }

    @Override
    public StudentMarks editById(int id, StudentMarks studentMarks) {
        StudentMarks studentMarks1=findById(id);
        studentMarks1.setStudentName(studentMarks.getStudentName());
        studentMarks1.setTotalMarks(studentMarks.getTotalMarks());
        return studentMarks1;
    }

    @Override
    public String deleteById(int id) {
        students.remove(findById(id));
        return "Employee deleted with the id: "+id;
    }

    public int generateId(){
        return new Random().nextInt(1000);
    }

    

}
