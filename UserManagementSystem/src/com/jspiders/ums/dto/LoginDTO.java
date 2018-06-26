package com.jspiders.ums.dto;
import java.io.Serializable;
public class LoginDTO implements Serializable
{
	private String email;
	private String password;
	public LoginDTO()
	{
		System.out.println(this.getClass().getSimpleName()+"created");
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
	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}

}
