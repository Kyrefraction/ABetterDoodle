package betterdoodle.project.mmu.ac.uk.abetterdoodle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private TextView commitDate;
    private Button date1;
    private Button date2;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference commitRef = mRootRef.child("commit");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get ui elements
        commitDate = (TextView)findViewById(R.id.textViewCommit);
        date1 = (Button)findViewById(R.id.buttonDate1);
        date2 = (Button)findViewById(R.id.buttonDate2);

    }

    protected void onStart() {
        super.onStart();
        commitRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                commitDate.setText(text);
            }
            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });
        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commitRef.setValue(date1.getText());
            }
        });
        date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                commitRef.setValue(date2.getText());
            }
        });
    }
}
