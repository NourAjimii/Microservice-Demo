package com.example.School;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {

    //final keyword instead of Autowired to indicate that it will be automatically injected otherwise I won't be automatically injected
    private final SchoolService schoolService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSchool(@RequestBody School school){
        schoolService.saveSchool(school);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<School>> findAllSchools(){
        return ResponseEntity.ok(schoolService.findAllSchools());
    }

    @GetMapping("/withStudents/{schoolId}")
    public ResponseEntity<FullSchoolResponse> findSchoolsWithStudents(@PathVariable("schoolId") String schoolId){
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }



}
