package com.app.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    TextView output;
    String string1 = "";
    String string2 = "";
    String string3 = "";

    TextView input;
    Boolean isOperate = false;
    public void buttonClick(View view){
        Button mBtn = (Button) view;
        if (isOperate){
            string3 = string3 + mBtn.getText().toString();
        } else {
            string1 = string1 + mBtn.getText().toString();
        }
        show();
    }
    public void operate(View view){
        if (!isOperate && !string1.isEmpty()) {
            Button mBtn = (Button) view;
            string2 = mBtn.getText().toString();
            isOperate = true;
            show();
        } else if (((Button) view).getText().toString().equals("-")) {
            if (string1.isEmpty()) {
                string1 = "-";
            } else if (isOperate && string3.isEmpty() && !string2.equals("-") && !string2.equals("+")){
                string3 = "-";
            }
            else if (isOperate && string3.isEmpty() && string2.equals("+")){
                string2 = "-";
            }
            show();
        }

    }
    public void equal(View view){
        if (string1.isEmpty() || string2.isEmpty() || string3.isEmpty()){
            return;
        }
        Float int1, int3,result;
        int1 = Float.parseFloat(string1);
        int3 = Float.parseFloat(string3);
        switch(string2){
            case "+":
                result = int1 + int3;
                break;

            case "-":
                result = int1 - int3;
                break;

            case "x":
                result = int1 * int3;
                break;

            case "/":
                result = int1 / int3;
                break;

            case "%":
                result = int1 % int3;
                break;

                case "^":
                result = (float) Math.pow(int1, int3);
                break;
            default:
                result = 0f;
                break;
        }
        output.setText(result.toString());
        string1 ="";
        string2 ="";
        string3 ="";
        isOperate= false;

    }
    public void show(){
        input.setText(string1+string2+string3);
    }
    public void reset(View view){
        string1 ="";
        string2 ="";
        string3 ="";
        isOperate = false;
        show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output= findViewById(R.id.output);
        input = findViewById(R.id.input);
    }}



























