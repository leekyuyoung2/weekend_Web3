package dto;
// Database에서 member 테이블의 데이터 한건을 담는 객체
// java Bean이라고 도 하고 pojo 라고도 함... --> 순수자바 객체
public class MemberDTO {

	// 맴버변수는 member테이블의 컬럼명 및 타입과 일치
	private int id;
	private String uid;
	private String upswd;
	private String uname;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpswd() {
		return upswd;
	}
	public void setUpswd(String upswd) {
		this.upswd = upswd;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", uid=" + uid + ", upswd=" + upswd + ", uname=" + uname + "]";
	}
	
}
