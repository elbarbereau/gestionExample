package fr.formation.inti.dao;

import java.util.List;

import org.hibernate.query.Query;

import fr.formation.inti.entity.Employee;

public class EmployeeDao extends GenericDaoHibernate<Employee, Integer> implements IEmployeeDao {

	@Override
	public Integer findEmployeeId(Employee employee) {
		Query<Employee> query = session.createQuery(
				"from " + Employee.class.getName() + " e where e.firstName= :firstName and e.lastName = :lastName"
						+ " and e.startDate = :startDate and e.manager = :manager and e.subordonnees = :subordonnees", Employee.class);
		query.setParameter("firstName", employee.getFirstName());
		query.setParameter("lastName", employee.getLastName());
		query.setParameter("startDate", employee.getStartDate());
		query.setParameter("manager", employee.getManager());
		query.setParameter("subordonnees", employee.getSubordonnees());
		List<Employee> list = query.getResultList();
		if(list.isEmpty())
			return null;
		return list.get(0).getEmpId();
	}
	

}
