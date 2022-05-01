package dto;

import java.sql.Timestamp;

public class FeedDTO {
	private Long no;
    private String id;    
    private String content;
    private Timestamp ts;
    private String images;
    
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	@Override
	public String toString() {
		return "FeedDTO [no=" + no + ", id=" + id + ", content=" + content + ", ts=" + ts + ", images=" + images + "]";
	}
	
    
    
    
}
