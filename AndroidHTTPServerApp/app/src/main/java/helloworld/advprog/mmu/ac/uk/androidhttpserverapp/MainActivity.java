package helloworld.advprog.mmu.ac.uk.androidhttpserverapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    public String[] empNames;
    //creating an arrayList of objects
    public ArrayList<Emp> allEmployees = new ArrayList<>();

    public class myTask extends AsyncTask<URL, Void, Void> {
        @Override
        protected Void doInBackground(URL... urls) { //do in background thread
            HttpURLConnection urlConnection;
            InputStream in = null;
            try {
                // the url we wish to connect to
                URL url = new URL("http://10.0.2.2:8001/json");
                // open the connection to the specified URL
                urlConnection = (HttpURLConnection) url.openConnection();
                // get the response from the server in an input stream
                in = new BufferedInputStream(urlConnection.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            // covert the input stream to a string
            String response = convertStreamToString(in);
            // print the response to android monitor/log cat
            System.out.println("Server response = " + response);
            try {
                // declare a new json array and pass it the string response from the server
                // this will convert the string into a JSON array which we can then iterate
                // over using a loop
                JSONArray jsonArray = new JSONArray(response);
                // instantiate the cheeseNames array and set the size
                // to the amount of cheese object returned by the server
                empNames = new String[jsonArray.length()];

                // use a for loop to iterate over the JSON array
                for (int i = 0; i < jsonArray.length(); i++) {
                    // the following line of code will get the details from the employees from the
                    // current JSON object and store it in the string variables
                    String id = jsonArray.getJSONObject(i).get("id").toString();
                    String name = jsonArray.getJSONObject(i).get("name").toString();
                    String gender = jsonArray.getJSONObject(i).get("gender").toString();
                    String dob = jsonArray.getJSONObject(i).get("dob").toString();
                    String address = jsonArray.getJSONObject(i).get("address").toString();
                    String postcode = jsonArray.getJSONObject(i).get("postcode").toString();
                    String natInscNo = jsonArray.getJSONObject(i).get("natInscNo").toString();
                    String title = jsonArray.getJSONObject(i).get("title").toString();
                    String startDate = jsonArray.getJSONObject(i).get("startDate").toString();
                    String salary = jsonArray.getJSONObject(i).get("salary").toString();
                    String email = jsonArray.getJSONObject(i).get("email").toString();
                    // print the name to log cat
                    System.out.println("name = " + name);
                    // add the details for this employee to the empNames array
                    empNames[i] = name;
                    Emp emp = new Emp(id, name, gender, dob, address, postcode, natInscNo, title, startDate, salary, email);
                    allEmployees.add(emp); //added the employee
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) { // after execute thread
            ListView empList = (ListView) findViewById(R.id.empList); //empList listview from MainActivity
            ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, empNames); //uses empNames in the array adapter
            //set the adapter to the listview
            empList.setAdapter(arrayAdapter);
            empList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long
                        l) {
                    Toast.makeText(MainActivity.this, "you pressed " + allEmployees.get(i).getName(), Toast.LENGTH_SHORT).show(); //states which employee name was pressed
                    // declare a new intent and give it the context and
                    // specify which activity you want to open/start
                    Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                    // add/put the selected cheese object in to the intent which will
                    // be passed over to the activity that is started
                    // note we use a KEY:VALUE structure to pass variable/objects
                    // between activities. Here the key is ‘cheese’ and the value is
                    // the cheese object from the cheese array list using the position
                    // which is specified by the ‘i’ variable
                    Emp c = allEmployees.get(i);
                    //intent.putExtra
                    intent.putExtra("emp", c);
                    // launch the activity
                    startActivity(intent);
                }
            });
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            URL url = new URL("http://10.0.2.2:8001/json"); //url for json data connection
            new myTask().execute(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String convertStreamToString(InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
