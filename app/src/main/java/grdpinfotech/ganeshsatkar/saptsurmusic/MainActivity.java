
package grdpinfotech.ganeshsatkar.saptsurmusic;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.Intent.ACTION_DIAL;
import static android.content.Intent.ACTION_SEND;
import static android.content.Intent.EXTRA_EMAIL;
import static android.content.Intent.EXTRA_SUBJECT;
import static android.content.Intent.EXTRA_TEXT;
import static android.content.Intent.createChooser;

       public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private boolean exit = false;
    private WebView webView;
    TextView tt;
           AdView adView;
           private InterstitialAd interstitialAd;

           private long backPressedTime;
// bottomnavigation




           private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                   = new BottomNavigationView.OnNavigationItemSelectedListener() {

               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   switch (item.getItemId()) {

                       case R.id.navigation_request:

                           Intent i = new Intent(MainActivity.this, Menu.class);
                           startActivity(i);
                           return true;


                       case R.id.navigation_donation:

                           Intent j = new Intent(MainActivity.this, Contact.class);
                           startActivity(j);
                           return true;


                       case R.id.navigation_fullscreen:
                           Intent launchYouTube1 = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");

                           startActivity(new Intent(launchYouTube1.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCLgpemlKyvfbPVxh_hJKzWw")));
                           // https://www.youtube.com/channel/UCc2PCIrC5HOjBNDnKnJa3VQ

                           return true;
                   }
                   return false;
               }
           };






// end bottom navigation












           @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




              // mTextMessage = (TextView) findViewById(R.id.message);
               BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
               navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);










               Button b = (Button) findViewById(R.id.aboutus);
              // Button b1 = (Button) findViewById(R.id.artist);
               Button b2 = (Button) findViewById(R.id.upcoming);
               Button b3 = (Button) findViewById(R.id.gallery);
               Button b4 = (Button) findViewById(R.id.contact);
               Button b5 = (Button) findViewById(R.id.Keyperson);
               Button b6 = (Button) findViewById(R.id.video);
               Button b7 = (Button) findViewById(R.id.music);

               assert b != null;
               b.setOnClickListener(new View.OnClickListener() {

                                        public void onClick(View v) {

                                            Intent intent = new Intent(MainActivity.this, Aboutus.class);

                                            startActivity(intent);
                                        }

                                    }
               );
/*
               assert b1 != null;
               b1.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {

                                             Intent intent = new Intent(MainActivity.this, Artist.class);

                                             startActivity(intent);
                                         }

                                     }
               );*/


               assert b2 != null;
               b2.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {

                                             Intent intent = new Intent(MainActivity.this, Upcoming.class);

                                             startActivity(intent);
                                         }

                                     }
               );

               assert b6   != null;
               b6.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {

                                             Intent intent = new Intent(MainActivity.this, Video.class);

                                             startActivity(intent);
                                         }

                                     }
               );

               assert b3 != null;
               b3.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {

                                             Intent intent = new Intent(MainActivity.this, grdpinfotech.ganeshsatkar.saptsurmusic.Gallery.class);

                                             startActivity(intent);
                                         }

                                     }
               );

               assert b4 != null;
               b4.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {

                                             Intent intent = new Intent(MainActivity.this, Contact.class);

                                             startActivity(intent);
                                         }

                                     }
               );

               assert b5 != null;
               b5.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {

                                             Intent intent = new Intent(MainActivity.this, Keyperson.class);

                                             startActivity(intent);
                                         }

                                     }
               );

               assert b7 != null;
               b7.setOnClickListener(new View.OnClickListener() {

                                         public void onClick(View v) {

                                             Intent intent = new Intent(MainActivity.this, Music.class);

                                             startActivity(intent);
                                         }

                                     }
               );







               DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
               ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                       this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
               drawer.addDrawerListener(toggle);
               toggle.syncState();

               NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
               navigationView.setNavigationItemSelectedListener(this);




               adView = (AdView) findViewById(R.id.adView);

               //webView.onPause();
               // webView.pauseTimers();
               AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
               adView.loadAd(adRequest);

               interstitialAd = new InterstitialAd(this);
               interstitialAd.setAdUnitId("ca-app-pub-7233052509464359/9946060443");
               interstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
               interstitialAd.setAdListener(new AdListener() {
                   @Override
                   public void onAdClosed() {
                       // startActivity(new Intent(MainActivity.this,Designby.class));
                       finish();
                       interstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
                   }
               });



               }









    @Override
    public void onBackPressed() {


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();


            if (backPressedTime + 2000 > System.currentTimeMillis()) {

                super.onBackPressed();
                return;

            } else {
                Toast.makeText(getBaseContext(), "Tap Back button again to exit", Toast.LENGTH_SHORT).show();


            }

            backPressedTime = System.currentTimeMillis();

        }


    }


    //right upper corner setting menus




    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Aboutus/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Email) {

            Intent intent = new Intent(ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(EXTRA_EMAIL, new String[]{"saptsurmusic77@gmail.com"});
            intent.putExtra(EXTRA_SUBJECT, "subject");
            intent.putExtra(EXTRA_TEXT, "mail body");
            startActivity(createChooser(intent, ""));

        }

        if (id == R.id.action_Contact) {

            String phone = "020 26890434";
            Intent intent = new Intent(ACTION_DIAL, Uri.fromParts("tel", phone, null));
            startActivity(intent);

        }

        if (id == R.id.action_upload) {

            Intent launchYouTube2 = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");

            startActivity(new Intent(launchYouTube2.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCLgpemlKyvfbPVxh_hJKzWw")));


            return true;

        }



        return super.onOptionsItemSelected(item);
    }





    //Navigation drawer section



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.facebook) {


            Intent facebookAppIntent;
            try {
                facebookAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/337771113257661"));
                startActivity(facebookAppIntent);
            } catch (ActivityNotFoundException e) {
                facebookAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Saptsur-music-company-337771113257661/"));
                startActivity(facebookAppIntent);
            }


        }


        else if (id == R.id.instagram) {

            Uri uri = Uri.parse("https://www.instagram.com/saptsur_music/");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/saptsur_music/")));
            }




            //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/explore/locations/656214012/janjira-seafood-resto-bar/")));


        }

        else if (id == R.id.youtube) {

            Uri uri = Uri.parse("https://www.youtube.com/channel/UCLgpemlKyvfbPVxh_hJKzWw");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.google.android.youtube");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/channel/UCLgpemlKyvfbPVxh_hJKzWw")));
            }




            //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/c/GaneshSatkar")));




        }




        else if (id == R.id.twitter) {

            Uri uri = Uri.parse("https://twitter.com/SaptsurMusic");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.twitter.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://twitter.com/SaptsurMusic")));
            }




            //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/explore/locations/656214012/janjira-seafood-resto-bar/")));


        }





        else if (id == R.id.webite1) {
            Uri uri = Uri.parse("http://www.saptsurmusic.wordpress.com");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.android.chrome");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.saptsurmusic.wordpress.com")));
            }



        } else if (id == R.id.map) {

            Uri uri = Uri.parse("https://goo.gl/maps/zUk89euwnrm");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.google.android.apps.maps");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://goo.gl/maps/zUk89euwnrm")));
            }


        } else if (id == R.id.feedback) {

            startActivity(new Intent(MainActivity.this,Feedback.class));



        } else if (id == R.id.nav_share) {



            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBodyText = "To download Saptsur Artist App Click here.....https://play.google.com/store/apps/details?id=grdpinfotech.ganeshsatkar.saptsurmusic";
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT,"Subject here");
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
            startActivity(Intent.createChooser(sharingIntent, "Shearing Option"));
            return true;




        } else if (id == R.id.designby) {

            startActivity(new Intent(MainActivity.this,Designby.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }











}
