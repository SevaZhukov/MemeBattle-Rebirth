package com.memebattle.memebattle.features.auth.fragment.vk


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.domain.BaseCallback
import com.memebattle.memebattle.features.auth.fragment.vk.webview.VkWebViewClient
import kotlinx.android.synthetic.main.webview_vk.view.*

class VkFragment : Fragment() {

    val TAG = "code"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.webview_vk, container, false)
        v.webView.settings.javaScriptEnabled = true
        v.webView.webViewClient = VkWebViewClient(vkCodeCallback())
        v.webView.loadUrl(resources.getString(R.string.vk_auth_url))
        return v
    }

    private fun vkCodeCallback(): BaseCallback<String> {
        return object : BaseCallback<String> {
            override fun onSuccess(data: String?) {
                Log.i(TAG, "code in fragment $data")

            }

            override fun onError(t: Throwable) {

            }

        }
    }
}
