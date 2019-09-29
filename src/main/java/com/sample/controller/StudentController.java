package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.Student;
import com.sample.repository.StudentRepository;

import reactor.core.publisher.Mono;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping
	public Mono<ResponseEntity<List<Student>>> helloFlux() {
		return studentRepository.findAllStudents().collectList().flatMap(data -> Mono.just(ResponseEntity.ok(data)));
	}

	@PostMapping(consumes = "application/json")
	public Mono<Student> saveStudent(@RequestBody Mono<Student> s) {
		return studentRepository.save(Mono.just(new Student(null, "koustubh")));
	}

}
