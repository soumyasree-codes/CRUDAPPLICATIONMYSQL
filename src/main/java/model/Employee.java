package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown= true)
@Entity
@Table(name = "Employee")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)

//To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class Employee {

	@Id 
	//@GeneratedValue(strategy= GenerationType.IDENTITY)
	@GeneratedValue( strategy = GenerationType.AUTO )
	
	@Column(name = "Employee_id")
	private int Employee_id;
	
	@Column(name = "Employee_name")
	private String Employee_name;
	
	@Column(name = "Employee_address")
	private String Employee_address;
	
	@Column(name = "Employee_designation")
	private String Employee_designation;
	
	@Column(name = "Employee_department")
	private String Employee_department;
	
	@Column(name = "Employee_salary")
	private int Employee_salary;
	
	@OneToOne(mappedBy = "Employee" )
	Department Department;
	
	
	public Employee() {
	}

	public Employee(int employee_id, String employee_name, String employee_address, String employee_designation,
			String employee_department, int employee_salary) {
		super();
		Employee_id = employee_id;
		Employee_name = employee_name;
		Employee_address = employee_address;
		Employee_designation = employee_designation;
		Employee_department = employee_department;
		Employee_salary = employee_salary;
	}

	public int getEmployee_id() {
		return Employee_id;
	}

	public void setEmployee_id(int employee_id) {
		Employee_id = employee_id;
	}

	public String getEmployee_name() {
		return Employee_name;
	}

	public void setEmployee_name(String employee_name) {
		Employee_name = employee_name;
	}

	public String getEmployee_address() {
		return Employee_address;
	}

	public void setEmployee_address(String employee_address) {
		Employee_address = employee_address;
	}

	public String getEmployee_designation() {
		return Employee_designation;
	}

	public void setEmployee_designation(String employee_designation) {
		Employee_designation = employee_designation;
	}

	public String getEmployee_department() {
		return Employee_department;
	}

	public void setEmployee_department(String employee_department) {
		Employee_department = employee_department;
	}

	public int getEmployee_salary() {
		return Employee_salary;
	}

	public void setEmployee_salary(int employee_salary) {
		Employee_salary = employee_salary;
	}





@Override
	public String toString() {
		return "Employee [Employee_name=" + Employee_name + ", Employee_address=" + Employee_address
				+ ", Employee_designation=" + Employee_designation + ", Employee_department=" + Employee_department
				+ ", Department=" + Department + "]";
	}
	
}