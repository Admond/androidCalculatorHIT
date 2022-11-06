package com.advan.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    TextView view;
    String num1 = "";
    String num2 = "";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.textViewResult);

    }
    public void num0HasBeenClicked(View view){
        numHasBeenClicked(0);
    }
    public void num1HasBeenClicked(View view){
        numHasBeenClicked(1);
    }
    public void num2HasBeenClicked(View view){
        numHasBeenClicked(2);
    }
    public void num3HasBeenClicked(View view){
        numHasBeenClicked(3);
    }
    public void num4HasBeenClicked(View view){
        numHasBeenClicked(4);
    }
    public void num5HasBeenClicked(View view){
        numHasBeenClicked(5);
    }
    public void num6HasBeenClicked(View view){
        numHasBeenClicked(6);
    }
    public void num7HasBeenClicked(View view){
        numHasBeenClicked(7);
    }
    public void num8HasBeenClicked(View view){
        numHasBeenClicked(8);
    }
    public void num9HasBeenClicked(View view){
        numHasBeenClicked(9);
    }

    private void numHasBeenClicked(int num){

        if(operator.equals("") == true){

            if(num == 0){
                if(num1.equals("") == true)
                    return;
            }
            num1 = num1.concat(String.valueOf(num));
        }
        else{
            if(num == 0){
                if(num2.equals("") == true)
                    return;
            }
            num2 = num2.concat(String.valueOf(num));
        }


        updateTextView();
    }

    public void dotHasBeenClicked(View view){

        if(operator.equals("") == true){

            if(num1.contains(".") == false)
            num1 = num1.concat(".");
        }
        else{
            if(num2.contains(".") == false)
                num2 = num2.concat(".");
        }

        updateTextView();
    }


    public void multHasBeenClicked(View view){
        actionHasBeenClicked("X");
    }
    public void divHasBeenClicked(View view){
        actionHasBeenClicked(":");
    }
    public void plusHasBeenClicked(View view){
        actionHasBeenClicked("+");
    }
    public void minusHasBeenClicked(View view){
        actionHasBeenClicked("-");
    }

    private void actionHasBeenClicked(String action){

        if(num1.equals("") == true)
            return;

        calculate();

        operator = action;

        updateTextView();
    }

    public void equalsHasBeenClicked(View view){
        calculate();

    }

    private void calculate(){
        if(num1.equals("") == true ||
                num2.equals("") == true ||
                operator.equals("") == true){
            return;
        }

        double firstNum = Double. parseDouble(num1);
        double secondNum = Double. parseDouble(num2);

        Double end = 0.0;

        if(operator.equals("X")) {
            end = firstNum * secondNum;
        } else if(operator.equals(":")){
            end = firstNum / secondNum;
        } else if(operator.equals("+")){
            end = firstNum + secondNum;
        } else /*if(operator.equals("-"))*/{
            end = firstNum - secondNum;
        }

        DecimalFormat format = new DecimalFormat("0.#");

        //num1 = String.valueOf(format.format(end));
        num1 = String.valueOf(end);
        num2 = "";
        operator = "";

        updateTextView();

    }

    private void updateTextView(){
        String text = "";
        text = text.concat(num1);
        text= text.concat(operator);
        text = text.concat(num2);

        view.setText(text);
    }

}