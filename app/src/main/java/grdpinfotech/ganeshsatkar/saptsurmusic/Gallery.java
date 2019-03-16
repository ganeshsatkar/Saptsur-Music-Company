package grdpinfotech.ganeshsatkar.saptsurmusic;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Gallery extends AppCompatActivity {
    private Integer[] images = {R.drawable.flif6,
            R.drawable.flif4, R.drawable.flif5, R.drawable.flif3,

            R.drawable.g1, R.drawable.g2, R.drawable.g3, R.drawable.g4,

            R.drawable.flif1, R.drawable.flif8,R.drawable.flif2, R.drawable.flif7, R.drawable.flif8

    };

    private ImageView imageview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Button b = (Button) findViewById(R.id.formorephoto);

        assert b != null;
        b.setOnClickListener(new View.OnClickListener() {

                                 public void onClick(View v) {

                                     Intent intent = new Intent(Gallery.this, Moreimage.class);

                                     startActivity(intent);
                                 }

                             }
        );





        @SuppressLint("WrongViewCast") android.widget.Gallery imgGallery = (android.widget.Gallery) findViewById(R.id.gallery);

        imgGallery.setAdapter(new ImageAdapter(this));
        imageview = (ImageView) findViewById(R.id.imageView);
        imgGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(), "Image " + arg2, Toast.LENGTH_SHORT).show();
                imageview.setImageResource(images[arg2]);
            }
        });
    }


    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context context) {

            this.context = context;
        }

        @Override
        public int getCount() {

            return images.length;
        }

        @Override
        public Object getItem(int arg0) {

            return arg0;
        }

        @Override
        public long getItemId(int arg0) {

            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

            ImageView imageView = new ImageView(context);
            imageView.setImageResource(images[arg0]);
            return imageView;
        }
    }


}
