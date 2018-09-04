package com.m241hcalculator.eric.m241hcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickA (View v) {
        Intent intent = new Intent(this,mode_for_vector_in_R3.class);
        startActivity(intent);
    }

    public void onClickB (View v) {
        Intent intent = new Intent(this, CrossProductOfVectorsInR3.class);
        startActivity(intent);
    }
}
