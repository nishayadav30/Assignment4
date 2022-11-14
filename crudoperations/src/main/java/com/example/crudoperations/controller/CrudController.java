package com.example.crudoperations.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudoperations.entity.Student;
import com.example.crudoperations.entity.studentRequest;
import com.example.crudoperations.entity.studentResponse;
import com.example.crudoperations.repository.StudentRepo;
@RestController
@RequestMapping("/crud")
public class CrudController {
	
	private static final Logger log=LoggerFactory.getLogger(CrudController.class);
	@Autowired
	StudentRepo repo;
	
	@PostMapping(value= "/insert")
	public ResponseEntity<studentResponse> enterData(@RequestBody studentRequest request)
	{
		studentResponse response=new studentResponse();
		Student savedEntity=new Student();
		savedEntity.setId(request.getId());
		savedEntity.setName(request.getName());
		savedEntity.setMarks(request.getMarks());
		
		savedEntity=this.repo.save(savedEntity);
		ArrayList<Student> li=new ArrayList<>();
		li.add(savedEntity);
		response.setList(li);
		response.setMessage("Record inserted");
		
		return new ResponseEntity<studentResponse>(response,HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/select/{id}")
	public ResponseEntity<studentResponse> getData(@PathVariable(value ="id")Integer id)  
	{
		studentResponse response=new studentResponse();
		log.info("ID:{}",id);
		Student finalList=this.repo.findById(id).orElse(null);
		ArrayList<Student> li=new ArrayList<>();
		li.add(finalList);
		response.setList(li);
		response.setMessage("");
		
		return new ResponseEntity<studentResponse>(response,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/selectAll")
	public ResponseEntity<studentResponse> getAllData()  
	{
		List<Student> li=new ArrayList<Student>();
		studentResponse response=new studentResponse();
		 li=this.repo.findAll();
		response.setList(li);
		response.setMessage("");
		
		return new ResponseEntity<studentResponse>(response,HttpStatus.OK);
	}
	
	@PutMapping(value= "/update")
	public ResponseEntity<studentResponse> updateData(@RequestBody studentRequest request)
	{
		ArrayList<Student> newList=new ArrayList<>();
		studentResponse response=new studentResponse();
		Student savedEntity=new Student();
		int Id=request.getId();
		Student finalList=this.repo.findById(Id).orElse(null);
		
		if(finalList!=null) {
			savedEntity.setId(request.getId());
			savedEntity.setName(request.getName());
			savedEntity.setMarks(request.getMarks());
		}
		else
		{
			response.setMessage("Record NotFound");
			return new ResponseEntity<studentResponse>(response,HttpStatus.OK);
		}
		savedEntity=this.repo.save(savedEntity);
		newList.add(savedEntity);
		response.setList(newList);
		response.setMessage("Record Updated");
		return new ResponseEntity<studentResponse>(response,HttpStatus.OK);
		
	}
	
	@DeleteMapping(value= "/delete")
	public ResponseEntity<studentResponse> deleteData(@RequestBody studentRequest request)
	{
		List<Student> newList=new ArrayList<Student>();
		studentResponse response=new studentResponse();
		int Id=request.getId();
			this.repo.deleteById(Id);
			 newList=this.repo.findAll();
			response.setList(newList);
		response.setMessage("Record Deleted");
		return new ResponseEntity<studentResponse>(response,HttpStatus.OK);
		
	}

}
