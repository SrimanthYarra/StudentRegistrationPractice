package com.StudentRegistration.Repositories;

import com.StudentRegistration.Entities.StudentResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentResultsRepository extends JpaRepository<StudentResults,Integer> {
}
