package model;
/**
 * DB Table news의 데이터를 저장 
 */
public class News {
	private int aid;
	private String title;
	private String img;
	private String date;
	private String content;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "News [aid=" + aid + ", title=" + title + ", img=" + img + ", date=" + date + ", content=" + content
				+ "]";
	}
	
}
