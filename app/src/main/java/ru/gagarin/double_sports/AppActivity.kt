package ru.gagarin.double_sports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import ru.gagarin.double_sports.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check if the key event was the Back button and if there's history
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack()
            return true
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        webView = binding.webView

        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://double-sports.ru/")
        webView.webViewClient = WebViewClient()


    }
}