package ma.octo.assignement.web.common;

import ma.octo.assignement.exceptions.CompteNonExistantException;
import ma.octo.assignement.exceptions.SoldeDisponibleInsuffisantException;
import ma.octo.assignement.exceptions.TransactionException;
import ma.octo.assignement.exceptions.VersementNonExistantException;
import ma.octo.assignement.service.imp.VersementServiceImp;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice(basePackages = {"ma.octo.assignement.web"} ) 
public class ExceptionHandelingController {
    Logger LOGGER = LoggerFactory.getLogger(ExceptionHandelingController.class);

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleSoldeDisponibleInsuffisantException(SoldeDisponibleInsuffisantException ex, WebRequest request) {
		LOGGER.debug("solde Disponible Exceptionhandler");

    	ErrorResponse error = new ErrorResponse();
    	error.setMessage(ex.getMessage());
    	error.setStatus(HttpStatus.UNAUTHORIZED.value());
    	error.setTime(new Date());
        return error;
    }
    
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ErrorResponse handleCompteNonExistantException(CompteNonExistantException ex, WebRequest request) {
    	LOGGER.debug("CompteNonExistantException Handler");
    	ErrorResponse error = new ErrorResponse();
    	error.setMessage(ex.getMessage());
    	error.setStatus(HttpStatus.NOT_FOUND.value());
    	error.setTime(new Date());
        return error;
    }
    
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleVersementNonExistantException(VersementNonExistantException ex, WebRequest request) {
    	LOGGER.debug("VersementNonExistantException Handler");
    	ErrorResponse error = new ErrorResponse();
    	error.setMessage(ex.getMessage());
    	error.setStatus(HttpStatus.NOT_FOUND.value());
    	error.setTime(new Date());
        return error;
    }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorResponse handleTransactionException(TransactionException ex, WebRequest request) {
    	LOGGER.debug("TransactionException Handler");
    	ErrorResponse error = new ErrorResponse();
    	error.setMessage(ex.getMessage());
    	error.setStatus(HttpStatus.BAD_REQUEST.value());
    	error.setTime(new Date());
        return error;
    }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception ex, WebRequest request) {
    	LOGGER.debug("Exception	 Handler");

    	ErrorResponse error = new ErrorResponse();
    	error.setMessage(ex.getMessage());
    	error.setStatus(HttpStatus.BAD_REQUEST.value());
    	error.setTime(new Date());
        return error;
    }
}
