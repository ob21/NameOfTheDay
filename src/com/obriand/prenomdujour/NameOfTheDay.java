package com.obriand.prenomdujour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import com.obriand.prenomdujour.Firstname.GenderType;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

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
			br = new BufferedReader(new InputStreamReader(mContext.getAssets().open("prenoms.txt"), "windows-1252"));
			String line = br.readLine();
			line = br.readLine();
	        while (line!=null) {	        	  
	        	String[] separated = line.split("	");
	        	String name = separated[0];
	        	Float frequency = Float.valueOf(separated[3]);
	        	GenderType gender = GenderType.MALE;
	        	if (separated[1].equals("m")) gender = GenderType.MALE;
	        	if (separated[1].equals("f")) gender = GenderType.FEMALE;
	        	if (separated[1].equals("m,f")||separated[1].equals("f,m")) gender = GenderType.BOTH;
	        	ArrayList<String> origin = new ArrayList<String>();
	        	String[] origins = separated[2].split(",");
	        	for(int i=0; i<origins.length; i++) { 
	        		origin.add(origins[i].trim());
	        	}
	        	mFirstnames.add(new Firstname(name, frequency, gender, origin));
	        	
//	    		Uri mNewUri;
//	    		ContentValues mNewValues = new ContentValues();
//	    		mNewValues.put(Item.ITEM_NAME, separated[0]);
//	    		mNewValues.put(Item.ITEM_FREQUENCY, separated[3]);
//	    		mNewValues.put(Item.ITEM_GENDER, separated[1]);
//	    		mNewValues.put(Item.ITEM_ORIGIN, separated[2]);
//	    		mNewUri = mContext.getContentResolver().insert(ItemProvider.CONTENT_URI, mNewValues);
	        	
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
	
	public ArrayList<Firstname> getFirstnames(String name, GenderType gender, float frequencyLevel, ArrayList<String> origins) {
		if (name == null) name = "";
		if (gender == null) gender = GenderType.BOTH;		
		ArrayList<Firstname> filteredFirstnames = new ArrayList<Firstname>();
		Iterator<Firstname> iterator = mFirstnames.iterator();
		while (iterator.hasNext()) {
			Firstname firstname = iterator.next();
			Firstname selectedFirstname = null;
			if (firstname.getFrequency() > frequencyLevel) {
				if (origins != null) {
					if (firstname.getOrigin().containsAll(origins))
						selectedFirstname = firstname;
				} else
					selectedFirstname = firstname;
			}
			
			Firstname selected2Firstname = null;
			if (selectedFirstname != null) {
				if (gender == GenderType.BOTH) {
					selected2Firstname = selectedFirstname;
				} else {
					if (selectedFirstname.getGender() == gender) {
						selected2Firstname = selectedFirstname;
					}
				}
			}

			if (selected2Firstname != null) {
				if (name != "") {
					if (selected2Firstname.getName().startsWith(name))
						filteredFirstnames.add(selected2Firstname);
				} else {
					filteredFirstnames.add(selected2Firstname);
				}
			}
		}
		return filteredFirstnames;
	}

}
