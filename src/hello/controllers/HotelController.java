package hello.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hello.dataAcces.HotelAcces;
import hello.dataAcces.OfferAcces;
import hello.dataAcces.UserAcces;
import hello.domainModel.Hotel;
import hello.domainModel.Offer;
import hello.domainModel.Profile;
import hello.domainModel.User;

@Controller
public class HotelController {
	@Autowired
	private HotelAcces hotelAcces;
	
	@Autowired
	private OfferAcces offerAcces;
	
	@RequestMapping(value = "/createHotel", method = RequestMethod.POST)
	public ModelAndView createHotelForm(@ModelAttribute("SpringWeb")Hotel hotel,
			ModelMap model) {
		model.addAttribute("hotel",hotel);
		hotelAcces.addHotel(hotel);
		System.out.println("2");
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/deleteHotel", method = RequestMethod.POST)
	public ModelAndView deleteHotelForm(@ModelAttribute("SpringWeb")Hotel hotel,
			ModelMap model) {
		model.addAttribute("hotel",hotel);
		hotelAcces.deleteHotel(hotel.getId());
		System.out.println("2");
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/updateHotel", method = RequestMethod.POST)
	public ModelAndView updateHotelForm(@ModelAttribute("SpringWeb")Hotel hotel,
			ModelMap model) {
		model.addAttribute("hotel",hotel);
		hotelAcces.updateHotel(hotel);
		System.out.println("2");
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/readHotel", method = RequestMethod.POST)
	public ModelAndView readHotelForm(@ModelAttribute("SpringWeb")Hotel hotel,
			ModelMap model) {
		model.addAttribute("hotel",hotel);
		Hotel hot =hotelAcces.getHotel(hotel.getId());
		model.addAttribute("hot",hot);
		System.out.println("2");
		return new ModelAndView("showhotel","command",hot);
	}
	
	@RequestMapping(value = "/createOffer", method = RequestMethod.POST)
	public ModelAndView createOfferForm(@ModelAttribute("SpringWeb")Offer offer,
			ModelMap model) {
		model.addAttribute("offer",offer);
		offerAcces.addOffer(offer);
		System.out.println("2");
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/deleteOffer", method = RequestMethod.POST)
	public ModelAndView deleteOfferForm(@ModelAttribute("SpringWeb")Offer offer,
			ModelMap model) {
		model.addAttribute("offer",offer);
		offerAcces.deleteOffer(offer.getId());
		System.out.println("2");
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/updateOffer", method = RequestMethod.POST)
	public ModelAndView updateOfferForm(@ModelAttribute("SpringWeb")Offer offer,
			ModelMap model) {
		model.addAttribute("offer",offer);
		offerAcces.updateOffer(offer);
		System.out.println("2");
		return new ModelAndView("home");
	}
	@RequestMapping(value = "/readOffer", method = RequestMethod.POST)
	public ModelAndView readOfferForm(@ModelAttribute("SpringWeb")Offer offer,
			ModelMap model) {
		model.addAttribute("offer",offer);
		Offer ofe =offerAcces.getOffer(offer.getId());
		model.addAttribute("ofe",ofe);
		System.out.println("2");
		return new ModelAndView("showoffer","command",ofe);
	}
	@RequestMapping(value = "/deleteOffer2", method = RequestMethod.POST)
	public ModelAndView deleteOfferForm2(@ModelAttribute("SpringWeb")Offer offer,
			ModelMap model) {
		model.addAttribute("offer",offer);
		offerAcces.deleteOffer(offer.getId());
		List<Offer> offerts=offerAcces.getAll();
		model.addAttribute("offerts",offerts);
		System.out.println("2");
		return new ModelAndView("home2");
	}
	
	@RequestMapping(value = "/suggest", method = RequestMethod.POST)
	public ModelAndView profileForm() {
		return new ModelAndView("suggest", "command", new Profile());
	}
}
