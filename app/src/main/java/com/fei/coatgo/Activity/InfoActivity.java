package com.fei.coatgo.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;

import com.fei.coatgo.R;

import org.jsoup.nodes.Document;

public class InfoActivity extends Activity {

    private WebView web;
    private ImageView back;
    private ImageView more;

    Document doc = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }
}
