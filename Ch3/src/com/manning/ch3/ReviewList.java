package com.manning.ch3;

import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class ReviewList extends ListActivity{
	private static final int MENU_CHANGE_CRITERIA = Menu.FIRST+1;
	private static final int MENU_CHANGE_NEXT_PAGE = Menu.FIRST;
	private static final int NUM_RESULTS_PER_PAGE = 8;
	private TextView empty;
	private ProgressDialog progressDialog;
	private ReviewAdapter reviewAdapter;
	private List<Review> reviews;
	private final Handler handler = new Handler() {
		public void handleMessage(final Message msg) {
			progressDialog.dismiss();
			if((reviews==null) || (reviews.size()==0)){
				empty.setText("No Data");
			}else {
				reviewAdapter = new ReviewAdapter(ReviewList.this, reviews);
				setListAdapter(reviewAdapter);
			}
		}
	};
	@Override
	public void OnCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.review_list);
		this.empty = (TextView) findViewById(R.id.empty);
		ListView listView = getListView();
		listView.setItemsCanFocus(false);
		listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listView.setEmptyView(this.empty);
	}
	
	@Override
	public void onResume(){
		super.onResume();
		
		
	}
	
}
