package hoge;

public class HumanDataBean {

	public HumanDataBean (String id, String name) {
		this.id = id;
		this.name= name;
	}
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String status) {
		this.name = status;
	}
}
