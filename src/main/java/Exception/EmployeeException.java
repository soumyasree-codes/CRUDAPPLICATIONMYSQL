package Exception;

public class EmployeeException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	 
	    public EmployeeException() {
	        super("Employee does not exist");
	    }
	    
}