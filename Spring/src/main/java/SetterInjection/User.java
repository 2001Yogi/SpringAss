package SetterInjection;

public class User {
	private int id;
	private String name;
	private long contact;
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("id set by setter");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("name set by setter");
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		System.out.println("contact set by setter");
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		System.out.println("address set by setter");
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + "]";
	}
	
}