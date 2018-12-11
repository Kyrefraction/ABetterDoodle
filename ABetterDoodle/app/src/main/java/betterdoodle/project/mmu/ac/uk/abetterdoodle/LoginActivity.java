package betterdoodle.project.mmu.ac.uk.abetterdoodle;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity0 extends AppCompatActivity implements View.OnClickListener{


    private EditText textEmail;
    private EditText textPassword;
    private TextView textRegister;
    private Button buttonSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);
        textEmail = (EditText)findViewById(R.id.editTextEmail);
        textPassword = (EditText)findViewById(R.id.editTextPassword);
        textRegister = (TextView)findViewById(R.id.textViewRegister);
        buttonSignIn = (Button)findViewById(R.id.buttonSignIn);

        buttonSignIn.setOnClickListener(this);
        textRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSignIn) {
            //open dash
        }
        if (view == textRegister) {
            Intent myIntent = new Intent(MainActivity0.this, MainActivity1.class);
            myIntent.putExtra("email", textEmail.getText().toString());
            MainActivity0.this.startActivity(myIntent);
        }

    }
}
