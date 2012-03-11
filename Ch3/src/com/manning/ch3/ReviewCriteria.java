package com.manning.ch3;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ReviewCriteria extends Activity {
	public static final int MENU_GET_REVIEWS = Menu.FIRST;
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	menu.add(0,ReviewCriteria.MENU_GET_REVIEWS, 0, R.string.menu_get_reviews).setIcon(android.R.drawable.ic_menu_more);
    	return true;
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item){
    	switch(item.getItemId()){
    	case MENU_GET_REVIEWS:
    		handleGetReviews();
    		return true;
    	}
    return super.onMenuItemSelected(featureId, item);
    }
    private void handleGEtReviews(){
    	if(!validate()){
    		return;
    	}
    	ResturantFinderApplication application = (ResturantFinderApplication) getApplication();
    	application.setReviewCriteriaCuisine(this.cuisine.getSelectedItem().toString());
    	application.setReviewCriteriaLocation(this.location.getText().toString());
    	Intent intent = new Intent(Constants.INTENT_ACTION_VIEW_LIST);
    	startActivity(intent);
    }
    private boolean validate(){
    	boolean valid = true;
    	StringBuilder validationText = new StringBuilder();
    	if ((this.location.getText()== null) || this.location.getText().toString().equals("")){
    		validationText.append(getResources().getString(R.string.location_not_supplied_message));
    		valid = false;
    	}
    	if(!valid){
    		new AlertDialog.Builder(this).setTitle(getResources().getString(R.string.alert_label)).setMessage(validationText.toString()).setPositiveButton("Continue", new android.content.DialogInterface.OnClickListener() {
    			
				
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			})
    		}
    }
}