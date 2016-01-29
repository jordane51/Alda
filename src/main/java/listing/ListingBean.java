package listing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	private List<Listing> listings = new ArrayList<Listing>();
	
	public String open(Listing l){
		this.currentListing = l;
		System.out.println("Listing : "+l.getDescription());
		return "listing";
	}
	
	public String delete(Listing l){
		//TODO
		return "profile.xhtml";
	}
	
	public void createListing(){
		System.out.println("Yay"+this.currentListing.getLocation());
	}
	
	public Listing getCurrentListing(){
		return this.currentListing;
	}
	
	public void setCurrentListing(Listing l){
		this.currentListing = l;
	}
	
	public List<Listing> getListingsOwnedByUser(){
		listings = service.loadRecents();
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
