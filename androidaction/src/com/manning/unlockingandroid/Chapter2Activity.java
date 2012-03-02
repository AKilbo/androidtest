package com.manning.unlockingandroid;

import android.app.Activity;
import android.os.Bundle; 
import android.widget.EditText;
import android.widget.TextView;
import com.manning.unlockingandroid.R;

public class Chapter2Activity extends Activity {
	public static final String tag = "Chapter2";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);
        	final EditText mealpricefield = (EditText) findViewById (R.id.mealprice); 
        	final TextView answerfield = (TextView) findViewById (R.id.answer);
    }
}