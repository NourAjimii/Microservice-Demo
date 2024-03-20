package com.example.School;

import com.example.School.client.StudentClient;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentClient studentClient;

    public void saveSchool(School school){
        schoolRepository.save(school);
    }


    public List<School> findAllSchools(){
        return schoolRepository.findAll();
    }


    public FullSchoolResponse findSchoolsWithStudents(String schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NotFount")
                                .email("NotFound")
                                .build()
                );


        List<Student> students = studentClient.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();

    }
}
