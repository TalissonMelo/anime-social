package com.talissonmelo.controlador.exceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.talissonmelo.entidades.exception.EntidadeNaoEncontrada;
import com.talissonmelo.entidades.exception.Erro;
import com.talissonmelo.entidades.exception.RegraDeNegocioException;

@ControllerAdvice
public class ApiExceptionHanlder extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String detalhe = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";
		List<String> mensagens = new ArrayList<String>();
		for (ObjectError error : e.getBindingResult().getAllErrors()) {
			String msg = error.getDefaultMessage();
			mensagens.add(msg);
		}
		Erro erros = new Erro();
		erros.setStatus(status.value());
		erros.setTimestamp(OffsetDateTime.now());
		erros.setDescricao(detalhe);
		erros.setMensagens(mensagens);
		return handleExceptionInternal(e, erros, headers, status, request);
	}
	
	@ExceptionHandler(EntidadeNaoEncontrada.class)
	public ResponseEntity<Erro> entidadeNaoEncontrada(EntidadeNaoEncontrada e, HttpServletRequest request) {
		Erro erro = new Erro();
		erro.setStatus(HttpStatus.NOT_FOUND.value());
		erro.setDescricao(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);

	}
	
	@ExceptionHandler(RegraDeNegocioException.class)
	public ResponseEntity<Erro> regraNegocio(RegraDeNegocioException e, HttpServletRequest request) {
		Erro erro = new Erro();
		erro.setStatus(HttpStatus.BAD_REQUEST.value());
		erro.setDescricao(e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}
}
