package model;

import java.sql.Date;

public class StudentDTO {
	private int id;
	private String USERNAME;
	private String UNIV;
	private Date BIRTH;
	private String EMAIL;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getUNIV() {
		return UNIV;
	}
	public void setUNIV(String uNIV) {
		UNIV = uNIV;
	}
	
	public Date getBIRTH() {
		return BIRTH;
	}
	public void setBIRTH(Date bIRTH) {
		BIRTH = bIRTH;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	
}
