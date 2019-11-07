package repository;
//dao
//import java.io.Serializable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Employee;

@Repository
//public interface EmployeeRepository extends JpaRepository<Employee, Serializable>
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public Employee findByEmployee_id(int Employee_id);
	public List<Employee> findByEmployee_designation(String Employee_designation);
	//public Person save(Person entity);
	public Employee findOne(int employee_id);
	public void delete(int employee_id);
}