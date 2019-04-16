package com.tj.ch05_webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editUrl;
    private Button btnGo, btnBack;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUrl = (EditText)findViewById(R.id.editUrl);
        btnGo = (Button)findViewById(R.id.btnGo);
        btnBack = (Button)findViewById(R.id.btnBack);
        webView = (WebView)findViewById(R.id.webView);
        // 실행하면 webView에 "http://m.naver.com" 화면 보이기
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webView.loadUrl("http://192.168.10.101:8181/bookup");
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(editUrl.getText().toString().trim());
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.goBack();
            }
        });
    }
}
















