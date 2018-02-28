package me.rayanalkhelaiwi.webbrowserapp;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by rayan
 *
 * Edit shouldOverrideUrlLoading to disable loading/opening a link using the default browser, and open this app instead.
 *
 */

public class customWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().endsWith(".com")) return false;

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(intent);

        return true;
    }
}
