package com.cjc.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cjc.app.model.Student;
import com.cjc.app.repository.StudentRepository;

@Service
public class StudentServicesimpl implements StudentService{
	
	private StudentRepository repository;

	public StudentServicesimpl(StudentRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Student saveStudent(Student student) {
		
		return repository.save(student);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return repository.findAll();
	}

	@Override
	public Student getStudent(int id) {
	    if(repository.existsById(id))
	    {
		return repository.findById(id).get();
	    }
	    
	    return null;
	}

	@Override
	public List<Student> deleteStudent(int id) {
		repository.deleteById(id);
		return getAllStudent() ;
	}

	
	
	

}
