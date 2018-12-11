package helloworld.advprog.mmu.ac.uk.androidhttpserverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * Created by Kristen on 20/03/2017.
 */

public class DetailsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        // get the intent
        Bundle extras = getIntent().getExtras(); //gets intent from previous main activity class
        TextView empTitle = (TextView) findViewById(R.id.empTitle);
        TextView empDesc = (TextView) findViewById(R.id.empDesc);
        // create an employee object from the employee object that was passed over from intent
        Emp theEmployee = (Emp) extras.get("emp"); //gets emp package/intent
        System.out.println("received from the intent: " + theEmployee.getName());
        empTitle.setText(theEmployee.getName());
        //sets text from serialized package
        empDesc.setText("ID: " + theEmployee.getID() + "\n Gender: " + theEmployee.getGender() + "\n Date of Birth: " + theEmployee.getDoB() + "\n Address: " + theEmployee.getAddress() + "\n Postcode: " + theEmployee.getPostcode() + "\n National Insurance Number: " + theEmployee.getNatInscNo() + "\n Title: " + theEmployee.getTitle() + "\n Start Date: " + theEmployee.getStartDate() + "\n Salary: " + theEmployee.getSalary() + "\n Email: " + theEmployee.getEmail());
    }
}
