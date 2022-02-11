package fr.formation.inti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.IUserDao;
import fr.formation.inti.entity.User;


@Service
@Transactional
public class UserService implements IUserService{
	
	@Autowired
	private IUserDao dao ;
	
	public UserService() {
		
	}
	
	public IUserDao getDao() {
		return dao;
	}

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	public User findByLoginAndPassword(String login, String password) {
		User user = dao.findByLoginAndPassword(login, password);
		return user;
	}

	public Integer ajouterUser(User user) {
		Integer id = dao.save(user);
		return id;
	}
	


}
