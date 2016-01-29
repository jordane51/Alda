package listing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import user.UserBean;

@ManagedBean
@RequestScoped
public class CreateListingBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2619941201801159313L;

	@EJB
	private ListingService service;
	
	private Listing newListing = new Listing();

	public String createListing(){
		this.service.add(this.newListing);
		return "profile";
	}
	
	public Listing getNewListing(){
		return this.newListing;
	}
	
	public void setNewListing(Listing l){
		this.newListing = l;
	}
}
