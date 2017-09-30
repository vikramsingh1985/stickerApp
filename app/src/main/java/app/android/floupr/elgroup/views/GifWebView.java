package app.android.floupr.elgroup.views;

import android.content.Context;
import android.webkit.WebView;

/**
 * Created by vikram on 30/9/17.
 */

public class GifWebView extends WebView {

    public GifWebView(Context context, String path) {
        super(context);

        loadUrl(path);
    }
}