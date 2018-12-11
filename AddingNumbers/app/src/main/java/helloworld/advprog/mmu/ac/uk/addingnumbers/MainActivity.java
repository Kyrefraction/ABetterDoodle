package helloworld.advprog.mmu.ac.uk.addingnumbers;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void OnButtonClick(View v) {
        Button buttonX = (Button) findViewById(R.id.button1);
        Button buttonY = (Button) findViewById(R.id.button2);
        buttonX.setText("clicked");
        buttonY.setText("clicked");
        int numberx, numbery, thesum1;
        EditText number1 = (EditText) findViewById(R.id.Hello1);
        EditText number2 = (EditText) findViewById(R.id.Hello2);
        TextView sum1 = (TextView) findViewById(R.id.sum);
        EditText test1 = (EditText) findViewById(R.id.test);
        numberx = Integer.parseInt(number1.getText().toString());
        numbery = Integer.parseInt(number2.getText().toString());
        thesum1 = numberx + numbery;
        sum1.setText(Integer.toString(thesum1));
        test1.setText("Hello World");
    }﻿
}
