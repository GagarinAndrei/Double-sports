package ru.gagarin.double_sports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import ru.gagarin.double_sports.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView: WebView = binding.webView
        webView.loadUrl("https://double-sports.ru/")

    }
}