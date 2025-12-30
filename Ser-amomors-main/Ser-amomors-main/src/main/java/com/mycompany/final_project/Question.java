/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.final_project;

import java.util.List;

/**
 *
 * @author compvtre
 */
public class Question {
	private final String question;
	private final List<String> options;
	private final int correctIndex;
	private String result = "No Answer";
	
	public Question(String question, List<String> options, int correctIndex){
		this.question = question;
		this.options = options;
		this.correctIndex = correctIndex;
	}

	public String getQuestion(){return question;}
	public List<String> getOptions(){return options;}
	public String getCorrectAnswer(){return options.get(correctIndex);}
	public void setResult(String result){this.result = result;}
	public String getResult(){return result;}
}
