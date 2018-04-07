package com.example.timotheecorrado.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView


class InfoActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        //fullscreen

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_info)

        findViewById<TextView>(R.id.info_text).setText(intent.getStringExtra("NAME"))

        val wv = findViewById<WebView>(R.id.info_web)
        wv.webViewClient = MyWebViewClient()

        val wvs = wv.settings

        wvs.javaScriptEnabled = true

        /*val info:String = intent.getStringExtra("NAME")*/

        var url:String? = null

        when(intent.getStringExtra("NAME"))
        {
            "Federer" -> url = "https://fr.wikipedia.org/wiki/Roger_Federer"
            "Azarenka" -> url = "https://fr.wikipedia.org/wiki/Victoria_Azarenka"
            "Hingis" -> url = "https://fr.wikipedia.org/wiki/Martina_Hingis"
            "Murray" -> url = "https://fr.wikipedia.org/wiki/Andy_Murray"
            "Nadal" -> url = "https://fr.wikipedia.org/wiki/Rafael_Nadal"
            "Schiavone" -> url = "https://fr.wikipedia.org/wiki/Francesca_Schiavone"
            "Serena" -> url = "https://fr.wikipedia.org/wiki/Serena_Williams"
            "Sharapova" -> url = "https://fr.wikipedia.org/wiki/Maria_Sharapova"
            "Tsonga" -> url = "https://fr.wikipedia.org/wiki/Jo-Wilfried_Tsonga"
        }

        wv.loadUrl(url)
    }

    class MyWebViewClient : WebViewClient()
    {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }
    }
}