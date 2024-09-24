package Collection;

import java.util.List;
import java.util.Set;

public class Student {
	private int id;
	private String fname;
	private String lname;
	private List<String> email;
	private Set<String> mobile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public List<String> getEmail() {
		return email;
	}
	public void setEmail(List<String> email) {
		this.email = email;
	}
	public Set<String> getMobile() {
		return mobile;
	}
	public void setMobile(Set<String> mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}
	public Student(int id, String fname, String lname, List<String> email, Set<String> mobile) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobile = mobile;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}