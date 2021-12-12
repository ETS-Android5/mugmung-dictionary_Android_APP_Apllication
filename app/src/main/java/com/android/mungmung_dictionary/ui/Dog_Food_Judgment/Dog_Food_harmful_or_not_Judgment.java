package com.android.mungmung_dictionary.ui.Dog_Food_Judgment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.mungmung_dictionary.Function_List;
import com.android.mungmung_dictionary.R;
import com.android.mungmung_dictionary.Realtime_Recognition_yolo;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

public class Dog_Food_harmful_or_not_Judgment extends Fragment {

    private ViewPager mViewPager;



    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate( R.layout.ui_dog_food_judgment_harmfulness_judgment,container, false);
        mViewPager = (ViewPager)view.findViewById ( R.id.viewPager );


        //tablayout을 설정
        //Good과 Bad 두 가지 탭을 생성해주자
        TabLayout tabLayout = (TabLayout)view.findViewById ( R.id.tab_layout );
        tabLayout.addTab ( tabLayout.newTab ().setText ( "Yes" ) );
        tabLayout.addTab ( tabLayout.newTab ().setText ( "No" ) );
        tabLayout.setTabGravity ( TabLayout.GRAVITY_FILL );


        //Viewpager객체를 만들어 xml파일의 viewpager 레이아웃을 가져온다
        //Adapter객체를 만들어 viewpager와 연결해준다
        final ViewPager viewpager = (ViewPager)view.findViewById ( R.id.viewPager );
        final PagerAdapter adapter = new PagerAdapter ( getChildFragmentManager (), tabLayout.getTabCount () );
        viewpager.setAdapter ( adapter );
        viewpager.addOnPageChangeListener ( new TabLayout.TabLayoutOnPageChangeListener ( tabLayout ) );
        tabLayout.setOnTabSelectedListener ( new TabLayout.OnTabSelectedListener () {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem ( tab.getPosition () );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );

        Button feed_test=(Button)view.findViewById(R.id.feed_test);
        feed_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Realtime_Recognition_yolo.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume ();
        FragmentActivity activity = getActivity ();
        if(activity != null){
            ((Function_List) activity).setActionBarTitle ( "YesNo" );
        }
    }



    //내부 클래스로 Adapter 클래스를 생성
    private class PagerAdapter extends FragmentPagerAdapter{
        int mNumOfTabs;

        public PagerAdapter(@NonNull @NotNull FragmentManager fm , int NumOfTabs) {
            super ( fm );
            this.mNumOfTabs = NumOfTabs;
        }

        //getItem 메서드를 생성해 해당 프래그먼트를 각각의 tab 화면에 표시하도록 해준다
        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    Dog_Food_Positive_Effect_List tab1 = new Dog_Food_Positive_Effect_List();
                    return tab1;
                case 1:
                    Dog_Food_Negative_Effect_List tab2 = new Dog_Food_Negative_Effect_List();
                    return tab2;
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

}