package com.sample.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;

import com.sample.entity.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class StudentRepository {

	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	public Mono<Student> save(Mono<Student> student) {
		return this.reactiveMongoTemplate.save(student);
	}

	public Flux<Student> findAllStudents() {
		return this.reactiveMongoTemplate.findAll(Student.class);
	}

}
