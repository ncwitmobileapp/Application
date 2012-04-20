package com.ncwitmobileapp;
import com.ncwitmobileapp.R;


import android.R.color;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;



public class Login_Screen extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
	    requestWindowFeature(Window.FEATURE_NO_TITLE); 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logins);
		
	
	
	
	Button login = (Button)findViewById(R.id.login);
	login.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View lb)
			{
				//communicate with App Engine
				//goes to the Menu Page
				
				//gets username and password from user(Editables)
				
				String username;
				String password;
				
				EditText un=(EditText)findViewById(R.id.username);
				EditText ps=(EditText)findViewById(R.id.password);
				
				username=un.getText().toString();
				password=ps.getText().toString();
				
				
				
				//sends to the App Engine
				
				
				
			}
			
		});
	Button register = (Button)findViewById(R.id.register);
	register.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View lb)
			{
				//goes to the Registration Page
			}
			
		});
	
	Button forgotpassword = (Button)findViewById(R.id.forgotpassword);
	forgotpassword.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View lb)
			{
				//goes to the Forgot Password Page
			}
			
		});
	
	
	
	
	}
	
	
}

