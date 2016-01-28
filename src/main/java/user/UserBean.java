package user;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3093919644734308037L;

	@EJB
	private UserService service;
	
	private User user = new User();
	
	public User getUser(){
		return user;
	}

	public String signUp(){
		user.setDateInscription(new Date());
		service.add(user);
		logIn();
		return "profile";
	}

	public String logIn(){
		User result = service.load(user);
		if (result==null)
			return "";
		else {
			user = result;
			return "profile";
		}
	}

	public void edit(){
		service.update(user);
	}

}
