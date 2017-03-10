package hoge;

public class FlowHeaderBean {
	public FlowHeaderBean(String status, String statusName, String col1, String col2, String col3) {
		this.status = status;
		this.statusName =statusName;
		this.col1 = col1;
		this.col2 = col2;
		this.col3 = col3;
	}

	private String status;
	private String statusName;
	private String col1;
	private String col2;
	private String col3;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getCol1() {
		return col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}
}
