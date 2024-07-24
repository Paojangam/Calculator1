package com.example.calculator1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private char CURRENT_ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tv_display);

        Button btn0 = findViewById(R.id.btn_0);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);
        Button btn3 = findViewById(R.id.btn_3);
        Button btn4 = findViewById(R.id.btn_4);
        Button btn5 = findViewById(R.id.btn_5);
        Button btn6 = findViewById(R.id.btn_6);
        Button btn7 = findViewById(R.id.btn_7);
        Button btn8 = findViewById(R.id.btn_8);
        Button btn9 = findViewById(R.id.btn_9);
        Button btnAdd = findViewById(R.id.btn_add);
        Button btnSubtract = findViewById(R.id.btn_subtract);
        Button btnMultiply = findViewById(R.id.btn_multiply);
        Button btnDivide = findViewById(R.id.btn_divide);
        Button btnDot = findViewById(R.id.btn_dot);
        Button btnEquals = findViewById(R.id.btn_equals);
        Button btnClear = findViewById(R.id.btn_clear);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                tvDisplay.append(b.getText().toString());
            }
        };

        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);
        btnDot.setOnClickListener(listener);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = '+';
                tvDisplay.setText(null);
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = '-';
                tvDisplay.setText(null);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = '*';
                tvDisplay.setText(null);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = '/';
                tvDisplay.setText(null);
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                CURRENT_ACTION = '=';
                tvDisplay.setText(String.valueOf(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvDisplay.getText().length() > 0) {
                    CharSequence currentText = tvDisplay.getText();
                    tvDisplay.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    tvDisplay.setText("");
                }
            }
        });
    }

    private void compute() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(tvDisplay.getText().toString());

            switch (CURRENT_ACTION) {
                case '+':
                    valueOne = valueOne + valueTwo;
                    break;
                case '-':
                    valueOne = valueOne - valueTwo;
                    break;
                case '*':
                    valueOne = valueOne * valueTwo;
                    break;
                case '/':
                    valueOne = valueOne / valueTwo;
                    break;
                case '=':
                    break;
            }
        } else {
            try {
                valueOne = Double.parseDouble(tvDisplay.getText().toString());
            } catch (Exception e) {
            }
        }
    }
}
