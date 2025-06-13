package domain;

public class doctor {
	private int doctorId;
	private String name;
	private String email;
	private String password;
	private int age;
	private String qualification;
	private String address;
	private int fees;
	private String specialization;
	private String phone;
	
	public doctor()
	{
		super();
	}
	
	public doctor(String name, String email, String password, int age, String qualification,
			String address, int fees, String specialization, String phone)
	{
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.qualification = qualification;
		this.address = address;
		this.fees = fees;
		this.specialization = specialization;
		this.phone = phone;
	}

	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	
	
}
