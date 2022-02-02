package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.entity.Employee;

public interface IEmployeeService {
	
	Employee findEmployeeById(Integer id) ;
	
	List<Employee> findAllEmployee() ;
	
	Integer addEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployee(Integer id);
	
	Integer findEmployeeId(Employee employee);

}
