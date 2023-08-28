package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second, sum, difference, product, quotient;
    private Boolean isOperationClicked;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        String textButton = ((Button) view).getText().toString();
        if (textButton.equals("AC")) {
            textView.setText("0");
            first = 0;
        } else if (textView.getText().toString().equals("0") || isOperationClicked) {
            textView.setText(textButton);
        } else {
            textView.append(textButton);
        }
        isOperationClicked = false;
    }

    public void onOperationClick(View view) {
        String textButton = ((Button) view).getText().toString();
        switch (textButton) {
            case "+":
                first = Integer.valueOf(textView.getText().toString());
                operation = "+";
                break;
            case "-":
                first = Integer.valueOf(textView.getText().toString());
                operation = "-";
                break;
            case "X":
                first = Integer.valueOf(textView.getText().toString());
                operation = "X";
                break;
            case "/":
                first = Integer.valueOf(textView.getText().toString());
                operation = "/";
                break;
            case "=":
                second = Integer.valueOf(textView.getText().toString());
                switch (operation) {
                    case "+":
                        sum = first + second;
                        textView.setText(sum.toString());
                        break;
                    case "-":
                        difference = first - second;
                        textView.setText(difference.toString());
                        break;
                    case "X":
                        product = first * second;
                        textView.setText(product.toString());
                        break;
                    case "/":
                        if (second != 0) {
                            quotient = first / second;
                            textView.setText(quotient.toString());
                        } else {

                        }
                        break;
                }
        }
        isOperationClicked = true;
    }
}