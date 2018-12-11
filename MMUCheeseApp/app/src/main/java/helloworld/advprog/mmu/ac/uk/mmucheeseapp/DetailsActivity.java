package helloworld.advprog.mmu.ac.uk.mmucheeseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // get the intent
        Bundle extras = getIntent().getExtras();
        TextView cheeseTitle = (TextView) findViewById(R.id.cheeseTitle);
        TextView cheeseDesc = (TextView) findViewById(R.id.cheeseDesc);
        // create a cheese object from the cheese object that was passed over from
        // the MainActivity. Notice you use the key ('cheese') to retrieve the value/variable needed.
        Cheese theCheese = (Cheese) extras.get("cheese");
        System.out.println("received from the intent: "+theCheese.getName());
        cheeseTitle.setText(theCheese.getName());
        cheeseDesc.setText(theCheese.getDetails());

    }
}
