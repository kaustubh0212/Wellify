package domain;

public class patient {
	private int patientId;
	private String name;
	private String email;
	private String password;
	private int age;
	private String phone;
	
	public patient()
	{
		super();
	}
	
	public patient(String name, String email, String password, String phone, int age)
	{
		super();
		this.age = age;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
