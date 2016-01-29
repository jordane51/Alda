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
		em.getTransaction().begin();
		em.persist(listing);
		em.getTransaction().commit();
		
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
}
