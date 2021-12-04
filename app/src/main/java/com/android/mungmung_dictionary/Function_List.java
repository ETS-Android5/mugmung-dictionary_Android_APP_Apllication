package com.android.mungmung_dictionary;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.mungmung_dictionary.ui.Description.Dog_Food;
import com.android.mungmung_dictionary.ui.Dog_Food_Judgment.Dog_Food_harmfulness_Judgment;
import com.android.mungmung_dictionary.ui.Snack.Dog_Snack;
import com.android.mungmung_dictionary.ui.My_Dog_Information.My_Dog_Information;
import com.android.mungmung_dictionary.ui.Brand_List.Brand_List;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Function_List extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();

    //5가지 fragment 객체 선언
    private Brand_List dogFoodBrandList = new Brand_List();
    private Dog_Snack dogSnack = new Dog_Snack();
    private My_Dog_Information myDogInformation = new My_Dog_Information();
    private Dog_Food dogFoodMain = new Dog_Food();
    private Dog_Food_harmfulness_Judgment dogFoodharmfulnessJudgment = new Dog_Food_harmfulness_Judgment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function_list);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, dogFoodBrandList).commitAllowingStateLoss();

        // 메뉴 아이템이 선택될때 호출될 리스너 등록
        // home, heart, person, star, drink 다섯가지 fragment
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home: {
                        transaction.replace(R.id.frame_layout, dogFoodBrandList).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_food: {
                        transaction.replace(R.id.frame_layout, dogSnack).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_feed: {

                        transaction.replace(R.id.frame_layout, dogFoodMain).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_my: {
                        transaction.replace(R.id.frame_layout, myDogInformation).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_yesno: {
                        transaction.replace(R.id.frame_layout, dogFoodharmfulnessJudgment).commitAllowingStateLoss();
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