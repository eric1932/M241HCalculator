package com.m241hcalculator.eric.m241hcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CrossProductOfVectorsInR3 extends AppCompatActivity {

    private static TextView ai, aj, ak, bi, bj, bk;
    private static TextView vectors_textview[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_product_of_vectors_in_r3);
    }

    public void onClickCal(View v) {
        ai = findViewById(R.id.B_ai);
        aj = findViewById(R.id.B_aj);
        ak = findViewById(R.id.B_ak);
        bi = findViewById(R.id.B_bi);
        bj = findViewById(R.id.B_bj);
        bk = findViewById(R.id.B_bk);
        //没搞明白
        vectors_textview = new TextView[]{ai, aj, ak, bi, bj, bk};

        for (TextView i : vectors_textview) {
            if (i == null || i.getText().toString().length() == 0) {
                Log.d("onclick_logd", "return because of null/0");
                i.requestFocus();
                return;
            }
            for (int j = 0; j < i.getText().toString().length(); j++) {
                //check if ijks are only 0-9
                if (i.getText().toString().charAt(j) < 48 || i.getText().toString().charAt(j) > 57) {
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

        double result = (x[1] * x[5] - x[2] * x[4]) - (x[2] * x[3] - x[0] * x[5]) + (x[0] * x[4] - x[1] * x[3]);
        ((TextView) findViewById(R.id.textViewB_result)).setText(String.valueOf(result));

        ((TextView) findViewById(R.id.textViewB_result_vector)).setText("<" + (x[1] * x[5] - x[2] * x[4]) + ", "
                + (x[2] * x[3] - x[0] * x[5]) + ", "
                + (x[0] * x[4] - x[1] * x[3]) + ">");

        //禁止修改
        findViewById(R.id.buttonBCal).setEnabled(false);
        for (TextView y : vectors_textview) {
            y.setEnabled(false);
        }
    }

    public void onClickClear(View v) {
        for (TextView x : vectors_textview) {
            x.setText("");
        }
        ((TextView) findViewById(R.id.textViewB_result)).setText("");
        ((TextView) findViewById(R.id.textViewB_result_vector)).setText("");
        //if Cal is disabled
        if (!findViewById(R.id.buttonBCal).isEnabled()) {
            findViewById(R.id.buttonBCal).setEnabled(true);
        }
        for (TextView y : vectors_textview) {
            y.setEnabled(true);
        }
    }
}
