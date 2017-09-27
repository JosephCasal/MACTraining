package com.example.joseph.training_927;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        String data = intent.getStringExtra("data");

        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

        webView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        WebViewClient client = new WebViewClient();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(client);

        webView.loadUrl("https://developer.android.com");

    }
}
