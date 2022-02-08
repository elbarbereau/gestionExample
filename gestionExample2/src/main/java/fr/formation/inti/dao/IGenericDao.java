package fr.formation.inti.dao;

import java.io.Serializable;
import java.util.List;


public interface IGenericDao<T, I extends Serializable> {
	
	I save(T t);
	
	void update(T t);
	
	void delete(T t);
	
	T findById(I i);
	
	List<T> findAll();


}
