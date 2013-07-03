package com.obriand.prenomdujour;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button mButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		new NameOfTheDay(getApplicationContext());
		
//		String columns[] = new String[] { Item.ITEM_ID,
//				Item.ITEM_NAME, Item.ITEM_FREQUENCY, Item.ITEM_GENDER, Item.ITEM_ORIGIN };
//		Uri mItems = ItemProvider.CONTENT_URI;
//		Cursor cur = getContentResolver().query(mItems, columns, null, null, null);
//		Toast.makeText(this, cur.getCount() + "", Toast.LENGTH_LONG).show();
		
		mButton = (Button) this.findViewById(R.id.main_firstnames_list_bt);		
		mButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, FirstnamesList.class);
				startActivity(intent);
			}			
		});		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
