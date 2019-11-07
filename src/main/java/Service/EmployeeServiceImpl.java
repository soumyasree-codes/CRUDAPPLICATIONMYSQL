package Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Employee;
import repository.EmployeeRepository;

@Component
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
@Transactional
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
		// TODO Auto-generated method stub
		
	}

	public void updateEmployee(Employee employee) {
		
		employeeRepository.save(employee);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployee(int Employee_id) {
		// TODO Auto-generated method stub
		return employeeRepository.findOne(Employee_id);
	}

	@Override
@Transactional
	public List<Employee> getAllEmployee() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		// TODO Auto-generated method stub
		return employees;
	}

	@Override
@Transactional
	public void deleteEmployee(int Employee_id) {
		// TODO Auto-generated method stub
		employeeRepository.delete(Employee_id);
	}





//@Transactional(rollbackFor==NumberFormatException.class)
	
		@RequestMapping("/setData")
		public String setData()
		{
			int a=0;
			if(a==0)
			{
				throw new NumberFormatException();
				
			}
			return "Data inserted";
			
		}

}