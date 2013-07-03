package com.obriand.prenomdujour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class NameOfTheDay {
	
	private static NameOfTheDay mInstance;
	
	private static Context mContext;
	
	private ArrayList<Firstname> mFirstnames;
	
	public NameOfTheDay(Context context) {
		this.mContext = context;
		this.mFirstnames = new ArrayList<Firstname>();
		init();
	}
	
	public static NameOfTheDay getInstance() {
		if (mInstance!=null) return mInstance;
		else mInstance = new NameOfTheDay(mContext);
		return mInstance;
	}
	
	public void init() {
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(mContext.getAssets().open("prenoms.txt")));
			String line = br.readLine();
			line = br.readLine();
	        int i =0;
	        while (line!=null) {	        	  
	        	String[] separated = line.split("	");
	        	String name = separated[0];
	        	Float frequency = Float.valueOf(separated[3]);
	        	boolean gender = false;
	        	if (separated[1].equals("m")) gender = true;
	        	ArrayList<String> origin = new ArrayList<String>();
	        	origin.add(separated[2]);	        	
	        	mFirstnames.add(new Firstname(name, frequency, gender, origin));
	        	line = br.readLine();
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Firstname> getFirstnames() {
		return mFirstnames;
	}

}