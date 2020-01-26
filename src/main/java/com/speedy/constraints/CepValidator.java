package com.speedy.constraints;

import static com.speedy.utils.RegexDictionary.CEP_REGEX;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<Cep, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile(CEP_REGEX);
		Matcher matcher = pattern.matcher(value);
		
		return matcher.matches();
	}

	
}
