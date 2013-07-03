package com.obriand.prenomdujour;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FirstnamesListAdapter extends ArrayAdapter<Firstname> {
	
	private Context mContext;
	
	private ArrayList<Firstname> mFirstnames;
	
	private int mLayoutResourceId;

	public FirstnamesListAdapter(Context context, int layoutResourceId,
			ArrayList<Firstname> objects) {
		super(context, layoutResourceId, objects);
		// TODO Auto-generated constructor stub
	    this.mContext = context;
	    this.mLayoutResourceId = layoutResourceId;
		this.mFirstnames = objects;	    
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

	    View view = convertView;
	    FirstnameHolder holder = null;

	    if (view == null) {

	        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
	        view = inflater.inflate(mLayoutResourceId, parent, false);
	    
	        holder = new FirstnameHolder();
	        holder.txtTitle = (TextView)view.findViewById(R.id.item_title);
	        holder.txtDesc = (TextView)view.findViewById(R.id.item_desc);
	        
	        view.setTag(holder);
	        
	    } else {
	    	
	    	holder = (FirstnameHolder)view.getTag();
	    
	    }

	    Firstname firstname = mFirstnames.get(position);
	    holder.txtTitle.setText(firstname.getName());
	    holder.txtDesc.setText(String.valueOf(firstname.getOrigin().get(0)+" "+firstname.getFrequency())+" "+firstname.getGender().toString());
	   
	    return view;

	}
	
	static class FirstnameHolder
    {
        TextView txtTitle;
        TextView txtDesc;
    }

}
