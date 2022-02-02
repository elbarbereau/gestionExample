package fr.formation.inti.dao;

import java.util.List;

import org.hibernate.query.Query;

import fr.formation.inti.entity.User;

public class UserDao extends GenericDaoHibernate<User, Integer> implements IUserDao {

	public User findByLoginAndPassword(String login, String password) {
		Query<User> query = session.createQuery(
				"from " + User.class.getName() + " u where u.login= :login and u.password = :pass", User.class);
		query.setParameter("login", login);
		query.setParameter("pass", password);
		List<User> list = query.getResultList();
		if(list.isEmpty())
			return null;
		return list.get(0);
	}

}
