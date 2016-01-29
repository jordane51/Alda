package listing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import user.UserBean;

@ManagedBean
@SessionScoped
public class ListingBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5619941201801159313L;

	@EJB
	private ListingService service;
	
	private Listing currentListing = new Listing();
	private Listing newListing = new Listing();
	private List<Listing> listings = new ArrayList<Listing>();
	
	public String open(Listing l){
		this.currentListing = l;
		return "listing";
	}
	
	public String delete(Listing l){
		//TODO
		return "profile.xhtml";
	}
	
	public void createListing(){
		this.service.add(this.newListing);
		System.out.println("Yay"+this.newListing.getLocation());
	}
	
	public Listing getNewListing(){
		return this.newListing;
	}
	
	public void setNewListing(Listing l){
		this.newListing = l;
	}
	
	public Listing getCurrentListing(){
		return this.currentListing;
	}

	public void setCurrentListing(Listing l){
		this.currentListing = l;
	}
	
	public List<Listing> getListingsOwnedByUser(){
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		UserBean userBean
		    = (UserBean) FacesContext.getCurrentInstance().getApplication()
		        .getELResolver().getValue(elContext, null, "userBean");
		listings = service.listingsForUserId(userBean.getUser().getId());
		return listings;
	}
	
	public List<Listing> getRecentListings(){
		listings = service.loadRecents();
		return listings;
	}
	
	public List<Listing> getListings(){
		listings = service.loadAll();
		return listings;
	}
}
