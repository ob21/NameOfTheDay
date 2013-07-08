package com.obriand.prenomdujour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class ChoiceActivity extends Activity {
	
	private Button mSearchBt;
	private EditText mNameEt;
	private CheckBox mMaleCb;
	private CheckBox mFemaleCb;
	private RadioButton mVeryHighFreqRbt;
	private RadioButton mHighFreqRbt;
	private RadioButton mAllFreqRbt;
		
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choice);
        
        
                
        mSearchBt = (Button) this.findViewById(R.id.choice_search_bt);		
        mSearchBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ChoiceActivity.this, FirstnamesListActivity.class);
				intent.putExtra("filter", "all");
				startActivity(intent);
			}			
		});
        
    }

}
