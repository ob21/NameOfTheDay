package com.obriand.prenomdujour;

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
                AlertDialog.Builder builder = new AlertDialog.Builder(FirstnamesList.this);
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
        
        FirstnamesListAdapter firstnamesListAdapter = new FirstnamesListAdapter(this, R.layout.row_item, NameOfTheDay.getInstance().getMaleFirstnames());

        mListView.setAdapter(firstnamesListAdapter);        

    } 
}
