package com.speedy.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	private static int PHONE_NUMBER_SIZE = 11;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		boolean isValid = true;
		try {
            Double num = Double.parseDouble(value);
            if (value.length() != PHONE_NUMBER_SIZE) {
            	isValid = false;
            }
        } catch (NumberFormatException e) {
            isValid = false;
        }
		return isValid;
	}

}
