package Service;

import java.util.List;

import model.Employee;

public interface EmployeeService {
	
	
	void addEmployee(Employee employee);
	static void updateEmployee() {
		// TODO Auto-generated method stub
		
	}
	Employee getEmployee(int Employee_id);
	List<Employee> getAllEmployee();
	void deleteEmployee(int Employee_id);
	static void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}
		
}