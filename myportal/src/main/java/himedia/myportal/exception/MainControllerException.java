package himedia.myportal.exception;

public class MainControllerException extends RuntimeException{
	
	public MainControllerException() {
		super("MainControllerException occurs!");
	}
	
	public MainControllerException(String message) {
		super(message);
	}
	
	
	
}
