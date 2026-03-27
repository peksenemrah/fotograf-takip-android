package com.fotograf.takip;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        WebSettings settings = webView.getSettings();

        // JavaScript etkinleştir
        settings.setJavaScriptEnabled(true);

        // localStorage için DOM storage zorunlu
        settings.setDomStorageEnabled(true);

        // Dosya erişimi (assets klasörü için)
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);

        // Görünüm
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setTextZoom(100);

        // Sayfa içi linkler tarayıcı açmasın
        webView.setWebViewClient(new WebViewClient());

        // alert(), confirm(), prompt() dialoglarını etkinleştir
        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(message)
                        .setPositiveButton("Tamam", (d, w) -> result.confirm())
                        .setOnCancelListener(d -> result.cancel())
                        .create()
                        .show();
                return true;
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(message)
                        .setPositiveButton("Evet", (d, w) -> result.confirm())
                        .setNegativeButton("Hayır", (d, w) -> result.cancel())
                        .setOnCancelListener(d -> result.cancel())
                        .create()
                        .show();
                return true;
            }
        });

        // Uygulamayı yükle
        webView.loadUrl("file:///android_asset/www/index.html");
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
