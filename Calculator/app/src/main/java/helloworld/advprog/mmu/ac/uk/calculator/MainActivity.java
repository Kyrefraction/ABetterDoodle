package helloworld.advprog.mmu.ac.uk.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button plusBtn, minusBtn, divideBtn, timesBtn, equalsBtn;
    public EditText display;
    public String n1, n2, operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plusBtn = (Button) findViewById(R.id.plusButton);
        minusBtn = (Button) findViewById(R.id.minusButton);
        divideBtn = (Button) findViewById(R.id.divideButton);
        timesBtn = (Button) findViewById(R.id.timesButton);
        equalsBtn = (Button) findViewById(R.id.equalsButton);
        display = (EditText) findViewById(R.id.numberInput);

        plusBtn.setOnClickListener(this);
        minusBtn.setOnClickListener(this);
        divideBtn.setOnClickListener(this);
        timesBtn.setOnClickListener(this);
        equalsBtn.setOnClickListener(this);
    }

    public void equation_onClick(View v) {
        //showing how to create new onClick method by removing setOnClickListener for plusBtn
        System.out.println("complete");
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.plusButton:
                n1 = display.getText().toString();
                operation = "+";
                display.setText("");
                break;
            case R.id.minusButton:
                n1 = display.getText().toString();
                operation = "-";
                display.setText("");
                break;
            case R.id.divideButton:
                n1 = display.getText().toString();
                operation = "/";
                display.setText("");
                break;
            case R.id.timesButton:
                n1 = display.getText().toString();
                operation = "*";
                display.setText("");
                break;
            case R.id.equalsButton:
                n2 = display.getText().toString();
                if (operation == "+") {
                    int sum = Integer.parseInt(n1) + Integer.parseInt(n2);
                    String number = Integer.toString(sum);
                    display.setText(number);
                } else if (operation == "-") {
                    int sum = Integer.parseInt(n1) - Integer.parseInt(n2);
                    String number = Integer.toString(sum);
                    display.setText(number);
                } else if (operation == "/") {
                    int sum = Integer.parseInt(n1) / Integer.parseInt(n2);
                    String number = Integer.toString(sum);
                    display.setText(number);
                } else if (operation == "*") {
                    int sum = Integer.parseInt(n1) * Integer.parseInt(n2);
                    String number = Integer.toString(sum);
                    display.setText(number);
                }

        }
    }

}
