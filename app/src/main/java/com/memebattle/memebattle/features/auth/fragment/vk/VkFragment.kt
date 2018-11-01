package com.memebattle.memebattle.features.auth.fragment.vk


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.memebattle.memebattle.R
import com.memebattle.memebattle.core.presentation.BaseFragment
import com.memebattle.memebattle.features.auth.fragment.vk.webview.VkCodeCallback
import com.memebattle.memebattle.features.auth.fragment.vk.webview.VkWebViewClient
import kotlinx.android.synthetic.main.webview_vk.view.*

class VkFragment : BaseFragment() {
    lateinit var viewModel: VkViewModel

    override fun setHost(): Int {
        return R.id.flow_host_auth
    }

    override fun setFlowHost(): Int {
        return R.id.nav_host
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.webview_vk, container, false)
        viewModel = ViewModelProviders.of(this).get(VkViewModel::class.java)
        viewModel.user.observe(this, Observer {
            Log.i(TAG, "user observe $it")
            flowNavController.navigate(R.id.action_vkFragment_to_mainFlowFragment2)
        })
        v.webView.settings.javaScriptEnabled = true
        v.webView.webViewClient = VkWebViewClient(vkCodeCallback())
        v.webView.loadUrl(resources.getString(R.string.vk_auth_url))
        return v
    }

    private fun vkCodeCallback(): VkCodeCallback<String> {
        return object : VkCodeCallback<String> {
            override fun onSuccess(data: String?) {
                Log.i(TAG, "code in fragment $data")
                viewModel.vkAuth(data!!)
            }
        }
    }
}
