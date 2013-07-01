package com.obriand.prenomdujour;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FirstnamesList extends Activity {
	
	protected Cursor mCursor;
	
	private ListView mListView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_firstnameslist);

        mListView = (ListView) findViewById(R.id.firstnames_list_lv);
        
        String[] values = new String[12000];// { "Android", "iOS", "Windows Phone 7", "WebApps"};
        
        BufferedReader br;
        
        String line;
        
        try {
        	br = new BufferedReader(new InputStreamReader(getAssets().open("prenoms.txt")));
			line = br.readLine();  			
	        Toast.makeText(this, " "+line,Toast.LENGTH_SHORT).show();
	        int i =0;
	        while (line!=null) {
	        	line = br.readLine();
	        	values[i] = line;
	        	i++;
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		R.layout.row_item, R.id.item_title, values);

        mListView.setAdapter(adapter);
    } 
}
