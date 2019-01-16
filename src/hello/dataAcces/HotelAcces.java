package hello.dataAcces;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import hello.domainModel.Hotel;
import hello.domainModel.Profile;
@Service
public class HotelAcces {
	public Hotel getHotel(int id) {
		Hotel hotel = new Hotel();
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			hotel = (Hotel) sessionObj.get(Hotel.class, id);
			sessionObj.close();
		} catch (Exception e) {
			System.out.println("Not working");
		}
		return hotel;
	}

	public void addHotel(Hotel h) {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			sessionObj.save(h);
			sessionObj.getTransaction().commit();
			sessionObj.close();
		} catch (Exception e) {
			System.out.println("Not working");
		}
	}

	public void deleteHotel(int id) {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			Hotel hotel = sessionObj.find(Hotel.class, id);
			sessionObj.remove(hotel);
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Not working");
			e.printStackTrace();
		}
	}

	public void updateHotel(Hotel h) {
		try {
			deleteHotel(h.getId());
			addHotel(h);
		} catch (Exception e) {
			System.out.println("Not working");
		}
	}
}
