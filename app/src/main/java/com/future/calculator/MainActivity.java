package com.future.calculator;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private EditText et_x1, et_x2, et_y1, et_y2;
    private TextView tv_result;

    private float x1, x2, y1, y2, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        initValues();
        initView();
        initListener();
    }

    private void initView() {
        et_x1 = findViewById(R.id.et_x1);
        et_x2 = findViewById(R.id.et_x2);
        et_y1 = findViewById(R.id.et_y1);
        et_y2 = findViewById(R.id.et_y2);
        tv_result = findViewById(R.id.tv_result);

        if (x1 > 0) {
            et_x1.setText(String.valueOf(x1));
        }

        if (x2 > 0) {
            et_x2.setText(String.valueOf(x2));
        }

        if (y1 > 0) {
            et_y1.setText(String.valueOf(y1));
        }

        if (y2 > 0) {
            et_y2.setText(String.valueOf(y2));
        }

        tv_result.setText(String.format(getResources().getString(R.string.result), result));
    }

    private void initValues() {
        x1 = SharePreUtil.getInstance().getValue(context, SharePreUtil.KEY_X1);
        x2 = SharePreUtil.getInstance().getValue(context, SharePreUtil.KEY_X2);
        y1 = SharePreUtil.getInstance().getValue(context, SharePreUtil.KEY_Y1);
        y2 = SharePreUtil.getInstance().getValue(context, SharePreUtil.KEY_Y2);
        result = SharePreUtil.getInstance().getValue(context, SharePreUtil.KEY_RESULT);
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
            result = (x1 * y1 + x2 * y2) / (x2 + x1);
            Log.d("calculate", "RESULT: " + result);
            tv_result.setText(String.format(getResources().getString(R.string.result), result));
        } else {
            tv_result.setText(String.format(getResources().getString(R.string.result), 0.00f));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharePreUtil.getInstance().saveValue(context, SharePreUtil.KEY_X1, x1);
        SharePreUtil.getInstance().saveValue(context, SharePreUtil.KEY_X2, x2);
        SharePreUtil.getInstance().saveValue(context, SharePreUtil.KEY_Y1, y1);
        SharePreUtil.getInstance().saveValue(context, SharePreUtil.KEY_Y2, y2);
        SharePreUtil.getInstance().saveValue(context, SharePreUtil.KEY_RESULT, result);
    }
}
