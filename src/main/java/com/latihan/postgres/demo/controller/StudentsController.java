package com.latihan.postgres.demo.controller;

import com.latihan.postgres.demo.entity.Students;
import com.latihan.postgres.demo.helper.MessageModel;
import com.latihan.postgres.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentsController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getStudents", method = RequestMethod.GET)
    public ResponseEntity getStudents(){
        System.out.println("get Student");
        ResponseEntity responseEntity =studentService.getStudents() ;
        return responseEntity ;
    }

    @RequestMapping(value = "/findStudent/{studentId}", method = RequestMethod.GET)
    public ResponseEntity findStudent(@PathVariable(value = "studentId") Long studentId){
        System.out.println("find Student");
        ResponseEntity responseEntity= studentService.findStudent(studentId);
        return responseEntity;
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ResponseEntity<MessageModel> addStudent(@RequestBody Students students){
        return studentService.addStudent(students);
    }

    @RequestMapping(value = "/updateStudent/{studentId}", method = RequestMethod.PUT)
    public ResponseEntity<MessageModel> updateStudent(@RequestBody Students student, @PathVariable(value = "studentId") Long studentId){
        return studentService.updateStudent(student, studentId);
    }

    @RequestMapping(value = "/deleteStudent/{studentId}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable(value = "studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
}
