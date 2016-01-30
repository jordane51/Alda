package listing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SearchBean  implements Serializable{

	private static final long serialVersionUID = 2619941201801152313L;

	@EJB
	private ListingService service;
	
	private List<Listing> listings = new ArrayList<Listing>();
	
	private String keyword;
	
	public String getKeyword(){
		return keyword;
	}
	
	public void setKeyword(String keyword){
		this.keyword = keyword;
	}
	
	public List<Listing> getResults(){
		return listings;
	}
	
	public String search(){
		listings = service.listingsByKeyword(keyword);
		return "results";
	}
}
