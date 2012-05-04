package com.ncwitmobileapp;
import com.ncwitmobileapp.R;
import com.ncwitmobileapp.client.MyRequestFactory;
import com.ncwitmobileapp.client.MyRequestFactory.HelloWorldRequest;
import com.ncwitmobileapp.client.MyRequestFactory.NCWITMOBILEAPPRequest;


import com.google.gwt.core.client.GWT;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;


public class Login_Screen extends Activity
{
    private static final String TAG = "Techchicks";

    /**
     * The current context.
     */
    private Context mContext = this;
    
    @Override
	public void onCreate(Bundle savedInstanceState)
	{
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        super.onCreate(savedInstanceState);		 
        setContentView(R.layout.logins);
			
        final Button login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View lb) {
                //communicate with App Engine
                //goes to the Menu Page
				
                //gets username and password from user(Editables)
				
                EditText un=(EditText)findViewById(R.id.username);
                EditText ps=(EditText)findViewById(R.id.password);
				
                final String username = un.getText().toString();
                final String password = ps.getText().toString();
				
                login.setEnabled(false);
                Log.i(TAG, "preparing request to send to server");

                // Use an AsyncTask to avoid blocking the UI thread
                new AsyncTask<Void, Void, String>() {
                    private String message;

                    @Override
                    protected String doInBackground(Void... arg0) {
                        MyRequestFactory requestFactory = Util.getRequestFactory(mContext,
                                MyRequestFactory.class);
                        final NCWITMOBILEAPPRequest request = requestFactory.nCWITMOBILEAPPRequest();
                        Log.i(TAG, "Sending request to server");
                        request.getAuthenticatedTechicksmember(username, password).fire(new Receiver<String>() {
                            @Override
                            public void onFailure(ServerFailure error) {
                                message = "Failure: " + error.getMessage();
                            }

                            @Override
                            public void onSuccess(String result) {
                                message = result;
                                Log.i(TAG,"got back a hello world message");
                            }
                        });
                        return message;
                    }

                }.execute();
			
            }
        });
	    
        Button register = (Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View lb) {
                //goes to the Registration Page
            }
        });
	
        Button forgotpassword = (Button)findViewById(R.id.forgotpassword);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View lb) {
                //goes to the Forgot Password Page
            }
        });
    }
}

