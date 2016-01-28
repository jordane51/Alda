package user;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(fetch = FetchType.LAZY)
	private int id;
	
	@Size(max = 45, message = "Le prénom doît avoir 45 caractères au maximum !")
	@Basic(fetch = FetchType.LAZY)
	private String firstName;
	
	@Size(max = 45, message = "Le nom doît avoir 45 caractères au maximum !")
	@Basic(fetch = FetchType.LAZY)
	private String lastName;
	
	@Size(min=7, max = 45, message = "Le mot de passe doît avoir entre 7 et 45 caractères !")
	@Basic(fetch = FetchType.LAZY)
	private String password;
	
	@Size(max = 200, message = "L'email doît avoir au maximum 200 caractères !")
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
	        +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	             message="L'email n'a pas un format valide !")
	@Basic(fetch = FetchType.LAZY)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Past(message = "La date doît être passée !")
	@Basic(fetch = FetchType.LAZY)
	private Date birthday;
	
	@Temporal(TemporalType.DATE)
	@Basic(fetch = FetchType.LAZY)
	private Date dateInscription;
	
	public User(){
		firstName = null;
		lastName = null;
		email = null;
		password = null;
		birthday = null;
		dateInscription = new Date();
	}
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDateInscription() {
		return dateInscription;
	}


	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
