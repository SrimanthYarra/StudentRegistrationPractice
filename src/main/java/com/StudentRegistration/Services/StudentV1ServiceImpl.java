package com.StudentRegistration.Services;

import com.StudentRegistration.Entities.StudentResults;
import com.StudentRegistration.Models.StudentMarks;
import com.StudentRegistration.Repositories.StudentResultsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentV1ServiceImpl implements StudentService{

    @Autowired
    private StudentResultsRepository studentResultsRepository;

    @Override
    public StudentMarks save(StudentMarks studentMarks) {
        StudentResults studentResults=new StudentResults();
        BeanUtils.copyProperties(studentMarks,studentResults);
        studentResultsRepository.save(studentResults);
        studentMarks.setId(studentResults.getId());
        return studentMarks;
    }

    @Override
    public List<StudentMarks> finadAll() {
        List<StudentResults> studentResults=studentResultsRepository.findAll();
        List<StudentMarks> studentMarksList=new ArrayList<>();
        studentResults.forEach(studentResult ->{
            StudentMarks studentMarks=new StudentMarks();
            BeanUtils.copyProperties(studentResult,studentMarks);
            studentMarksList.add(studentMarks);
        });
        return studentMarksList;
    }

    @Override
    public StudentMarks findById(int id) {
        StudentMarks studentMarks=new StudentMarks();
        BeanUtils.copyProperties(studentResultsRepository.findById(id).get(),studentMarks);
        return studentMarks;
    }

    @Override
    public StudentMarks editById(int id, StudentMarks studentMarks)  {
        StudentMarks studentMarks1=findById(id);
        studentMarks1.setStudentName(studentMarks.getStudentName());
        studentMarks1.setTotalMarks(studentMarks.getTotalMarks());
        StudentResults studentResults=new StudentResults();
        BeanUtils.copyProperties(studentMarks1,studentResults);
        studentResultsRepository.save(studentResults);
        return studentMarks1;
    }

    @Override
    public String deleteById(int id)  {
        studentResultsRepository.deleteById(id);
        return "Entity deleted Successfully";
    }
}
