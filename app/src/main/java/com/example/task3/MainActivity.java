package com.example.task3;

import java.text.DecimalFormat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    public static final String MA = "MainActivity";
    public static carLease Carlease;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        Carlease = new carLease();
        Log.w( MA, "Inside MainActivity:onCreate\n" );
        setContentView( R.layout.activity_main);
    }
    public void modifyData (View v) {
        Intent myIntent = new Intent( this, DataActivity.class);
        this.startActivity( myIntent );
    }

    protected void onStart() {
        super.onStart();
        updateView();
        Log.w(MA, "Inside MainActivity:onStart\n" );
    }

    public void updateView () {
        TextView amountTV = ( TextView ) findViewById( R.id.amount);
        amountTV.setText(Carlease.getFormattedAmount() );
        TextView downPaymentTV = ( TextView ) findViewById( R.id.downPayment);
        downPaymentTV.setText(Carlease.getFormattedDownPayment() );
        TextView monthsTV = ( TextView ) findViewById( R.id.months);
        monthsTV.setText(Carlease.getMonths() );
        TextView rateTV = ( TextView ) findViewById( R.id.rate);
        rateTV.setText(100* Carlease.getRate() + "%");
        TextView totalTV = ( TextView ) findViewById( R.id.total);
        totalTV.setText(Carlease.formattedTotalPayment() );
    }
    protected void onRestart() {
        super.onRestart();
        Log.w(MA, "Inside MainActivity:onRestart\n" );
    }
    protected void onResume() {
        super.onResume();
        Log.w(MA, "Inside MainActivity:onResume\n" );
    }
    protected void onPause() {
        super.onPause();
        Log.w(MA, "Inside MainActivity:onPause\n" );
    }
    protected void onStop() {
        super.onStop();
        Log.w(MA, "Inside MainActivity:onDestroy\n" );
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.w(MA, "Inside MainActivity:onDestroy\n" );
    }

}

class carLease {
    public final DecimalFormat MONEY
            = new DecimalFormat("$#,##0.00");

    private float amount;
    private float downPayment;
    private int months;
    private float rate;


    public carLease() {
        setAmount(20000.0f);
        setDownPayment(1000.0f);
        setMonths(12);
        setRate(0.25f);

    }

    public void setAmount(float newAmount) {
        if (newAmount >= 0)
            amount = newAmount;
    }

    public void setDownPayment(float newDownPayment) {
        if (newDownPayment >= 0)
            downPayment = newDownPayment;
    }

    public void setMonths(int newMonths) {
        if (newMonths >= 0)
            months = newMonths;
    }

    public void setRate(float newRate) {
        if (newRate >= 0)
            amount = newRate;
    }


    public float getAmount() {
        return amount;
    }

    public String getFormattedAmount() {
        return MONEY.format(amount);

    }

    public float getDownPayment() {
        return downPayment;
    }

    public String getFormattedDownPayment() {
        return MONEY.format(amount);
    }

    public int getMonths() {
        return months;
    }

    public float getRate() {
        return rate;
    }


    public float weeklyPayment() {
        float mRate = rate / 4;
        double temp = Math.pow(1 / (1 + mRate), months * 4);
        return amount * mRate / (float) (1 - temp);
    }

    public String formattedWeeklyPayment() {
        return MONEY.format(weeklyPayment());
    }

    public float totalPayment () {
        return weeklyPayment() * months * 4;
    }

    public String formattedTotalPayment() {
        return MONEY.format(totalPayment());
    }
}


