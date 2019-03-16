package grdpinfotech.ganeshsatkar.saptsurmusic;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import static android.content.Intent.ACTION_DIAL;

public class Contact extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }



    public void mailcontact(View v) {
        //Inform the user the button has been clicked
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/html");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"saptsurmusic77@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Your Subject");
        i.putExtra(Intent.EXTRA_TEXT, "Write Your Mail Here");
        try {
            startActivity(Intent.createChooser(i, "Send feedback..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }



    public void mapcontact(View v) {
        //Inform the user the button has been clicked
        Uri uri = Uri.parse("https://goo.gl/maps/zUk89euwnrm");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.google.android.apps.maps");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://goo.gl/maps/zUk89euwnrm")));
        }

    }


    public void webcontact(View v) {
        //Inform the user the button has been clicked
        Uri uri = Uri.parse("http://www.saptsurmusic.com");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.android.chrome");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.saptsurmusic.com")));
        }
    }
    public void phonecontact(View v) {
        //Inform the user the button has been clicked
        String phone = "020 26890434";
        Intent intent = new Intent(ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }





}