package model;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@SpringBootApplication
@Configuration
@ComponentScan()
@EnableJpaRepositories(basePackages="repository")
//@EnableTransactionManagement
//@ComponentScan(basePackages= {"Controller"})

public class SpringBootCrudMySqlApplication {

//	@Configuration(proxyBeanMethods = false)
	@Bean
	public static void main(String[] args) throws IOException{
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("persistence-context.xml");
		SpringApplication.run(SpringBootCrudMySqlApplication.class, args);
		
		EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("JPAUNIT");

        EntityManager entityManager2 = entityManager.createEntityManager();

        EntityTransaction transaction = entityManager2.getTransaction();

        transaction.begin();

        Employee employee = new Employee();

        employee.setEmployee_id(103);
        employee.setEmployee_name("Senthil ");
        employee.setEmployee_address("Pune");
        employee.setEmployee_designation("developer");
        employee.setEmployee_department("tech");
        employee.setEmployee_salary(50000);
        entityManager2.persist(employee);

        transaction.commit();
		

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

}