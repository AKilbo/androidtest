package com.manning.unlockingandroid;

import java.text.NumberFormat;
import java.text.ParseException;

import android.app.Activity;
import android.os.Bundle; 
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
        	final EditText mealpricefield = (EditText) findViewById(R.id.mealprice); 
        	final TextView answerfield = (TextView) findViewById(R.id.answer);
        	final TextView tipfield= (TextView) findViewById(R.id.tip);
        	final TextView taxfield = (TextView) findViewById(R.id.tax);
        	final Button button = (Button) findViewById(R.id.calculateTip);
        	button.setOnClickListener(new Button.OnClickListener() {
        		public void onClick(View v){
        			try{
        				Log.i(tag, "onClick invoked.");
        				//grab meal price from UI
        				String mealprice = mealpricefield.getText().toString();
        				String tax;
        				String tip;
        				Log.i(tag, "mealprice is [" + mealprice + "]");
        				String answer ="";
        				//check to see if mealprice includes a "$"
        				if(mealprice.indexOf("$")==-1){
        					mealprice = "$" + mealprice;
        				}
        				float fmp = 0.0F;
        				//get currency formatter
        				NumberFormat nf = java.text.NumberFormat.getCurrencyInstance();
        				//grab the input meal price
        				fmp = nf.parse(mealprice).floatValue();
        				//tipping at %15;
        				float taxmp = 0.0F;
        				float tipmp = 0.0F;
        				taxmp = (float) (0.075 *fmp);
        				tipmp = (float) (0.15 * fmp);
        				tax = "The tax for this meal is: " + nf.format(taxmp);
        				taxfield.setText(tax);
        				tip = "the tip for this meal is: " + nf.format(tipmp);
        				tipfield.setText(tip);
        				fmp= taxmp + fmp + tipmp;
        				//Log.i(tag,"total mealprice is at " + fmp);
        				//formatting time
        				answer = "Full Price with a 15% tip and 7.5% tax : " + nf.format(fmp);
        				answerfield.setText(answer);
        			} catch (ParseException pe) {
        					Log.i(tag,"paresexception caught");
        					answerfield.setText("failed to parse amount");
        					taxfield.setText("");
        					tipfield.setText("");
        			}catch (Exception e){
        				Log.e(tag, "failed to calculate tip:" + e.getMessage());
        				e.printStackTrace();
        				answerfield.setText(e.getMessage());
        				taxfield.setText("");
    					tipfield.setText("");
        			}
        				
        		}
        	});
    }
}