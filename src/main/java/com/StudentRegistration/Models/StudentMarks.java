package com.StudentRegistration.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class StudentMarks {

    @JsonIgnore
    private int id;
    private String studentName;
    private int totalMarks;

    public StudentMarks(String studentName, int totalMarks) {
        this.studentName = studentName;
        this.totalMarks = totalMarks;
    }

    public StudentMarks(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }


}
