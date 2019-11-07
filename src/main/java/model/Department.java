package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "Department")
@Inheritance(strategy = InheritanceType.JOINED)
//To increase speed and save sql statement execution time.
@DynamicInsert
@DynamicUpdate
public class Department {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	
	@Column(name = "Department_id")
	private int Department_id;
	
	//@OneToOne
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "Employee_department")
	Employee employee;
	
	@Column(name = "Department_name")
	private String Department_name;
	
	public Department() {
	}

	public Department(int department_id, String department_name) {
		super();
		Department_id = department_id;
		Department_name = department_name;
	}
	
	public String getDepartment_name() {
		return Department_name;
	}
	
	public void setDepartment_name(String department_name) {
		Department_name = department_name;
	}
	
	public int getDepartment_id() {
		return Department_id;
	}
	
	public void setDepartment_id(int department_id) {
		Department_id = department_id;
	}

@Override
	public String toString() {
		return "Department [employee=" + employee + ", Department_name=" + Department_name + "]";
	}
}