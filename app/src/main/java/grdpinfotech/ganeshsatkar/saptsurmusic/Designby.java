package grdpinfotech.ganeshsatkar.saptsurmusic;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Designby extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designby);

    }


    public void grdpweb(View v) {
        //Inform the user the button has been clicked
        Uri uri = Uri.parse("http://www.grdpinfotech.wordpress.com");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.android.chrome");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.grdpinfotech.wordpress.com")));
        }
    }
}


