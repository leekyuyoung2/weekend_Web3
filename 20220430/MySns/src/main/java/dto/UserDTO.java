package dto;

import java.sql.Timestamp;

public class UserDTO {
	private  String   id;
    private String password;
    private String name;
    private Timestamp TIMESTAMP;
    private String confirmpasswod;
    
	public String getConfirmpasswod() {
		return confirmpasswod;
	}
	public void setConfirmpasswod(String confirmpasswod) {
		this.confirmpasswod = confirmpasswod;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getTIMESTAMP() {
		return TIMESTAMP;
	}
	public void setTIMESTAMP(Timestamp tIMESTAMP) {
		TIMESTAMP = tIMESTAMP;
	}
	@Override
	public String toString() {
		return "FeedDTO [id=" + id + ", password=" + password + ", name=" + name + ", TIMESTAMP=" + TIMESTAMP + "]";
	}
}
