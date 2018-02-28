package me.rayanalkhelaiwi.webbrowserapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText webUrlBar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets the main activity's title
        setTitle(getString(R.string.title_main_activity));

        webUrlBar = (EditText) findViewById(R.id.web_url_bar);
        webView = (WebView) findViewById(R.id.web_view);

        //To receive and execute the uri when the send listener is clicked
        webUrlBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                //To checked if a uri is entered or not
                boolean entered = false;

                //To load the uri/url
                if (i == EditorInfo.IME_ACTION_SEND) {
                    webView.loadUrl("http://" + webUrlBar.getText().toString().trim());

                    //Change to true to confirm the load
                    entered = true;
                }

                return entered;
            }
        });

        WebSettings webSettings = webView.getSettings();

        //Enable WebView to run JS
        webSettings.setJavaScriptEnabled(true);

        //Load the home page URL
        webView.loadUrl(getString(R.string.home_page_url));

        //Uses a custom WebViewClient to open the link using this app
        webView.setWebViewClient(new customWebViewClient());
    }
}
