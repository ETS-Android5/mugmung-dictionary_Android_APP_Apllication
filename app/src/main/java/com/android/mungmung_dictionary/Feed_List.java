package com.android.mungmung_dictionary;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.android.mungmung_dictionary.ui.Description.Dog_Food_Allergy;

public class Feed_List extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_feed_list);
        getWindow ().setFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN );

        getSupportFragmentManager ().beginTransaction ().replace ( R.id.wrapper , new Dog_Food_Allergy() ).commit ();
    }
}