package hoge;

public class StatusDataBean {

	public StatusDataBean (String id, String status, String compDate1, String compDate2, String compDate3) {
		this.id = id;
		this.status= status;
		this.compDate1 = compDate1;
		this.compDate2 = compDate2;
		this.compDate3 = compDate3;
	}
	private String id;
	private String status;
	private String compDate1;
	private String compDate2;
	private String compDate3;
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCompDate1() {
		return compDate1;
	}
	public void setCompDate1(String compDate1) {
		this.compDate1 = compDate1;
	}
	public String getCompDate2() {
		return compDate2;
	}
	public void setCompDate2(String compDate2) {
		this.compDate2 = compDate2;
	}
	public String getCompDate3() {
		return compDate3;
	}
	public void setCompDate3(String compDate3) {
		this.compDate3 = compDate3;
	}
	public String getId() {
		return id;
	}
}
