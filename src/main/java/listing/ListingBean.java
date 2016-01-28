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
	
	private List<Listing> listings = new ArrayList<Listing>();
	
	public List<Listing> getListings(){
		listings = service.loadAll();
		return listings;
	}
}
