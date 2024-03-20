package com.example.Student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    //final keyword instead of Autowired to indicate that it will be automatically injected otherwise I won't be automatically injected
    private final StudentService studentService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Student>> findAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    @GetMapping("/school/{idSchool}")
    public ResponseEntity<List<Student>> findAllStudents(@PathVariable("idSchool")String idSchool){
        return ResponseEntity.ok(studentService.findAllStudentsBySchool(idSchool));
    }






}
