package com.webviewgoogle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView = null;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        android.net.NetworkInfo wifi = cm
//                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        android.net.NetworkInfo datac = cm
//                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if(CheckNetwork.isInternet(MainActivity.this)) {

            this.webView = findViewById(R.id.webview);

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            webView.loadUrl("https://www.google.com");
        }

        else{
            Toast toast = Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_LONG);
            toast.show();
        }

//        webPage();
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void webPage(String url){
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}