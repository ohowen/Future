package com.future.calculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText et_x1, et_x2, et_y1, et_y2;
    private TextView tv_result;

    private float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    private void initView() {
        et_x1 = findViewById(R.id.et_x1);
        et_x2 = findViewById(R.id.et_x2);
        et_y1 = findViewById(R.id.et_y1);
        et_y2 = findViewById(R.id.et_y2);
        tv_result = findViewById(R.id.tv_result);
    }

    private void initListener() {
        et_x1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String temp = s.toString();
                if (!TextUtils.isEmpty(temp)) {
                    x1 = Float.valueOf(temp);
                } else {
                    x1 = 0;
                }
                calculate();
            }
        });

        et_x2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String temp = s.toString();
                if (!TextUtils.isEmpty(temp)) {
                    x2 = Float.valueOf(temp);
                } else {
                    x2 = 0;
                }
                calculate();
            }
        });

        et_y1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String temp = s.toString();
                if (!TextUtils.isEmpty(temp)) {
                    y1 = Float.valueOf(temp);
                } else {
                    y1 = 0;
                }
                calculate();
            }
        });

        et_y2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String temp = s.toString();
                if (!TextUtils.isEmpty(temp)) {
                    y2 = Float.valueOf(temp);
                } else {
                    y2 = 0;
                }
                calculate();
            }
        });
    }


    private void calculate() {
        if (x1 > 0 && x2 > 0 && y1 > 0 && y2 > 0) {
            float result = (x1 * y1 + x2 * y2) / (x2 + x1);
            Log.d("calculate", "RESULT: " + result);
            tv_result.setText(String.format(getResources().getString(R.string.result), result));
        } else {
            tv_result.setText(String.format(getResources().getString(R.string.result), 0.00f));
        }
    }
}
