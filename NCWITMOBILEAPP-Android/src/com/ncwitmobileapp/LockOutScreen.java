package com.ncwitmobileapp;
import com.ncwitmobileapp.R;
import com.ncwitmobileapp.client.MyRequestFactory;
import com.ncwitmobileapp.client.MyRequestFactory.HelloWorldRequest;
import com.ncwitmobileapp.client.MyRequestFactory.NCWITMOBILEAPPRequest;


import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Looper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LockOutScreen extends Activity
{
    private static final String TAG = "Techchicks";
  
	public void onCreate(Bundle savedInstanceState)
	{
    	
    	requestWindowFeature(Window.FEATURE_NO_TITLE); 
        super.onCreate(savedInstanceState);		 
        setContentView(R.layout.lockoutpage);
        
        final TextView mTextField= (TextView)findViewById(R.id.timeLeft);
        
        new CountDownTimer(600000, 1000) {

            public void onTick(long millisUntilFinished) {
            	int minutes=(int) (millisUntilFinished/(60*1000));
            	double seconds=millisUntilFinished /(1000) - (minutes *60);
                mTextField.setText(minutes +":"+ seconds);
            }

            public void onFinish() {
                mTextField.setText("done!");
                Intent myIntent = new Intent(getBaseContext(), Login_Screen.class);
                startActivity(myIntent);
            }
         }.start();
			
	}
	
	public void onDestroy(Bundle savedInstanceState){
	
		/*make it remember the state*/
	
	}
}

