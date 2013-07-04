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
	
	private Button mAllFirstnamesBt;
	private Button mMaleFirstnamesBt;
	private Button mMaleFrequentFirstnamesBt;
	private Button mMaleFrequentFrenchFirstnamesBt;
	private Button mMaleVeryFrequentFrenchFirstnamesBt;

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
		
		mAllFirstnamesBt = (Button) this.findViewById(R.id.main_all_firstnames_list_bt);		
		mAllFirstnamesBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, FirstnamesList.class);
				intent.putExtra("filter", "all");
				startActivity(intent);
			}			
		});
		
		mMaleFirstnamesBt = (Button) this.findViewById(R.id.main_male_firstnames_list_bt);		
		mMaleFirstnamesBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, FirstnamesList.class);
				intent.putExtra("filter", "male");
				startActivity(intent);
			}			
		});
		
		mMaleFrequentFirstnamesBt = (Button) this.findViewById(R.id.main_male_frequent_firstnames_list_bt);		
		mMaleFrequentFirstnamesBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, FirstnamesList.class);
				intent.putExtra("filter", "male|frequent");
				startActivity(intent);
			}			
		});	
		
		mMaleFrequentFrenchFirstnamesBt = (Button) this.findViewById(R.id.main_male_frequent_french_firstnames_list_bt);		
		mMaleFrequentFrenchFirstnamesBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, FirstnamesList.class);
				intent.putExtra("filter", "male|frequent|french");
				startActivity(intent);
			}			
		});	
		
		mMaleVeryFrequentFrenchFirstnamesBt = (Button) this.findViewById(R.id.main_male_veryfrequent_french_firstnames_list_bt);		
		mMaleVeryFrequentFrenchFirstnamesBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, FirstnamesList.class);
				intent.putExtra("filter", "male|veryfrequent|french");
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
