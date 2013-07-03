package com.obriand.prenomdujour;

import java.util.ArrayList;

public class Firstname {
	
	private String mName;
	
	private float mFrequency;
	
	private boolean mGender;
	
	private ArrayList<String> mOrigin;
	
	public Firstname(String name, float frequency, boolean gender, ArrayList<String> origin) {
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

	public boolean getGender() {
		return mGender;
	}

	public void setGender(boolean mGender) {
		this.mGender = mGender;
	}

	public ArrayList<String> getOrigin() {
		return mOrigin;
	}

	public void setOrigin(ArrayList<String> mOrigin) {
		this.mOrigin = mOrigin;
	}
	
	

}
