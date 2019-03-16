package grdpinfotech.ganeshsatkar.saptsurmusic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    Button b;

    EditText e1,e2,e3,e4,e5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);





        b=(Button)findViewById(R.id.sendprayerequest);
        e1=(EditText)findViewById(R.id.editTextname);
        e2=(EditText)findViewById(R.id.editTextphone);
        e3=(EditText)findViewById(R.id.editTextemail);

        e5=(EditText)findViewById(R.id.editTextmsg);







        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/html");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"saptsurmusic77@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "About Enquiry");
                i.putExtra(Intent.EXTRA_TEXT, "Name : "+e1.getText()+"\n\nPhone : "+e2.getText()+"\n\nEmail : "+e3.getText()+"\n\nMessage : "+e5.getText());
                try {
                    startActivity(Intent.createChooser(i, "Send feedback..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
