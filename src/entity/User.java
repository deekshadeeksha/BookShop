package entity;

import java.util.Date;

public  class User {
	
	public String userId;
	private String password;
	private String name;
	private String address;
	private long phone;
	private Date dob;
	private String gender;
	private String question;
	private String answer;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
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
	public User(String userId, String password, String name, String address, long phone, Date dob, String gender,
			String question, String answer) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.question = question;
		this.answer = answer;
	}
	
	
	

}
