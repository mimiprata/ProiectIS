package hello.domainModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="id")
    private int id;
	
	@Column(name="type")
    private int type;
	
	@Column(name="profileID")
    private int profileID;
	
	@Column(name="name")
    private String name;
	
	@Column(name="password")
    private String password;
    
    public User(){
    	this.id=0;
    	this.type=0;
    	this.profileID=0;
    	this.name=null;
    	this.password=null;
    }
    public User(int id, int type, int profileID, String name, String pass){
    	this.id=id;
    	this.type=type;
    	this.profileID=profileID;
    	this.name=name;
    	this.password=pass;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getProfileID() {
		return profileID;
	}
	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
