package com.sryang.screenpicturepagetestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.torang_core.navigation.PicturePageNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var picturePageNavigation: PicturePageNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        picturePageNavigation.go(this, 513, 0)
    }
}