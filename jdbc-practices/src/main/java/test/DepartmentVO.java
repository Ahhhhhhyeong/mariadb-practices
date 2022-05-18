package test;

public class DepartmentVO {
	private long no;
	private String name;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {		
		return "DepartmentVO [no="+no+ ", name=" + name+"]";
	}
	
	
}
