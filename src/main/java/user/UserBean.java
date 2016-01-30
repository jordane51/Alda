package user;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3093919644734308037L;

	@EJB
	private UserService service;



	private User user = new User();

	private boolean connected = false;

	public boolean getConnected(){
		return connected;
	}	

	public User getUser(){
		return user;
	}

	public String disconnect(){
		connected = false;
		user = new User();
		return "index";
	}

	public String signUp(){
		user.setDateInscription(new Date());
		service.add(user);
		//logIn();
		return "profile";
	}

	public String logIn(){
		System.out.println(user.getEmail());
		User result = service.load(user);
		if (result==null)
			return "";
		else {
			user = result;
			connected = true;
			return "profile";
		}
	}

	public void edit(){
		service.update(user);
	}

	// works only with a gmail adress
	public void recover(){
		SecureRandom random = new SecureRandom();
		String newPassword = new BigInteger(128, random).toString(32);
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user.getEmail(), user.getPassword());
					}
				  });

		MimeMessage message = new MimeMessage(session);
		try{

			message.setFrom(new InternetAddress("support@alda.net"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
			message.setSubject("Regeneration de votre mot de passe");
			message.setText("Voici votre nouveau mot de passe :" + newPassword);

			Transport.send(message);

		}catch (MessagingException me) {
			me.printStackTrace();
		}
	}

}
