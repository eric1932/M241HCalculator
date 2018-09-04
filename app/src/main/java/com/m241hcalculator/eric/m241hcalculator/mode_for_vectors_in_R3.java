package com.m241hcalculator.eric.m241hcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class mode_for_vectors_in_R3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_for_vectors_in__r3);
    }

    public void calculate_reveal() {
        EditText ai = findViewById(R.id.vector_a_i);
        EditText aj = findViewById(R.id.vector_a_j);
        EditText ak = findViewById(R.id.vector_a_k);
        int int_ai = Integer.parseInt(ai.getText().toString());
        int int_aj = Integer.parseInt(aj.getText().toString());
        int int_ak = Integer.parseInt(ak.getText().toString());

        double result = Math.pow(
                Math.pow(int_ai, 2)
                + Math.pow(int_aj, 2)
                + Math.pow(int_ak, 2)
                , 0.5);

        TextView text_result = findViewById(R.id.result);
        text_result.setText(String.valueOf(String.valueOf(result)));
    }

    public void review(View v) {
        EditText ai = findViewById(R.id.vector_a_i);
        EditText aj = findViewById(R.id.vector_a_j);
        EditText ak = findViewById(R.id.vector_a_k);
        EditText vectors[] = {ai, aj, ak};

        for (EditText i : vectors) {
            if (i == null || i.getText().toString().length() == 0) {
                Log.d("review_logd", "return because of null/0");
                return;
            }
            for (int j = 0; j < i.getText().toString().length(); j++) {
                if (i.getText().toString().charAt(j) < 48 || i.getText().toString().charAt(j) > 57) {
                    //not only 0-9
                    Log.d("review_logd", "return because of not 0-9");
                    Toast.makeText(this, "Invalid ijks", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
        //ijks are all 0-9 numbers
        Log.d("review_logd", "continue to calculate");
        calculate_reveal();

        //禁止修改
        findViewById(R.id.buttonACal).setEnabled(false);
        for (EditText x : vectors) {
            x.setEnabled(false);
        }
    }

    public void onClickClear(View v) {
        EditText ai = findViewById(R.id.vector_a_i);
        EditText aj = findViewById(R.id.vector_a_j);
        EditText ak = findViewById(R.id.vector_a_k);
        ai = findViewById(R.id.vector_a_i);
        aj = findViewById(R.id.vector_a_j);
        ak = findViewById(R.id.vector_a_k);
        EditText vectors[] = {ai, aj, ak};

        for (EditText x : vectors) {
            x.setText("");
        }
        ((TextView) findViewById(R.id.result)).setText(getString(R.string.blank));
        if (!findViewById(R.id.buttonACal).isEnabled()) {
            findViewById(R.id.buttonACal).setEnabled(true);
        }
        for (EditText x : vectors) {
            x.setEnabled(true);
        }
    }
}
