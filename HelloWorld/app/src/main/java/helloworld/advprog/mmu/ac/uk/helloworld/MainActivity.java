package helloworld.advprog.mmu.ac.uk.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeRed(View v){
        this.getWindow().getDecorView().getRootView().setBackgroundColor(Color.RED);
    }

    public void changeBlue(View v){
        this.getWindow().getDecorView().getRootView().setBackgroundColor(Color.BLUE);
    }

}
