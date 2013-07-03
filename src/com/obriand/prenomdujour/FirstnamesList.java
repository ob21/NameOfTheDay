package com.obriand.prenomdujour;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstnamesList extends Activity {
	
	protected Cursor mCursor;
	
	private ListView mListView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_firstnameslist); 
        
        mListView = (ListView) findViewById(R.id.firstnames_list_lv);                  
        
        // set a onClick listener
        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                    long id) {               
                String item = ((TextView)view.findViewById(R.id.item_title)).getText().toString();               
                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();               
            }
        });
        
        FirstnamesListAdapter firstnamesListAdapter = new FirstnamesListAdapter(this, R.layout.row_item, NameOfTheDay.getInstance().getFirstnames());

        mListView.setAdapter(firstnamesListAdapter);        

    } 
}
