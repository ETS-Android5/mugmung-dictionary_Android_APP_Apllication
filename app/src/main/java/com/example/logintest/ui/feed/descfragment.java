package com.example.logintest.ui.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.logintest.R;

public class descfragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String name, brand, material, purl, ingredients;

    public descfragment(){

    }

    public descfragment(String name, String brand, String material, String purl, String ingredients){
        this.name = name;
        this.brand = brand;
        this.material = material;
        this.purl = purl;
        this.ingredients = ingredients;
    }


    public static descfragment newInstance(String param1, String param2){
        descfragment fragment = new descfragment ();
        Bundle args = new Bundle ();
        args.putString ( ARG_PARAM1, param1 );
        args.putString ( ARG_PARAM2, param2 );
        fragment.setArguments ( args );
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        if(getArguments () != null){
            mParam1 = getArguments ().getString ( ARG_PARAM1 );
            mParam2 = getArguments ().getString ( ARG_PARAM2 );
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater , @Nullable ViewGroup container , @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate ( R.layout.fragment_descfragment, container, false );

        /*FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry" ) , model.class)
                        .build();*/

        ImageView imageholder = view.findViewById ( R.id.imagegholder );
        TextView nameholder = view.findViewById ( R.id.nameholder );
        TextView brandholder = view.findViewById ( R.id.brandholder );
        TextView metarialholder = view.findViewById ( R.id.metarialholder );
        TextView ingredientsholder = view.findViewById ( R.id.ingredientsholder );

        nameholder.setText ( name );
        brandholder.setText ( brand );
        metarialholder.setText ( material );
        ingredientsholder.setText(ingredients);
        Glide.with (getContext ()).load ( purl ).into ( imageholder );


        return view;
    }


    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext ();
        activity.getSupportFragmentManager ().beginTransaction ().replace ( R.id.frame_layout, new recfragment ()).addToBackStack ( null ).commit (); //R.id.wrapper
    }
}
