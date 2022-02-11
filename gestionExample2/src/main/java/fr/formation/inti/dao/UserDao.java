package fr.formation.inti.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entity.User;

@Repository
public class UserDao extends GenericDaoHibernate<User, Integer> implements IUserDao {

	public User findByLoginAndPassword(String login, String password) {
		Query<User> query = getCurrentSession().createQuery(
				"from " + User.class.getName() + " u where u.login= :login and u.password = :pass", User.class);
		query.setParameter("login", login);
		query.setParameter("pass", password);
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (Exception e) {
		}
		return user;
		
		 
	}
}

