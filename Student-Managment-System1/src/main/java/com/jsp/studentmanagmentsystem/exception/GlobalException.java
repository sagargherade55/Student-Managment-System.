package com.jsp.studentmanagmentsystem.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseBody
public class GlobalException {

	@ExceptionHandler(exception = ResoueseNotFoundException.class)
	public ResponseEntity<String> handleExcepton(ResoueseNotFoundException db){
		return new ResponseEntity<String>(db.getMessage(),HttpStatusCode.valueOf(500));
	}
}
