package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
	
    public User(Integer id) {
		this.id = id;
	}
	// TO DO: Getters and setters
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
    // Implement a constructor that takes an ID
}
