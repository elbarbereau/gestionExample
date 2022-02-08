package fr.formation.inti.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entity.Employee;

@Repository
public class EmployeeDao extends GenericDaoHibernate<Employee, Integer> implements IEmployeeDao {

	private static final Log log = LogFactory.getLog(EmployeeDao.class);

	private static EmployeeDao dao;
	
	public static EmployeeDao createInstance() {
		if(dao == null) {
			dao = new EmployeeDao();
		}
		return dao;
	}
	
	@PostConstruct
	private void postConstruct() {
		log.info("------------------ postConstruct() ------------------");
	}
	
	@PreDestroy
	private void preDestroy() {
		log.info("------------------ preDestroy() ------------------");

	}
}
