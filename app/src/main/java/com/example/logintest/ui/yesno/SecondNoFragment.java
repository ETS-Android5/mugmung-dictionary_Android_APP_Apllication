package com.example.logintest.ui.yesno;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logintest.R;
import com.example.logintest.ui.feed.model;
import com.example.logintest.ui.feed.myadapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class SecondNoFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    RecyclerView Norecview;
    myadapter2 adpter;
    ExpandableListView listMain;

    public SecondNoFragment(){

    }

    public static SecondNoFragment newInstance(String param1, String param2){
        SecondNoFragment fragment = new SecondNoFragment ();
        Bundle args = new Bundle ();
        args.putString ( ARG_PARAM1, param1);
        args.putString ( ARG_PARAM2, param2 );
        fragment.setArguments ( args );
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        if ( getArguments() != null ){
            mParam1 = getArguments ().getString ( ARG_PARAM1 );
            mParam2 = getArguments ().getString ( ARG_PARAM2 );
        }
    }


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater , @Nullable @org.jetbrains.annotations.Nullable ViewGroup container , @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate ( R.layout.tab_nofragment, container, false );

        Norecview = (RecyclerView)view.findViewById ( R.id.Norecview );
        Norecview.setLayoutManager ( new LinearLayoutManager ( getContext () ) );

        FirebaseRecyclerOptions<model2> options =
                new FirebaseRecyclerOptions.Builder<model2>()
                        .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "BadDictionary" ) , model2.class)
                        .build();

        adpter = new myadapter2 ( options );
        Norecview.setAdapter ( adpter );

        return view;
    }

    @Override
    public void onStart() {
        super.onStart ();
        adpter.startListening ();
    }

    @Override
    public void onStop() {
        super.onStop ();
        adpter.stopListening ();
    }
}
