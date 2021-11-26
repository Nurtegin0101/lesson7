package com.example.lesson7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 private TextView print ;
 private  boolean operationClick = false;
 private Double first ;
 private  Double is ;
 private  Double second ;

 private  String operation ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        print = findViewById(R.id.print);
    }

    public void OnNumberclick(View view) {
        switch (view.getId()){
            case R.id.one:
                setPrinter("1");
                break;
            case R.id.two:
                setPrinter("2");

                break;
            case R.id.three:
                setPrinter("3");

                break;
            case R.id.four:
                setPrinter("4");

                break;
            case R.id.five:
                setPrinter("5");

                break;
            case R.id.six:
                setPrinter("6");

                break;
            case R.id.seven:
                setPrinter("7");

                break;
            case R.id.eight:
                setPrinter("8");

                break;
            case R.id.nine:
                setPrinter("9");

                break;
            case R.id.oh:
                setPrinter("0");

                break;
            case R.id.point:
       if(!print.getText().toString().contains(".")){
           print.append(".");
       }
       break;
            case R.id.plus_and_m:
                  if(print.getText().equals("0")){
                return;
            } else if(print.getText().toString().contains("+")){
                    print.setText(print.getText().toString().replace("+","-"));

        } else if(print.getText().toString().contains("-")){
                print.setText(print.getText().toString().replace("-", "+"));
            } else if(!print.getText().toString().contains("+") || !print.getText().toString().contains("-")){
               print.setText("-" + print.getText());
                }

                break;
    } }

    public void Result(View view) {
        switch (view.getId()) {
            case R.id.division:
                saveNumber("/");
                break;
            case R.id.plus:
                saveNumber("+");
                break;
            case R.id.minus:
                saveNumber("-");
                break;
            case R.id.Ac:
                first = 0.0;
                second = 0.0;
                print.setText("0");
                break;
            case R.id.multiplication:
                saveNumber("X");
                break;
            case R.id.proth:
                first =Double.parseDouble(print.getText().toString());
                first = first /100 ;
    if(first%1 == 0){
    print.setText(String.valueOf(Math.round(first)));
}else{
    print.setText(first.toString());
}
                break;
        }
    }
    public void ResultTop(View view) {
        second = Double.parseDouble(print.getText().toString());
        if(operation == null) return;
        switch (operation){
            case "+":
                is = first + second;
                isOver();
                break;
            case "-":
                is  = first - second ;
                isOver();
                break;
            case "/":
                is = first / second ;
                isOver();
                break;
            case "X" :
                is = first * second ;
                isOver();
                break;

        }

    }

    private void setPrinter(String number){
        if(print.getText().toString().equals("0")){
            print.setText(number);
        }else{
            print.append(number);
        }
        if(operationClick){
            print.setText(number);
         operationClick = false ;
        }
}
    private  void saveNumber (String oper){
        print.setText(print.getText().toString().replace("=", ""));
        first =Double.parseDouble(print.getText().toString());
        operationClick = true ;
        operation = oper ;
    }
    private  void isOver (){
        if (is%1==0) {
            print.setText("=" +String.valueOf(Math.round(is)));

        } else {
            print.setText("="+is.toString());

        }
    }



}