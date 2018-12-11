package helloworld.advprog.mmu.ac.uk.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText.setOnClickListener(this);

    }
    public void onClick(View v) {
        // TODO Auto-generated method stub
        editText.setText("");
    }

    public void convert_onClick(View v)
    {
        EditText display = (EditText) findViewById(R.id.editText);
        TextView measurement = (TextView) findViewById(R.id.fahOrCent);
        float f = Float.parseFloat(display.getText().toString());
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            if (checkedRadioButtonId == -1) {
                display.setText("0");
            } else {
                if (checkedRadioButtonId == R.id.toCentigrade) {
                    display.setText(String.valueOf(convertFahrenheitToCelcius(f)));
                    measurement.setText("c");
                }
                if (checkedRadioButtonId == R.id.toFahrenheit) {
                    display.setText(String.valueOf(convertCelciusToFahrenheit(f)));
                    measurement.setText("f");
                }
            }
    }


    private float convertFahrenheitToCelcius(float fahrenheit) {
        return ((fahrenheit - 32) * 5 / 9);
    }

    private float convertCelciusToFahrenheit(float celsius) {
        return ((celsius * 9) / 5) + 32;
    }

}
