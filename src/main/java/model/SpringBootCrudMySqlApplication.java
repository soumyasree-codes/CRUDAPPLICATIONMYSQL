package model;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@SpringBootApplication
@Configuration
@ComponentScan()
@EnableJpaRepositories(basePackages="repository")
//@EnableTransactionManagement
//@ComponentScan(basePackages= {"Controller"})
@PropertySource("classpath:application.properties")
public class SpringBootCrudMySqlApplication {

//	@Configuration(proxyBeanMethods = false)
	@Bean
	public static void main(String[] args) throws IOException{
	
		SpringApplication.run(SpringBootCrudMySqlApplication.class, args);
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("JPAUNIT");

        EntityManager entityManager = entityFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        
       // EntityTransaction transaction = entityManager2.getTransaction();
       //transaction.begin();
        
        /*Creating an employee*/
        Employee employee = new Employee();

        employee.setEmployee_id(103);
        employee.setEmployee_name("Senthil ");
        employee.setEmployee_address("Pune");
        employee.setEmployee_designation("developer");
        employee.setEmployee_department("tech");
        employee.setEmployee_salary(50000);
       
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

       // transaction.commit();
		entityManager.close();
		entityFactory.close();
		
		/*Update employee*/
		
			//EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("JPAUNIT");
			//EntityManager entityManager = entityFactory.createEntityManager();        
        	//entityManager.getTransaction().begin();       
			//Employee employee = entityManager.find(Employee.class, 101);
		  
		employee = entityManager.find(Employee.class, 101);
		  
        //before update
        System.out.print(employee);
        employee.setEmployee_salary(30000);
        entityManager.getTransaction().commit();
        
        //after update
        System.out.print(employee);
        entityManager.close();
        entityFactory.close();

        /*Delete an employee*/
        
      //EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("JPAUNIT");
		//EntityManager entityManager = entityFactory.createEntityManager();        
    	//entityManager.getTransaction().begin();       
		//Employee employee = entityManager.find(Employee.class, 101);
        
        employee = entityManager.find(Employee.class, 101);
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityFactory.close();
        
        
	}
}
	
	/*@Bean
	    public DriverManagerDataSource dataSource(){
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/user_db");
	        dataSource.setUsername("root");
	        dataSource.setPassword("abcd@1234");
	        return dataSource;
	    }*/

