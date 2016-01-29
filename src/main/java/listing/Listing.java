package listing;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Listing implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8276506874316651726L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(fetch = FetchType.EAGER)
	private int id;
	
	@Basic(fetch = FetchType.EAGER)
	private int price;
	
	@Basic(fetch = FetchType.EAGER)
	private int surface;
	
	@Size(min=1, max = 45, message = "L'emplacement doît avoir entre 1 et 45 caractères !")
	@Basic(fetch = FetchType.EAGER)
	private String location;
	
	@Size(max = 200, message = "La description doît avoir au maximum 200 caractères !")
	@Basic(fetch = FetchType.EAGER)
	private String description;
	
	@Size(max = 200, message = "L'email doît avoir au maximum 200 caractères !")
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
	        +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
	             message="L'email n'a pas un format valide !")
	@Basic(fetch = FetchType.EAGER)
	private String email;
	
	@Size(max = 45, message = "Le numéro doît avoir au maximum 45 caractères !")
	@Basic(fetch = FetchType.EAGER)
	private String number;
	
	@Temporal(TemporalType.DATE)
	@Basic(fetch = FetchType.EAGER)
	private Date dateCreation;
	
	@Basic(fetch = FetchType.EAGER)
	private int userId;
	
	public Listing(){
		location = null;
		description = null;
		email = null;
		number = null;
		dateCreation = new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
}
