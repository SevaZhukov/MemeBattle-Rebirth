package com.memebattle.memebattle.features.auth.fragment.vk.webview

import android.graphics.Bitmap
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import com.memebattle.memebattle.core.domain.BaseCallback

class VkWebViewClient(val callback: BaseCallback<String>) : WebViewClient() {
    val TAG = "code"

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        view!!.loadUrl(url)
        return true
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        Log.i(TAG, "onPageStarted $url")
        if(url!!.contains("code=")) {
            val code = url.subSequence(url.lastIndexOf("code=") + 5, url.length).toString()
            Log.i(TAG, "code $code")
            callback.onSuccess(code)
        }
    }
}