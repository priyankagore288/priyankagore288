package com.cjc.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.app.model.Student;
import com.cjc.app.service.StudentService;

@RestController
public class StudentController {

	private StudentService service;

	@Autowired
	public void setService(StudentService service) {
		this.service = service;
	}
	
    @PostMapping(value = "/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		 Student stu = service.saveStudent(student);
		return new ResponseEntity<Student> ( stu, HttpStatus.CREATED);
	}
    
    @GetMapping(value = "/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudent()
    {
    	    List<Student> slist = service.getAllStudent();
    	    
    	    return new ResponseEntity<List<Student>>(slist,HttpStatus.OK);
    }
    
    @GetMapping(value = "/getStudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id)
    {
    	 Student stu = service.getStudent(id);
    	if(stu!=null)
    	{
    	 return new ResponseEntity<Student>(stu,HttpStatus.OK);
    	}
    	return new ResponseEntity<Student>(stu,HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping(value = "/deleteStudent/{id}")
    public ResponseEntity<List<Student>> deleteStudent(@PathVariable int id)
    {
          List<Student> stulist = 	service.deleteStudent(id);
          
          return new ResponseEntity<List<Student>>(stulist,HttpStatus.OK);
    	
    }
    @PutMapping(value = "/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student)
    {
    	 Student stu = service.saveStudent(student);
 		return new ResponseEntity<Student> ( stu, HttpStatus.CREATED);
    	
    	
    }
}
