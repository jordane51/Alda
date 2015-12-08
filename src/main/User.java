package main;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.apache.bval.constraints.Email;

@Entity
@Table(name = "alda.User")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Size(max = 45, message = "Le prénom doît avoir 45 caractères au maximum !")
	@Basic
	private String firstName;
	
	@Size(max = 45, message = "Le nom doît avoir 45 caractères au maximum !")
	@Basic
	private String lastName;
	
	@Size(max = 45, message = "Le mot de passe doît avoir 45 caractères au maximum !")
	@Basic(optional = false)
	private String password;
	
	@Size(max = 200, message = "L'email doît avoir 200 caractères au maximum !")
	@Basic(optional = false)
	@Email
	private String email;
	
	@Past(message = "La date doît être passée !")
	private Date birthday;
	
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
	public void setId(int id) {
		this.id = id;
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
