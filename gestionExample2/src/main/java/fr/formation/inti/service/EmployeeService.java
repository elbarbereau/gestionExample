package fr.formation.inti.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.IEmployeeDao;
import fr.formation.inti.entity.Employee;

@Service
@Transactional
public class EmployeeService implements IEmployeeService{
	
	private static final Log log = LogFactory.getLog(EmployeeService.class);
	
	@Autowired
	private IEmployeeDao dao;

	public EmployeeService(){

	}
	@Override
	public Integer save(Employee employee) {
		return dao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		dao.update(employee);
	}

	@Override
	public void delete(Employee employee) {
		dao.delete(employee);
	}

	@Override
	public Employee findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = dao.findAll();
		return list;
	}
	public static void main(String[] args) {
		EmployeeService service = new EmployeeService();
		List<Employee> list = service.findAll();
		for(Employee e:list)
			log.info(e);
	}
	public IEmployeeDao getDao() {
		return dao;
	}
	public void setDao(IEmployeeDao dao) {
		this.dao = dao;
	}
	
	
	
}
