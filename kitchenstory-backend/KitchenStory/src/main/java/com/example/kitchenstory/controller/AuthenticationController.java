package com.example.kitchenstory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kitchenstory.model.authentication;
import com.example.kitchenstory.repository.AuthenticationRepository;




@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class AuthenticationController {
	@Autowired
	AuthenticationRepository AP;
	
	@GetMapping("all")
	public List<authentication> getAll()
	{
		List<authentication> a= (List<authentication>) AP.findAll();
		return a;
	}
	
	
	@PostMapping("add")
	public authentication addBook(@RequestBody authentication authentication)
	{
		return AP.save(authentication);
	}
	
	// get particular student by their ID
		@GetMapping("user/{id}")
		public Optional<authentication> getUserById(@PathVariable int id)
		{
			return AP.findById(id);
		}
		
		// update existing student 
		@PutMapping("update/{id}")
		public authentication updateUser(@RequestBody authentication authentication)
		{
			return AP.save(authentication);
		}
		
		// delete particular student from database
		@DeleteMapping("delete/{id}")
		public void deleteUser(@PathVariable int id)
		{
			AP.deleteById(id);
		}
}	
