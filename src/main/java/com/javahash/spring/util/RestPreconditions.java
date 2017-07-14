package com.javahash.spring.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class RestPreconditions {
	
	
	public static Set<ConstraintViolation<Object>> validateEntity(final Object resource){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(resource);
        return violations;
	}
	
	public static <T> T checkFound(final T resource) {
		 if (resource == null) {
		 throw new RuntimeException("Resource not found");
		 }
		 return resource;
	 }
	 
	 public static void checkNotNull(Object resource) {
		 if (resource == null) {
		 throw new RuntimeException("Resource not found");
		 }
	 }
}
