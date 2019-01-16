package hello.dataAcces;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import hello.domainModel.Hotel;
import hello.domainModel.Offer;
import hello.domainModel.User;
@Service
public class OfferAcces {
	public Offer getOffer(int id) {
		Offer offer = new Offer();
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			offer = (Offer) sessionObj.get(Offer.class, id);
			sessionObj.close();
		} catch (Exception e) {
			System.out.println("Not working!");
		}
		return offer;
	}

	public void addOffer(Offer o) {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			sessionObj.save(o);
			sessionObj.getTransaction().commit();
			sessionObj.close();
		} catch (Exception e) {
			System.out.println("Not working");
		}
	}

	public void deleteOffer(int id) {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			Offer offer = sessionObj.find(Offer.class, id);
			sessionObj.remove(offer);
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateOffer(Offer o) {
		try {
			deleteOffer(o.getId());
			addOffer(o);
		} catch (Exception e) {
			System.out.println("Not working");
		}
	}

	public List<Offer> getAll() {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			Query<Offer> query = sessionObj.createQuery("from Offer");
			List<Offer> offerts = query.getResultList();
			return offerts;
		} catch (Exception e) {
			System.out.println("Not working");
			return null;
		}
	}
	public List<Offer> getAllByPlace(String place) {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			Query<Offer> query = sessionObj.createQuery("from Offer where place='"+place+"'");
			List<Offer> offerts = query.getResultList();
			return offerts;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not working");
			return null;
		}
	}
}
