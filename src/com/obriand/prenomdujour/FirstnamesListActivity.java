package com.obriand.prenomdujour;

import java.util.ArrayList;

import com.obriand.prenomdujour.Firstname.GenderType;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstnamesListActivity extends Activity {
	
	protected Cursor mCursor;
	
	private ListView mListView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_firstnameslist); 
        
        String filter = getIntent().getExtras().getString("filter");
        
        mListView = (ListView) findViewById(R.id.firstnames_list_lv);                  
        
        // set a onClick listener
        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                    long id) {                  
                AlertDialog.Builder builder = new AlertDialog.Builder(FirstnamesListActivity.this);
                builder.setTitle(((TextView)view.findViewById(R.id.item_title)).getText().toString());
                builder.setMessage(((TextView)view.findViewById(R.id.item_desc)).getText().toString());
                builder.setPositiveButton(R.string.firsname_dialog_ok_bt, new DialogInterface.OnClickListener() {
	                    @Override
	                    public void onClick(DialogInterface dialog, int id) {
	                    	dialog.cancel();
	                    }
                   	});
                
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        
        FirstnamesListAdapter firstnamesListAdapter;               
        
        if (filter.equalsIgnoreCase("all")) {        
        	firstnamesListAdapter = new FirstnamesListAdapter(this, R.layout.row_item, NameOfTheDay.getInstance().getFirstnames());
        } else {
        	GenderType gender = null;
        	String name = "";
        	if (filter.contains("name[")) name = filter.substring(filter.indexOf("[")+1, filter.indexOf("]"));
        	if (filter.contains("male")) gender = GenderType.MALE;
        	if (filter.contains("female")) gender = GenderType.FEMALE;
        	if (filter.contains("both")) gender = GenderType.BOTH;
        	float frequencyLevel = 0;
        	if (filter.contains("frequent")) frequencyLevel = (float) 5.0;
        	if (filter.contains("veryfrequent")) frequencyLevel = (float) 100.0;
        	ArrayList<String> origins = new ArrayList<String>();
        	if (filter.contains("french")) origins.add("french");
        	if (filter.contains("english")) origins.add("english");
        	if (filter.contains("spanish")) origins.add("spanish");
        	if (filter.contains("finnish")) origins.add("finnish");
        	if (filter.contains("irish")) origins.add("irish");
        	if (filter.contains("biblical")) origins.add("biblical");
        	if (filter.contains("arabic")) origins.add("arabic");
        	if (filter.contains("jewish")) origins.add("jewish");
        	if (filter.contains("hungarian")) origins.add("hungarian");
        	if (filter.contains("danish")) origins.add("danish");
        	if (filter.contains("african")) origins.add("african");
        	if (filter.contains("indian")) origins.add("indian");
        	if (filter.contains("german")) origins.add("german");
        	if (filter.contains("greek")) origins.add("greek");
        	if (filter.contains("italian")) origins.add("italian");
        	if (filter.contains("portuguese")) origins.add("portuguese");
        	if (filter.contains("russian")) origins.add("russian");
        	if (filter.contains("romanian")) origins.add("romanian");
        	if (filter.contains("dutch")) origins.add("dutch");
        	if (filter.contains("astronomy")) origins.add("astronomy");
        	if (filter.contains("history")) origins.add("history");
        	if (filter.contains("esperanto")) origins.add("esperanto");
        	if (filter.contains("anglo-saxon")) origins.add("anglo-saxon");
        	firstnamesListAdapter = new FirstnamesListAdapter(this, R.layout.row_item, NameOfTheDay.getInstance().getFirstnames(name, gender, frequencyLevel, origins));        	
        }

        mListView.setAdapter(firstnamesListAdapter);        

    } 
}
