package com.example.crudoperations;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.crudoperations.entity.Student;
import com.example.crudoperations.entity.studentRequest;
import com.example.crudoperations.entity.studentResponse;
import com.example.crudoperations.repository.StudentRepo;

@SpringBootTest
class CrudoperationsApplicationTests {

	@Test
	void contextLoads() {
		
		assertNotNull(getClass());
	}


}
