package com.android.mungmung_dictionary;

import android.os.Bundle;
import android.view.MenuItem;

import com.android.mungmung_dictionary.ui.Food.FoodFragment;
import com.android.mungmung_dictionary.ui.My.MyFragment;
import com.android.mungmung_dictionary.ui.feed.FeedFragment;
import com.android.mungmung_dictionary.ui.home.HomeFragment;
import com.android.mungmung_dictionary.ui.yesno.YesnoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.mungmung_dictionary.databinding.ActivityBottomBinding;

public class BottomActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    //5가지 fragment 객체 선언
    private HomeFragment homeFragment = new HomeFragment();
    private FoodFragment foodFragment = new FoodFragment();
    private MyFragment myFragment = new MyFragment();
    private FeedFragment feedFragment = new FeedFragment();
    private YesnoFragment yesnoFragment = new YesnoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, homeFragment).commitAllowingStateLoss();

        // 메뉴 아이템이 선택될때 호출될 리스너 등록
        // home, heart, person, star, drink 다섯가지 fragment
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home: {
                        transaction.replace(R.id.frame_layout, homeFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_food: {
                        transaction.replace(R.id.frame_layout, foodFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_feed: {

                        transaction.replace(R.id.frame_layout, feedFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_my: {
                        transaction.replace(R.id.frame_layout, myFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_yesno: {
                        transaction.replace(R.id.frame_layout, yesnoFragment).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }

    public void setActionBarTitle(String title){
        ActionBar actionBar = getSupportActionBar ();
        if(actionBar != null){
            actionBar.setTitle ( title );
        }
    }


}