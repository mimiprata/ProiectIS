package hello.domainModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
public class Offer {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "hotelID")
	private int hotelID;
	
	@Column(name = "place")
	private String place;
	
	@Column(name = "time")
	private String time;

	public Offer(int id, int price, int hotelID, String place, String time) {
		this.id = id;
		this.price = price;
		this.hotelID = hotelID;
		this.place = place;
		this.time = time;
	}

	public Offer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
