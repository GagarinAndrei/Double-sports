package ru.gagarin.double_sports

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import ru.gagarin.double_sports.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {

    private lateinit var myWebView: WebView
    private val myLinks: List<String> = listOf(
        "https://instagram.com/doublesports/",
        "https://vk.com/doublesports",
        "https://www.youtube.com/channel/UCH7qZ30ljDelNifq5537OiQ?view_as=subscriber",
        "https://t.me/doublesports_bot"
    )

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myWebView = binding.webView
        myWebView.apply {
            loadUrl("https://double-sports.ru/")
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    request: WebResourceRequest
                ): Boolean {
                    val isLinkInList = myLinks.contains(request.url.toString())

                    return if (isLinkInList) {
                        val intent = Intent(Intent.ACTION_VIEW, request.url)
                        startActivity(intent)
                        true
                    } else false
                }
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check if the key event was the Back button and if there's history
        if (keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()) {
            myWebView.goBack()
            return true
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
    }
}