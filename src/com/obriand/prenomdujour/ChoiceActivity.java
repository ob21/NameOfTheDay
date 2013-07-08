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
import android.widget.RadioGroup;
import android.widget.Toast;

public class ChoiceActivity extends Activity {
	
	private Button mSearchBt;
	private EditText mNameEt;
	private CheckBox mMaleCb;
	private CheckBox mFemaleCb;
	private RadioGroup mFreqRgp;
		
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choice);
        
        mNameEt = (EditText) this.findViewById(R.id.choice_name_et);
        mMaleCb = (CheckBox) this.findViewById(R.id.choice_male_cb);
        mFemaleCb = (CheckBox) this.findViewById(R.id.choice_female_cb);
        mFreqRgp = (RadioGroup) this.findViewById(R.id.choice_frequency_rg);        
                
        mSearchBt = (Button) this.findViewById(R.id.choice_search_bt);		
        mSearchBt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ChoiceActivity.this, FirstnamesListActivity.class);
				StringBuilder filter = new StringBuilder("");
				filter.append("name["+mNameEt.getText().toString()+"]");
				if ( mMaleCb.isChecked() && !mFemaleCb.isChecked() ) filter.append("|male");
				if ( mFemaleCb.isChecked() && !mMaleCb.isChecked() ) filter.append("|female");
				if ( mFemaleCb.isChecked() && mMaleCb.isChecked() ) filter.append("|both|male|female");
				switch (mFreqRgp.getCheckedRadioButtonId()) {
					case R.id.choice_veryhigh_rbt :
						filter.append("|veryfrequent");
					case R.id.choice_high_rbt :
						filter.append("|frequent");
					case R.id.choice_low_rbt :
						filter.append("|all");
				}
				intent.putExtra("filter", filter.toString());
				startActivity(intent);
			}			
		});
        
    }

}
