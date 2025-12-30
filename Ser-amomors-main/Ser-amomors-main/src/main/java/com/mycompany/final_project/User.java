/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.final_project;

/**
 *
 * @author compvtre
 */
public class User {
	private final String username;
	private final String password;
	private int score = 0;
	private boolean isAdmin = false;
	private String remarks = "FAILED";

	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getUsername() {return username;}
	public String getPassword() {return password;}
	public boolean isAdmin() {return isAdmin;}
	public int getScore() {return score;}

	public void setAdmin() 
	{
		this.isAdmin = true;
	}
	public void setScore(int score)
	{
		this.score = score;
	}

	public String getRemarks(){
		if (score >= 15) this.remarks = "EXCELLENT";
		else if (score >= 12) this.remarks = "VERY GOOD";
	     	else if (score >= 9) this.remarks = "FAIR";
	     	else this.remarks = "FAILED";
		return remarks;
	}



	
}
