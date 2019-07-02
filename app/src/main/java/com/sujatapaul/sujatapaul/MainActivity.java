package com.sujatapaul.sujatapaul;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();
    }

    private void setUpUI() {
        WebView webView=findViewById(R.id.wv_main);
        webView.getSettings().setJavaScriptEnabled(true);
        final String url=getResources().getString(R.string.base_url);
        webView.loadUrl(url);
        webView.setHorizontalScrollBarEnabled(true);
        webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        //webView.getSettings().setSupportZoom(true);
        //webView.getSettings().setBuiltInZoomControls(true);
//        webView.getSettings().setDisplayZoomControls(true);
        if (Build.VERSION.SDK_INT >= 19) {
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String urll) {
                //if(urll!=null && url.startsWith(urll)){
                    return false;
//                }
//                else
//                {
//                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
//                    return true;
//                }
            }
        });
    }
}
