package hello.dataAcces;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hello.domainModel.Hotel;
import hello.domainModel.Profile;
import hello.domainModel.User;

@Service
public class UserAcces {
	public User getUser(int id) {
		User user = new User();
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			user = (User) sessionObj.get(User.class, id);
			sessionObj.close();
			return user;
		} catch (Exception e) {

			return user;
		}

	}
   
	public int loginUser(String name, String password) {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			Query<User> query = sessionObj.createQuery("from User");
			List<User> users = query.getResultList();
			for (User user : users) {
				if (user.getName().equals(name)) {
					if (user.getPassword().equals(password)) {
						sessionObj.close();
						return user.getType();
					}
				}
			}
			sessionObj.close();
			return -1;
		} catch (Exception e) {
			return -2;
		}
	}

	public int addUser(String name, String password) {
		Random rand = new Random();
		int id = rand.nextInt(30000);
		try {
			User user = new User(id, 0, id, name, password);
			Profile profile = new Profile(id);
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			sessionObj.save(profile);
			sessionObj.getTransaction().commit();
			sessionObj.beginTransaction();
			sessionObj.save(user);
			sessionObj.getTransaction().commit();
			sessionObj.close();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not working");
		}
		return -1;
	}
	public void deleteUser(int id) {
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			User user = sessionObj.find(User.class, id);
			System.out.println(id);
			sessionObj.remove(user);
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Not working");
			e.printStackTrace();
		}
	}
	public void updateUser(User u) {
		try {
			deleteUser(u.getId());
			System.out.println(u.getId());
			addUser(u.getName(),u.getPassword());
		} catch (Exception e) {
			System.out.println("Not working");
		}
	}
	
	/*public void updateUser(User p){
		try {
			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
			sessionObj.beginTransaction();
			sessionObj.update(p);
			sessionObj.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Not working");
		}
	}*/
}
