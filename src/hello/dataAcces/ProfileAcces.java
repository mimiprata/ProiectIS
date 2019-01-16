package hello.dataAcces;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import hello.domainModel.Offer;
import hello.domainModel.Profile;
import hello.domainModel.User;
@Service
public class ProfileAcces {
	public Profile getProfile(int id) {
		Profile profile = new Profile();
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			profile = (Profile) sessionObj.get(Profile.class, id);
			sessionObj.close();
			return profile;
		} catch (Exception e) {

			return profile;
		}

	}

	public void addProfile(Profile p) {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			sessionObj.save(p);
			sessionObj.getTransaction().commit();
			sessionObj.close();
		} catch (Exception e) {
			System.out.println("Not working");
		}
	}
	public void deleteProfile(int id){
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			Profile profile = sessionObj.find(Profile.class, id);
			sessionObj.remove(profile);
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateProfile(Profile p){
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			sessionObj.update(p);
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Not working");
		}
	}
}
