package com.m241hcalculator.eric.m241hcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CrossProductOfVectorsInR3 extends AppCompatActivity {

    private static TextView ai, aj, ak, bi, bj, bk;
    //private static int int_ai, int_aj, int_ak, int_bi, int_bj, int_bk;
    private static double result;
    private static TextView vectors_textview[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_product_of_vectors_in_r3);
    }

    public void onClickCal(View v) {
        ai = (TextView) findViewById(R.id.B_ai);
        aj = (TextView) findViewById(R.id.B_aj);
        ak = (TextView) findViewById(R.id.B_ak);
        bi = (TextView) findViewById(R.id.B_bi);
        bj = (TextView) findViewById(R.id.B_bj);
        bk = (TextView) findViewById(R.id.B_bk);
        //没搞明白
        vectors_textview = new TextView[]{ai, aj, ak, bi, bj, bk};

        for (int i = 0; i < vectors_textview.length; i++) {
            if (vectors_textview[i] == null || vectors_textview[i].getText().toString().length() == 0) {
                Log.d("onclick_logd", "return because of null/0");
                ((View) vectors_textview[i]).requestFocus();
                return;
            }
            for (int j = 0; j < vectors_textview[i].getText().toString().length(); j++) {
                //check if ijks are only 0-9
                if (vectors_textview[i].getText().toString().charAt(j) < 48 || vectors_textview[i].getText().toString().charAt(j) > 57) {
                    Log.d("onclick_logd", "return because of not 0-9");
                    Toast.makeText(this, "Invalid ijks", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
        //ijks are all 0-9 numbers
        Log.d("onclick_logd", "continue to calculate");

        int x[] = {Integer.parseInt(ai.getText().toString()),
                Integer.parseInt(aj.getText().toString()),
                Integer.parseInt(ak.getText().toString()),
                Integer.parseInt(bi.getText().toString()),
                Integer.parseInt(bj.getText().toString()),
                Integer.parseInt(bk.getText().toString())};

        result = (x[1] * x[5] - x[2] * x[4]) - (x[2] * x[3] - x[0] * x[5]) + (x[0] * x[4] - x[1] * x[3]);
        ((TextView) findViewById(R.id.textViewB_result)).setText(String.valueOf(result));

        ((TextView) findViewById(R.id.textViewB_result_vector)).setText("<" + (x[1] * x[5] - x[2] * x[4]) + ", "
                + (x[2] * x[3] - x[0] * x[5]) + ", "
                + (x[0] * x[4] - x[1] * x[3]) + ">");

        ((Button) findViewById(R.id.buttonBClear)).setVisibility(View.VISIBLE);
    }

    public void onClickClear(View v) {
        for (TextView x : vectors_textview) {
            x.setText("");
        }
        ((TextView) findViewById(R.id.textViewB_result)).setText("");
        ((TextView) findViewById(R.id.textViewB_result_vector)).setText("");
        ((Button) findViewById(R.id.buttonBClear)).setVisibility(View.INVISIBLE);
    }
}
