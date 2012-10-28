package com.ncwitmobileapp;
import com.ncwitmobileapp.R;
import com.ncwitmobileapp.client.MyRequestFactory;
import com.ncwitmobileapp.client.MyRequestFactory.HelloWorldRequest;
import com.ncwitmobileapp.client.MyRequestFactory.NCWITMOBILEAPPRequest;
import com.ncwitmobileapp.client.MyRequestFactory.TechicksmemberRequest;
import com.ncwitmobileapp.shared.TechicksmemberProxy;


import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login_Screen extends Activity
{
    private static final String TAG = "Techchicks";
    Toast m_currentToast = null;
    
    int loginAttempts=0;
    private static final int MAX_ATTEMPTS=10;
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

                EditText un=(EditText)findViewById(R.id.username);
                EditText ps=(EditText)findViewById(R.id.password);
				
                final String username = un.getText().toString();
                final String password = ps.getText().toString();
                final Context context = getApplicationContext();
                
                showToast("Hello toast!");
               
                login.setEnabled(false);
                Log.i(TAG, "preparing request to send to server");

                // Use an AsyncTask to avoid blocking the UI thread
                new AsyncTask<Void, Void, String>() {
                    private String message;

                    @Override
                    protected String doInBackground(Void... arg0) {
                    	
                        MyRequestFactory requestFactory = Util.getRequestFactory(mContext, MyRequestFactory.class);
                        final TechicksmemberRequest request = requestFactory.techicksmemberRequest();
                        Log.i(TAG, "Sending request to server");
                        request.getAuthenticatedTechicksmember(username, password).fire(new Receiver<TechicksmemberProxy>() {
                            @Override
                            public void onFailure(ServerFailure error) {
                                message = "Failure: " + error.getMessage();
                            }

                            @Override
                            public void onSuccess(TechicksmemberProxy result) {
                                
                                Log.i(TAG,"got back a hello world message");
                                Looper.prepare();
                                
                                
                                if (result==null){
                                	loginAttempts++;
                                	
                                	showToast("Invalid login information. You have "+(MAX_ATTEMPTS-loginAttempts)+" attempts remaining.");
                                	
                                	if (loginAttempts>=MAX_ATTEMPTS){
                                		Intent myIntent = new Intent(getBaseContext(), LockOutScreen.class);
                                        startActivity(myIntent);
                                	}
                                }else{
                                	loginAttempts=0;
                                	String name = result.getUserName();
                                	Log.i(TAG,"Name = "+name);
                                	showToast("User name = "+name+" was returned"); 
                                	Intent myIntent = new Intent(getBaseContext(), EditProfile.class);
                                	startActivity(myIntent);
                                
                                	/*Redirect to profile page of the particular user*/
                                }
                                message="success";
                                Looper.loop();
                            }
                        });
                        Looper.prepare();
                        showToast(message);
                        Looper.loop();
                        
                        return message; 
                    }

                }.execute();
			
            }
        });
	    
        Button register = (Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View lb) {
            	
            	Intent myIntent = new Intent(getBaseContext(), RegistrationPage.class);
            	startActivity(myIntent);
                
            }
        });
	
        Button forgotpassword = (Button)findViewById(R.id.forgotpassword);
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View lb) {
                //goes to the Forgot Password Page
            }
        });
    }
    void showToast(String text)
	{
	    if(m_currentToast != null)
	    {
	        m_currentToast.cancel();
	    }
	    m_currentToast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
	    m_currentToast.show();
	}
}

