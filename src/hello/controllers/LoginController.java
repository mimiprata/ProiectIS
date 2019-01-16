package hello.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hello.dataAcces.OfferAcces;
import hello.dataAcces.ProfileAcces;
import hello.dataAcces.UserAcces;
import hello.domainModel.Offer;
import hello.domainModel.Profile;
import hello.domainModel.User;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

	@Autowired
	private UserAcces userAcces;
	
	@Autowired
	private OfferAcces offerAcces;

	@Autowired
	private ProfileAcces profileAcces;

	private int userID;

	public UserAcces getUserAcces() {
		return userAcces;
	}

	public void setUserAcces(UserAcces userAcces) {
		this.userAcces = userAcces;
	}

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView("loginform", "command", new User());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("SpringWeb") User user, ModelMap model) {
		int result = userAcces.loginUser(user.getName(), user.getPassword());
		System.out.println(user.getName() + user.getPassword());
		if (result == 1) {

			return new ModelAndView("home");
		} else if (result == 0) {
			List<Offer> offerts=offerAcces.getAll();
			model.addAttribute("offerts",offerts);
			return new ModelAndView("home2", "command", new User());
		} else {
			return new ModelAndView("registerform");
		}
	}
	
	

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public ModelAndView registerForm() {
		return new ModelAndView("registerform", "command", new User());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("SpringWeb") User user, ModelMap model) {
		model.addAttribute("user", user);

		userID = userAcces.addUser(user.getName(), user.getPassword());
		return new ModelAndView("profileform", "command", new Profile());
	}

	@RequestMapping(value = "/profileForm", method = RequestMethod.GET)
	public ModelAndView profileForm() {
		return new ModelAndView("profileform", "command", new Profile());
	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ModelAndView addProfile(@ModelAttribute("SpringWeb") Profile profile, ModelMap model) {
		model.addAttribute("profile", profile);

		profile.setId(userID);
		profileAcces.updateProfile(profile);
		return new ModelAndView("loginform", "command", new User());
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView modifyUser() {
		return new ModelAndView("modify", "command", new User());
	}
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("SpringWeb")User user,
			ModelMap model) {
		model.addAttribute("user",user);
		userAcces.updateUser(user);
		System.out.println("2");
		return new ModelAndView("modify","command",new User());
	}
	
	
}
