package bookshop.vo;

public class BookVo {
	private Long no;
	private String title;
	private String stateCode;
	private Long authoNo;
	private String name;
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public Long getAuthoNo() {
		return authoNo;
	}
	public void setAuthoNo(Long authoNo) {
		this.authoNo = authoNo;
	}
	
	
	
	
}
