package com.obriand.prenomdujour;

import java.util.ArrayList;

public class Firstname {
	
	private String mName;
	
	private float mFrequency;	
	
	public enum GenderType {
		MALE("male", 0),
		FEMALE("female", 1),
		BOTH("both", 2);
		
	    private String stringValue;
	    private int intValue;
	    
	    GenderType(String toString, int value) {
	        stringValue = toString;
	        intValue = value;
	    }

	    @Override
	    public String toString() {
	        return stringValue;
	    }
	    
	    public int toInt() {
	        return intValue;
	    }
	}
	
	private GenderType mGender;
	
	private ArrayList<String> mOrigin;
	
	public Firstname(String name, float frequency, GenderType gender, ArrayList<String> origin) {
		super();
		this.setName(name);
		this.setFrequency(frequency);
		this.setGender(gender);
		this.setOrigin(origin);		
	}

	public String getName() {
		return mName;
	}

	public void setName(String mName) {
		this.mName = mName;
	}

	public float getFrequency() {
		return mFrequency;
	}

	public void setFrequency(float mFrequency) {
		this.mFrequency = mFrequency;
	}

	public GenderType getGender() {
		return mGender;
	}

	public void setGender(GenderType mGender) {
		this.mGender = mGender;
	}

	public ArrayList<String> getOrigin() {
		return mOrigin;
	}

	public void setOrigin(ArrayList<String> mOrigin) {
		this.mOrigin = mOrigin;
	}
	
	

}
