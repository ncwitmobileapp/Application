
package com.ncwitmobileapp;
 
import java.util.Calendar;
import java.util.regex.Pattern;
 
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
 
 
 
public class RegistrationPage extends Activity {
     
    private Button mPickDate;
    private int mYear=2012;
    private int mMonth=1;
    private int mDay=1;
     
    static final int DATE_DIALOG_ID = 0;
    static final long THIRTEEN_YEARS_IN_MILLIS = 410260032000L;
     
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() 
            {
 
                public void onDateSet(DatePicker view, int year, 
                                      int monthOfYear, int dayOfMonth) 
                {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    updateDisplay();
                }
            };
     
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
         
        mPickDate = (Button) findViewById(R.id.SelectBirthday);
        mPickDate.setOnClickListener(new View.OnClickListener() {
             
            public void onClick(View arg0) {
                showDialog(DATE_DIALOG_ID);
                 
            }
        });
         
        MatchFilter myMatchFilter = new MatchFilter() {
            public boolean acceptMatch(CharSequence cs, int start, int end) {
                return start > 26;
            }
        };
 
        TextView tOS = (TextView)findViewById(R.id.Terms);
        Pattern pattern2 = Pattern.compile("[a-zA-Z]+");
        Linkify.addLinks(tOS,pattern2, "", myMatchFilter, null);
 
         
    }//End onCreate
     
    private void updateDisplay() {
        mPickDate.setText(
            new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mMonth + 1).append("-")
                    .append(mDay).append("-")
                    .append(mYear).append(" "));
    }//End updateDisplay
     
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DATE_DIALOG_ID:
            DatePickerDialog d = new DatePickerDialog(this,
                    mDateSetListener,
                    mYear, mMonth, mDay);
            return d;
        }
        return null;
    }//End onCreateDialog    
     
}//End RegistrationPage.java