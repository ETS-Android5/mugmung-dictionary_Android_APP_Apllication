package com.example.logintest.ui.feed;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;

import com.bumptech.glide.load.model.Model;
import com.example.logintest.BottomActivity;
import com.example.logintest.R;
import com.example.logintest.test;
import com.example.logintest.ui.yesno.FirstYesFragment;
import com.example.logintest.ui.yesno.SecondNoFragment;
import com.example.logintest.ui.yesno.YesnoFragment;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FeedFragment extends Fragment {

    RecyclerView recview;
    myadapter adpter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    FirebaseAuth mAuth  = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    DatabaseReference mDatabase=database.getReference();

    private ArrayList<Model> arrayList;
    Query query;

    private ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_feed,null);

        mViewPager = (ViewPager)view.findViewById(R.id.viewPager);

        TabLayout tabLayout = (TabLayout)view.findViewById ( R.id.tab_layout );
        tabLayout.addTab ( tabLayout.newTab ().setText ( "Dry" ) );
        tabLayout.addTab ( tabLayout.newTab ().setText ( "Wet" ) );
        tabLayout.setTabGravity ( TabLayout.GRAVITY_FILL );

        final ViewPager viewpager = (ViewPager)view.findViewById ( R.id.viewPager );
        final FeedFragment.PagerAdapter adapter = new FeedFragment.PagerAdapter( getChildFragmentManager (), tabLayout.getTabCount () );
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




        return view;
    }

    @Override
    public void onResume() {
        super.onResume ();
        FragmentActivity activity = getActivity ();
        if(activity != null){
            ((BottomActivity) activity).setActionBarTitle ( "Feed" );
        }
    }


    private class PagerAdapter extends FragmentPagerAdapter {
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
                    DrytabFragment tab1 = new DrytabFragment();
                    return tab1;
                case 1:
                    WettabFragment tab2 = new WettabFragment();
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