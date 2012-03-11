package com.manning.ch3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ReviewCriteria extends Activity {
	public static final int MENU_GETS_REVIEWS = Menu.FIRST;
	private Spinner cuisine;
	private Button grabReviews;
	private EditText location;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.review_criteria);
        this.location= (EditText) findViewById(R.id.location);
        this.cuisine= (Spinner) findViewById(R.id.cuisine);
        this.grabReviews = (Button) findViewById(R.id.grabReviews);
        ArrayAdapter<String> cuisines= new ArrayAdapter<String>(this,R.layout.spinner_view, getResources().getStringArray(R.array.cuisines));
        cuisines.setDropDownViewResource(R.layout.spinner_view_dropdown);
        this.cuisine.setAdapter(cuisines);
        this.grabReviews.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		handleGetReviews();
        	}
        });
        
    }
}