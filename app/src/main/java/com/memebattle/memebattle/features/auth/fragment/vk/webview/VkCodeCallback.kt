package com.memebattle.memebattle.features.auth.fragment.vk.webview

interface VkCodeCallback<T> {
    fun onSuccess(data: T?)
}