package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Service.EmployeeService;
import model.Employee;

@RestController
public class EmployeeContoller {
	
	 @RequestMapping(value = "/error")
	    public String error() {
	        return "Error handling";
	    }
	
		
	@Autowired 
	EmployeeService employeeService;
	
	
	@RequestMapping(value = "/employee", 
			method = RequestMethod.GET,  
			produces = { MediaType.APPLICATION_JSON_VALUE,  
					MediaType.APPLICATION_XML_VALUE })
	
	
	@ResponseBody
	@PostMapping("/employee/add")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@PutMapping(value="/employee/update")
	public void updateEmployee(@RequestBody Employee employee) {
		EmployeeService.updateEmployee(employee);
	}
	
	@GetMapping("/employee/{Employee_id}")
	public Employee getEmployee(@PathVariable("Employee_id") int Employee_id) {
		return employeeService.getEmployee(Employee_id);
	}
	
	
	@RequestMapping(value = "/employee/", 
			method = RequestMethod.DELETE, 
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE })
	
	@ResponseBody
	@DeleteMapping("/employee/release/{Employee_id}")
	public void releaseEmployee(@PathVariable int Employee_id) {
		employeeService.deleteEmployee(Employee_id);
	}
}