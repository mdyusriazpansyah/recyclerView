package com.example.recycleview;

import  androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        String name = getIntent().getStringExtra("name");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        url = "https://en.m.wikipedia.org/wiki/Android_"+ name.replace(" ", "_");
        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.action_details,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
        switch(item.getItemId()) {
            case R.id.action_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, url);
                startActivity(intent);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}