package betterdoodle.project.mmu.ac.uk.abetterdoodle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity1 extends AppCompatActivity implements View.OnClickListener{


    private EditText textEmail;
    private EditText textPassword;
    private Button buttonRegister;
    private TextView textSignIn;
    private ProgressDialog registerProgress;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        firebaseAuth = FirebaseAuth.getInstance();
        registerProgress = new ProgressDialog(this);
        textEmail = (EditText)findViewById(R.id.editTextEmail);
        textPassword = (EditText)findViewById(R.id.editTextPassword);
        buttonRegister = (Button)findViewById(R.id.buttonRegister);
        textSignIn = (TextView)findViewById(R.id.textViewSignIn);
        textSignIn.setOnClickListener(this);
        buttonRegister.setOnClickListener(this);
        Intent intent = getIntent();
        String intentEmail = intent.getStringExtra("email");
        if (intentEmail != null) {
            textEmail.setText(intentEmail);
        }
        else {
            textEmail.setText("");
        }
    }

    private void registerUser() {
        String uEmail = textEmail.getText().toString().trim();
        String uPassword =  textPassword.getText().toString().trim();
        String passSpace = textPassword.getText().toString();
        if(uEmail.matches("") || !uEmail.contains("@") || uEmail.length() < 8) {
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(uPassword.matches("")) {
            Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show();
            return;
        }

        if(uPassword.length() < 8) {
            Toast.makeText(this, "Your password must contain at least 8 characters, symbols or numbers", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean upper = false;
        boolean lower = false;
        boolean numeric = false;
        boolean space = false;
        for (int i=0;i<uPassword.length();i++) {
            char k=uPassword.charAt(i);
            if (Character.isUpperCase(k)) {
                upper= true;
            }
            if (Character.isLowerCase(k)) {
                lower = true;
            }
            if (Character.isDigit(k)) {
                numeric = true;
            }
        }
        for (int i=0;i<passSpace.length();i++) {
            char k=passSpace.charAt(i);
            if (Character.isSpaceChar(k)) {
                space = true;
            }
        }
        if (upper == false || lower == false) {
            Toast.makeText(this, "Your password must contain a mixture of both upper and lower case characters", Toast.LENGTH_SHORT).show();
            return;
        }

        if (numeric == false) {
            Toast.makeText(this, "Your password must contain at least one number", Toast.LENGTH_SHORT).show();
            return;
        }
        if (space == true) {
            Toast.makeText(this, "Your password must not contain any spaces", Toast.LENGTH_SHORT).show();
            return;
        }

        registerProgress.setMessage("Registering your account...");
        registerProgress.show();
        firebaseAuth.createUserWithEmailAndPassword(uEmail, uPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity1.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity1.this, "Register unsuccessful, please try again", Toast.LENGTH_SHORT).show();
                        }
                        registerProgress.hide();
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == buttonRegister) {
            registerUser();
        }
        if (view == textSignIn) {
            Intent myIntent = new Intent(MainActivity1.this, MainActivity0.class);
            MainActivity1.this.startActivity(myIntent);
        }

    }
}
