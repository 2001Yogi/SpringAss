
package com.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.model.User;
import org.hibernate.query.Query;
public class UserDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public void inserOrUpdatetUser(User u) {
		this.hibernateTemplate.saveOrUpdate(u);
	}
	@Transactional
	public void deleteUser(int id) {
		User u = getUserById(id);
		this.hibernateTemplate.delete(u);
	}
	
	public User getUserById(int id) {
		return this.hibernateTemplate.get(User.class, id);
	}
	
	public List<User> getAllUser(){
		return this.hibernateTemplate.loadAll(User.class);
	}
	
	@Transactional
	public User getUserByEmailPassword(String email, String password) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		String hql = "FROM User WHERE email = :email AND password = :password";
	    Query<User> query = session.createQuery(hql, User.class);  // Specify the User class for type safety
	    query.setParameter("email", email);
	    query.setParameter("password", password);
	    
	    // Get the result list (since the query may return more than one result)
	    List<User> users = query.getResultList();
	    
	    // Check if a user was found
	    if (!users.isEmpty()) {
	        return users.get(0);  // Return the first matching user
	    }
	    return null;  // No user found
	}

}
