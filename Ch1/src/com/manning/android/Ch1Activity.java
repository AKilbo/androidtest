package com.manning.android;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ch1Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText addressfield = (EditText) findViewById(R.id.address);
        final Button button = (Button) findViewById(R.id.launchmap);
        button.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View view){
        		try {
        			String address = addressfield.getText().toString();
        			address = address.replace(' ', '+');
        			Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=" + address));
        			startActivity(geoIntent);
        		} catch (Exception e) {
        			
        		}
        	}	
        		
        });
    }
}