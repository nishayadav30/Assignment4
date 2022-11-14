package com.example.crudoperations.entity;

import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class EntityTest {

	
	@Test
	public void testStudent() {
		assertThat(Student.class, hasValidGettersAndSetters());
	}
	
	@Test
	public void testEmpEntityReponse() {
		assertThat(studentResponse.class, hasValidGettersAndSetters());
	}
	
	@Test
	public void testEmpEntityRequest() {
		assertThat(studentRequest.class, hasValidGettersAndSetters());
	}
	
	}
}
