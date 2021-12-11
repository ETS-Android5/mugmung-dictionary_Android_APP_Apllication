package com.android.mungmung_dictionary.ui.Description;

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
import com.android.mungmung_dictionary.R;

public class Dog_Food_Detail_Description extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String name, brand, material, purl, ingredients;

    public Dog_Food_Detail_Description(){

    }

    public Dog_Food_Detail_Description(String name, String brand, String material, String purl, String ingredients){
        this.name = name;
        this.brand = brand;
        this.material = material;
        this.purl = purl;
        this.ingredients = ingredients;
    }


    public static Dog_Food_Detail_Description newInstance(String param1, String param2){
        Dog_Food_Detail_Description fragment = new Dog_Food_Detail_Description();
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
        View view = inflater.inflate ( R.layout.ui_detail_description, container, false );



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
        activity.getSupportFragmentManager ().beginTransaction ().replace ( R.id.frame_layout, new Dog_Food_Allergy()).addToBackStack ( null ).commit (); //R.id.wrapper
    }
}
