package com.ncwitmobileapp;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.ServerFailure;
import com.ncwitmobileapp.client.MyRequestFactory;
import com.ncwitmobileapp.client.MyRequestFactory.NCWITMOBILEAPPRequest;
import com.ncwitmobileapp.shared.TechicksmemberProxy;
import com.ncwitmobileapp.shared.AwardProxy;
import com.ncwitmobileapp.common.Level;

import android.app.Activity;
import android.content.Context;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;


import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;



import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;

import android.view.View.OnClickListener;

import android.view.KeyEvent;
import android.view.View.OnKeyListener;
import android.widget.EditText;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.util.Log;



/**
 * 
 * @author Michelle Chang
 * @version 8/13/2012
 * 
 */

public class EditProfile extends Activity {
	String[] states;
	protected static final String DEBUG_TAG = "debugProfile";
	//private Button addYearNational, addYearRegional, generate, share, save,
	//cancel;
	 private Context mContext = this;
	 
	//private static final String LOG_TAG = "Profile";
	
	//spinner
	//private Spinner spinner1;
	
	//textbox
	private EditText edYearNational;
	private EditText edYearRegional;
	
	//radio buttons
	private RadioGroup radioGroup;
	//private RadioButton radioRWButton;
	  
	@Override
	public void onCreate(Bundle savedInstanceState) {
		final TechicksmemberProxy techicksmember;
		//Boolean awardWinner;
		//Boolean awardRunnerup'
		//String yearAwardNational;
		//String yearAwardRegional;
		//String state;
		//Boolean generateSelect;
		//Boolean shareReference;
		//Boolean cancelReference;
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_profile);  //starting layout

		edYearNational = (EditText) findViewById(R.id.editTextYearNational);
		edYearRegional = (EditText) findViewById(R.id.editTextYearRegional);
		
		radioGroup = (RadioGroup) findViewById(R.id.rdgroup1);
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
//
// 			    AwardProxy award = new AwardProxy();
//
				int id = radioGroup.getCheckedRadioButtonId();
				if (id == -1) {
					//no item selected
				} else {
					if (id == R.id.rdbWinner) {
						DisplayToast("Winner is selected");
//
//                       award.setLevel(Level.NATIONAL_WINNER);	
//
					} else {
						DisplayToast("RunnerUp is selected");
//
// 				        award.setLevel(Level.NATIONAL_RUNNERUP);
//
					}
				}
			}
		});
		
		
		Button btnGen = (Button) findViewById(R.id.buttonGenerate);
		btnGen.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				DisplayToast("button Generate is clicked");
			}
		}); 
	
		Button btnShare = (Button) findViewById(R.id.buttonrefshare);
		btnShare.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {			
				DisplayToast("button ref Share is clicked");
			}
		});
		
		Button btnrefCancel = (Button) findViewById(R.id.buttonrefcancel);
		btnrefCancel.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				DisplayToast("button ref Cancel is clicked");
			}
		}); 
		
		Spinner stateSpinner = (Spinner) findViewById(R.id.stateSpinner);
		stateSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
			        int index = arg0.getSelectedItemPosition();
				     Toast.makeText(getBaseContext(), arg0.getItemAtPosition(arg2).toString(),
				     Toast.LENGTH_SHORT).show();
/** 
 *     				 techicksmember.state = arg0.getItemAtPosition(arg2).toString();
 */
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// Nothing
			}
		});
		
		
		Button btnSave = (Button) findViewById(R.id.buttonsave);
		btnSave.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String textN= edYearNational.getText().toString();
				String textR= edYearRegional.getText().toString();
				Log.d(DEBUG_TAG, "year of national is " + textN);
				Log.d(DEBUG_TAG, "year of regional is " + textR);
			
				DisplayToast("year of national is " + textN + " year of regional is " + textR + " button Save is clicked ");
				
				// Use an AsyncTask to avoid blocking the UI thread
				new AsyncTask<Void, Void, String>() {
					private String message;

					@Override
					protected String doInBackground(Void... arg0) {
// 
// 						MyRequestFactory requestFactory = Util
//							.getRequestFactory(mContext,
//										MyRequestFactory.class);
//
						
// 						final TechicksmemberRequest request = requestFactory
//								.nCWITMOBILEAPPRequest();
// 
						Log.i(DEBUG_TAG, "Sending request to server");
						
// 						request.updateTechicksmember(techicksmember).fire(new Receiver<String>() {
// 							@Override
//      					public void onFailure(ServerFailure error) {
//								message = "Failure: " + error.getMessage();
//							}
//
//  						@Override
//   						public void onSuccess(String result) {
//								message = result;
//								Log.i(TAG, "got back a hello world message");
//							}
//						});
						return message;
					}

				}.execute();
				
			}
		});
		
//		Button btnCancel = (Button) findViewById(R.id.buttoncancel);
//		btnCancel.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				DisplayToast("button Cancel is clicked");
//			}
//		}; 
	};
	
	private void DisplayToast(String msg) 
	{
		Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
				
	}
	
	
}
