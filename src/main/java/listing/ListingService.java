package listing;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ListingService {
	
	@PersistenceContext(unitName="mysqlPersistenceUnit")
	private EntityManager em;
	
	public void add(Listing listing){
		em.persist(listing);
	}
	
	public void remove(Listing listing){
		em.remove(listing);
	}
	
	public List<Listing> loadAll(){
		Query query = em.createQuery("SELECT l FROM Listing l");
		List<Listing> listings = query.getResultList();
		return listings;
	}
	
	public List<Listing> loadRecents(){
		Query query = em.createQuery("SELECT l FROM Listing l ORDER by l.id DESC");
		List<Listing> listings = query.setMaxResults(12).getResultList();
		return listings;
	}
	
	public List<Listing> listingsForUserId(int userId){
		Query query = em.createQuery("SELECT l FROM Listing l WHERE l.userId =" + userId);
		List<Listing> listings = query.getResultList();
		return listings;
	}
	
	public List<Listing> listingsByKeyword(String keyword){
		Query query = em.createQuery("SELECT l FROM Listing l WHERE l.location LIKE :key1 OR l.description LIKE :key2");
		query.setParameter("key1", "%" + keyword + "%");
		query.setParameter("key2", "%" + keyword + "%");
		List<Listing> listings = query.getResultList();
		return listings;
	}
}
