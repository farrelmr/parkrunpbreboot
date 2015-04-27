package com.glenware.springboot.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.glenware.springboot.form.ParkrunPredict;

@Component
public class ParkrunValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(ParkrunPredict.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ParkrunPredict prPredict = (ParkrunPredict) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "courseId",
				"NotEmpty.parkrunPredict.courseId", "You must specify a course.");

		Integer ssInt = null;
		try {
			ssInt = Integer.parseInt(prPredict.getSs());
			
			if (ssInt < 0 || ssInt > 60) {
				errors.rejectValue("ss", "NotNull.parkrunPredict.ss", "You must set the number of seconds between 0s and 59s.");
			}
			
			prPredict.setSsInt(ssInt);
		} catch (NumberFormatException nfe) {
			errors.rejectValue("ss", "NotNull.parkrunPredict.ss",
					"You must set the number of seconds between 0s and 59s.");
		}
		
		Integer mmInt = null;
		try {
			mmInt = Integer.parseInt(prPredict.getMm());
			
			if (mmInt < 0 || mmInt > 60) {
				errors.rejectValue("mm", "NotNull.parkrunPredict.mm", "You must set the number of minutes between 0s and 59s.");
			}
			
			prPredict.setMmInt(mmInt);
		} catch (NumberFormatException nfe) {
			errors.rejectValue("mm", "NotNull.parkrunPredict.mm",
					"You must set the number of minutes between 0s and 59s.");
		}
		
		if ( !errors.hasErrors() ) {
			System.out.println("HAS ERRORS mmInt " + mmInt + " ssInt " + ssInt );
		    if ( mmInt < 12 && ssInt < 37 ) {
				errors.rejectValue("mm", "NotNull.prPredict.mm", "Nice try Mo Farah.");
    		}
		}
		
	}

}