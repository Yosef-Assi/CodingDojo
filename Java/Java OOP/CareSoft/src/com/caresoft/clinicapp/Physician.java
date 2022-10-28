package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;
public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;

	public Physician(Integer id) {
		super(id);
	}


	   
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if (pin > 999 && pin < 9999) {
		return true;
		}
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID==this.id){
			return true;
		}
		return false;
	}
	
	 public void newPatientNotes(String notes, String patientName, Date date) {
	        String report = String.format(
	            "Datetime Submitted: %s \n", date);
	        report += String.format("Reported By ID: %s\n", this.id);
	        report += String.format("Patient Name: %s\n", patientName);
	        report += String.format("Notes: %s \n", notes);
	        this.patientNotes.add(report);
	    }
	
	
}
