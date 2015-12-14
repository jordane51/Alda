package main;

import java.io.Serializable;

import javax.ejb.*;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

@Named
@SessionScoped
@TransactionManagement(TransactionManagementType.BEAN)

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceUnit(unitName="userPersistenceUnit")
	private EntityManagerFactory entityManagerFactory;
	
	private User user = new User();
	
	public User getUser(){		
		return user;
	}

	public String signUp(){
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		logIn();
		return "profile.xhtml";
	}

	public String logIn(){
		EntityManager em = entityManagerFactory.createEntityManager();
		Query query = em.createQuery("Select u FROM User u WHERE u.email = :email AND u.password = :password");
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		user = (User)query.getSingleResult();
		return "profile.xhtml";
	}

	public String edit(){
		EntityManager em = entityManagerFactory.createEntityManager();
		String query = "UPDATE User i SET i.email = :email,"
				+ " i.firstName = :firstName, i.lastName = :lastName,"
				+ " i.password = :password, i.birthday = :birthday WHERE i.id = :id";
		Query q = em.createQuery(query, User.class);
		q.setParameter("id", user.getId());
		q.setParameter("email", user.getEmail());
		q.setParameter("firstName", user.getFirstName());
		q.setParameter("lastName", user.getLastName());
		q.setParameter("password", user.getPassword());
		q.setParameter("birthday", user.getBirthday());
		q.executeUpdate();
		return "profile.xhtml";
	}

}
