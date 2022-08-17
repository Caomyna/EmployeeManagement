package Model;

import java.util.Date;

public class Employee {
	
	private String  employeeID, name, gender, phone, email, address, position;
	private Date dob;
	private float salary; 

	public Employee() {
	}
		
	public Employee(String employeeID, String name, Date dob, String gender, String phone, String email, String address,
			String position, float salary) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.position = position;
		this.salary = salary;
	}
	

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
