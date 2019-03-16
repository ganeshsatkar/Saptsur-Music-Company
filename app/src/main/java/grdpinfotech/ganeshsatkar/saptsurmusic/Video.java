package grdpinfotech.ganeshsatkar.saptsurmusic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.Timer;
import java.util.TimerTask;

public class Video extends AppCompatActivity {
    private long backPressedTime;
    private boolean exit = false;
    private WebView webView;
    TextView tt;
    AdView adView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        webView = (WebView) findViewById(R.id.webview);
        //webView.getSettings().setLoadWithOverviewMode(true);
        //webView.getSettings().setUseWideViewPort(true);

        tt = (TextView) findViewById(R.id.text1);

        checkConnection();



    }


    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    protected  void onPause()
    {

        super.onPause();
        webView.onPause();
    }


    @Override
    protected void onResume(){

        super.onResume();
        webView.onResume();
    }



    public void checkConnection() {
        if (isOnline()) {
            Toast.makeText(Video.this, "You are connected to Internet", Toast.LENGTH_SHORT).show();

            webView.loadUrl("https://www.youtube.com/channel/UCLgpemlKyvfbPVxh_hJKzWw");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());







        } else {
            Toast.makeText(Video.this, "You are not connected to Internet", Toast.LENGTH_LONG).show();
            tt.setText("         Can't Connect to the Server.\n Plese Check Your Internet Connection");
        }
    }









    @Override
    public void onBackPressed()
    {


        if ( backPressedTime+2000> System.currentTimeMillis()) {

            super.onBackPressed();
            return;

        }

        else {
            Toast.makeText(getBaseContext(),"Tap Back button again to exit",Toast.LENGTH_SHORT).show();



        }

        backPressedTime=System.currentTimeMillis();

    }









    public void next()
    {

            //    startActivity(new Intent(MainActivity.this,Next.class));
            // startActivity(new Intent(MainActivity.this,Designby.class));
            finish();
        }
}




