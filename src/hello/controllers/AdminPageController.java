package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hello.domainModel.Hotel;
import hello.domainModel.Offer;
import hello.domainModel.User;

@Controller
public class AdminPageController {

	@RequestMapping(value ="/hotelCreate", method = RequestMethod.GET)
	 public ModelAndView adminChoice1() {
		System.out.println("9");
			return new ModelAndView("hotelform","command",new Hotel());
		}
	@RequestMapping(value ="/hotelDelete", method = RequestMethod.GET)
	 public ModelAndView adminChoice12() {
		System.out.println("9");
			return new ModelAndView("hotelform2","command",new Hotel());
		}
	@RequestMapping(value ="/hotelUpdate", method = RequestMethod.GET)
	 public ModelAndView adminChoice13() {
		System.out.println("9");
			return new ModelAndView("hotelform3","command",new Hotel());
		}
	@RequestMapping(value ="/hotelRead", method = RequestMethod.GET)
	 public ModelAndView adminChoice14() {
		System.out.println("9");
			return new ModelAndView("hotelform4","command",new Hotel());
		}
	@RequestMapping(value ="/offerCreate", method = RequestMethod.GET)
	 public ModelAndView adminChoice2() {
		System.out.println("9");
			return new ModelAndView("offer","command",new Offer());
		}
	@RequestMapping(value ="/offerDelete", method = RequestMethod.GET)
	 public ModelAndView adminChoice22() {
		System.out.println("9");
			return new ModelAndView("offer2","command",new Offer());
		}
	@RequestMapping(value ="/offerUpdate", method = RequestMethod.GET)
	 public ModelAndView adminChoice23() {
		System.out.println("9");
			return new ModelAndView("offer3","command",new Offer());
		}
	@RequestMapping(value ="/offerRead", method = RequestMethod.GET)
	 public ModelAndView adminChoice24() {
		System.out.println("9");
			return new ModelAndView("offer4","command",new Offer());
		}
}
