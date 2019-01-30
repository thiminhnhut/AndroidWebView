package io.github.thiminhnhut.androidwebviewexamples.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import io.github.thiminhnhut.androidwebviewexamples.R



class FragmentWebView: Fragment() {
    private lateinit var listener: OnEvent

    companion object {
        fun newInstance(listener: OnEvent): FragmentWebView {
            val result = FragmentWebView()
            result.listener = listener
            return result
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_webview, container, false)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            listener.onClick(this)
        }

        val webView = view.findViewById<WebView>(R.id.webView)
        val webViewSetting = webView.settings
        webViewSetting.javaScriptEnabled = true
        webView.loadUrl("https://github.com/")
        return view
    }

    interface OnEvent {
        fun onClick(sender: Any)
    }
}