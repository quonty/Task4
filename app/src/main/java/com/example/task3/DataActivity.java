package com.example.task3;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class DataActivity extends AppCompatActivity {
    public static final String DA = "MainActivity";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        updateView();
    }
    public void updateView() {
        carLease Carlease = MainActivity.Carlease;
        if (Carlease.getMonths() == 4 ) {
            RadioButton rb4 = ( RadioButton ) findViewById( R.id.four);
            rb4.setChecked( true );
        } else if (Carlease.getMonths() == 6) {
            RadioButton rb6 = ( RadioButton ) findViewById( R.id.six);
            rb6.setChecked( true );
        }
        EditText amountET = ( EditText ) findViewById( R.id.data_amount);
        amountET.setText( "" + Carlease.getAmount() );
        EditText rateET = ( EditText ) findViewById( R.id.data_rate);
        rateET.setText( "" + Carlease.getRate());

    }

    public void updateCarLeaseObject() {
        carLease Carlease = MainActivity.Carlease;
        RadioButton rb4 = ( RadioButton ) findViewById( R.id.four);
        RadioButton rb6 = ( RadioButton ) findViewById( R.id.six);
        int months = 12;
        if ( rb4.isChecked())
            months = 4;
        else if ( rb6.isChecked())
            months = 6;
        Carlease.setMonths( months);
        EditText amountET = ( EditText ) findViewById( R.id.data_amount);
        String amountString = amountET.getText().toString();
        EditText rateET = (EditText ) findViewById( R.id.data_rate );
        String rateString = rateET.getText().toString();
        try{
            float amount = Float.parseFloat( amountString);
            Carlease.setAmount( amount);
            float rate = Float.parseFloat( rateString);
            Carlease.setRate( rate);
        } catch ( NumberFormatException nfe ) {
            Carlease.setAmount( 20000.0f);
            Carlease.setRate( .035f);
        }

    }

    public void goBack(View v) {
        updateCarLeaseObject();
        this.finish();
    }

    protected void onStart() {
        super.onStart();
        Log.w(DA, "Inside DataActivity:onStart\n");
    }

    protected void onRestart() {
        super.onRestart();
        Log.w(DA, "Inside DataActivity:onRestart\n");
    }
    protected void onResume() {
        super.onResume();
        Log.w(DA, "Inside DataActivity:onResume\n" );

}
    protected void onPause() {
        super.onPause();
        Log.w(DA, "Inside DataActivity:onPause\n" );
    }
    protected void onStop() {
        super.onStop();
        Log.w(DA, "Inside DataActivity:onStop\n" );
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.w(DA, "Inside DataActivity:onDestroy\n" );
    }


}