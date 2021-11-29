package com.example.logintest;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.logintest.R;
import com.example.logintest.ui.feed.recfragment;

public class FeedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.feed_main );
        getWindow ().setFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN );

        getSupportFragmentManager ().beginTransaction ().replace ( R.id.wrapper , new recfragment () ).commit ();
    }
}