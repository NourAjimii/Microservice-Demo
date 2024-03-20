package com.example.School.client;

import com.example.School.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "StudentService",url = "${application.config.students_url}")
public interface StudentClient {

    @GetMapping("/school/{idSchool}")
    List<Student> findAllStudentsBySchool(@PathVariable("idSchool")String idSchool);



}
