package com.hub.bunnyLovers.api;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import com.hub.bunnyLovers.exception.BunnyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BunnyException.class)
	public ResponseEntity<ExceptionResponse> handleBunnyException(BunnyException e) {
		log.error("BunnyException", e);
		return ResponseEntity
			.status(INTERNAL_SERVER_ERROR.value())
			.body(new ExceptionResponse(e.getMessage()));
	}

//	@ExceptionHandler(RuntimeException.class)
//	public ResponseEntity<Void> handleRuntimeException(RuntimeException e) {
//		log.info("=============");
//		return ResponseEntity.ok().build();
//	}

}
