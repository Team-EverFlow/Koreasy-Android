package com.koreasy.everflow.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.accompanist.web.*
import com.koreasy.everflow.MainActivity

class ComposeApp(private val activity: MainActivity) {
    @SuppressLint("SetJavaScriptEnabled")
    @Composable
    fun Content() {
        val url by remember { mutableStateOf("https://team-everflow.github.io/koreasy/") }
        val webViewState = rememberWebViewState(url = url)
        val navigator = rememberWebViewNavigator()
        val client = AccompanistWebViewClient();

        WebView(
            state = webViewState,
            navigator = navigator,
            modifier = Modifier.fillMaxSize(),
            onCreated = {
                it.settings.javaScriptEnabled = true
                it.settings.domStorageEnabled = true
                it.settings.userAgentString = "Chrome/105.0.2704.103"

                it.settings.javaScriptCanOpenWindowsAutomatically = true
                it.settings.setSupportMultipleWindows(true)

                it.settings.useWideViewPort = true
            },
            client = client
        )
    }
}