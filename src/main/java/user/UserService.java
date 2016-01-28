package user;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class UserService {
	
	@PersistenceContext(unitName="mysqlPersistenceUnit")
	private EntityManager em;
	
	public void add(User user){
		em.persist(user);
	}
	
	public User load(User user){
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :password");
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		List<User> users = query.getResultList();
		if (users.isEmpty())
			return null;
		else
			return users.get(0);
	}
	
	public void update(User user){
		String query = "UPDATE User u SET u.email = :email,"
				+ " u.firstName = :firstName, u.lastName = :lastName,"
				+ " u.password = :password, u.birthday = :birthday WHERE u.id = :id";
		Query q = em.createQuery(query, User.class);
		q.setParameter("id", user.getId());
		q.setParameter("email", user.getEmail());
		q.setParameter("firstName", user.getFirstName());
		q.setParameter("lastName", user.getLastName());
		q.setParameter("password", user.getPassword());
		q.setParameter("birthday", user.getBirthday());
		q.executeUpdate();
	}
}
