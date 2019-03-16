package grdpinfotech.ganeshsatkar.saptsurmusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterViewFlipper;

public class Aboutus extends AppCompatActivity {

    int[] fruitImages = {R.drawable.flif1, R.drawable.flif4,R.drawable.inaguration, R.drawable.filf9, R.drawable.keyperson,R.drawable.flif2,R.drawable.flif10,R.drawable.flif6, R.drawable.flif7,R.drawable.flif8};     // array of images
    String fruitNames[] = {"0ooooooooo", "o0oooooooo", "oo0ooooooo", "ooo0oooooo", "oooo0ooooo","ooooo0oooo", "oooooo0ooo", "ooooooo0oo","oooooooo0o","ooooooooo0"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        AdapterViewFlipper simpleAdapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.simpleAdapterViewFlipper);
        // Custom Adapter for setting the data in Views
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), fruitNames, fruitImages);
        simpleAdapterViewFlipper.setAdapter(customAdapter); // set adapter for AdapterViewFlipper
        // set interval time for flipping between views
        simpleAdapterViewFlipper.setFlipInterval(3000);
        // set auto start for flipping between views
        simpleAdapterViewFlipper.setAutoStart(true);





    }
}
