package helloworld.advprog.mmu.ac.uk.fruitlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FruitList extends AppCompatActivity {
    String[] fruit = {"apple", "banana", "orange", "grape", "kiwi", "mango", "blackberry", "strawberry", "pineapple", "lemon", "peach", "plum"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list);
        ListView fruitListView = (ListView)findViewById(R.id.ContactListView);
        // an array adapter to do all the hard work just tell it the (context, the layout, and the data)
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fruit);
        //set the adapter to the listview
        fruitListView.setAdapter(arrayAdapter);
    }
}
