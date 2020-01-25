package com.example.android1hometask5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int parameter1;
    int parameter2;
    String operation;

    private Result_Send actionSender;

    public static final String KEY = "KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_zero:
                textView.append("0");
                break;
            case R.id.button_one:
                textView.append("1");
                break;
            case R.id.button_two:
                textView.append("2");
                break;
            case R.id.button_three:
                textView.append("3");
                break;
            case R.id.button_four:
                textView.append("4");
                break;
            case R.id.button_five:
                textView.append("5");
                break;
            case R.id.button_six:
                textView.append("6");
                break;
            case R.id.button_seven:
                textView.append("7");
                break;
            case R.id.button_eight:
                textView.append("8");
                break;
            case R.id.button_nine:
                textView.append("9");
                break;

        }
    }

    public void onClickOperation(View view) {
        switch (view.getId()) {
            case R.id.button_minus:
                operation = "-";
                parameter1 = Integer.valueOf(textView.getText().toString());
                textView.setText(parameter1 + "-");
                break;
            case R.id.button_plus:
                operation = "+";
                parameter1 = Integer.valueOf(textView.getText().toString());
                textView.setText(parameter1 + "+");
                break;
            case R.id.button_divide:
                operation = "/";
                parameter1 = Integer.valueOf(textView.getText().toString());
                textView.setText(parameter1 + "/");
                break;
            case R.id.button_multiply:
                operation = "*";
                parameter1 = Integer.valueOf(textView.getText().toString());
                textView.setText(parameter1 + "*");
                break;
            case R.id.button_equal:
                String first = textView.getText().toString().replace(parameter1 + operation + "", "");
                parameter2 = Integer.valueOf(first);

                switch (operation) {
                    case "+":
                        textView.setText(parameter1 + " + " + parameter2 + " = " + (parameter1 + parameter2));
                        break;
                    case "-":

                        textView.setText(parameter1 + " - " + parameter2 + " = " + (parameter1 - parameter2));
                        break;
                    case "*":

                        textView.setText(parameter1 + "*" + parameter2 + " = " + (parameter1 * parameter2));
                        break;
                    case "/":

                        textView.setText(parameter1 + "/" + parameter2 + " = " + (parameter1 / parameter2));

                        break;
                }


                break;
//
//            case R.id.button_clear:
//                textView.setText("");
//                break;
        }

    }


    public void change_btn_fragment(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, new ButtonFragment());
        transaction.commit();
    }

    public void change_btn_history_fragment(View view) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, new HistoryFragment());
        transaction.commit();
    }

        public void sendHistory(View view) {
        String answer = textView.getText().toString();
        actionSender.send(answer);
    }

    public void sendValue(Result_Send actionSend){
        this.actionSender = actionSend;
    }

}
