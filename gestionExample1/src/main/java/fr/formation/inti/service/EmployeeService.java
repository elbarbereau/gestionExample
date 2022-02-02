package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.dao.EmployeeDao;
import fr.formation.inti.dao.IEmployeeDao;
import fr.formation.inti.entity.Employee;

public class EmployeeService implements IEmployeeService{
	
	private IEmployeeDao dao ;
	
	public EmployeeService() {
		dao = new EmployeeDao();
	}

	@Override
	public Employee findEmployeeById(Integer id) {
		dao.beginTransaction();
		Employee employee = dao.findById(id);
		dao.commitTransaction();
		return employee;
	}

	@Override
	public List<Employee> findAllEmployee() {
		dao.beginTransaction();
		List<Employee> employees = dao.findAll();
		dao.commitTransaction();
		return employees;
	}

	@Override
	public Integer addEmployee(Employee employee) {
		dao.beginTransaction();
		Integer id = dao.save(employee);
		dao.commitTransaction();
		return id;
	}

	@Override
	public void updateEmployee(Employee employee) {
		dao.beginTransaction();
		dao.update(employee);
		dao.commitTransaction();
		
	}

	@Override
	public void deleteEmployee(Integer id) {
		dao.beginTransaction();
		Employee e = dao.findById(id);
		dao.delete(e);
		dao.commitTransaction();
	}

	@Override
	public Integer findEmployeeId(Employee employee) {
		dao.beginTransaction();
		Integer id = dao.findEmployeeId(employee);
		dao.commitTransaction();
		return id;
	}

}
