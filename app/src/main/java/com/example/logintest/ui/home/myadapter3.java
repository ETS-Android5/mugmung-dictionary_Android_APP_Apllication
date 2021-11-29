package com.example.logintest.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.logintest.R;
import com.example.logintest.ui.feed.descfragment;
import com.example.logintest.ui.feed.model;
import com.example.logintest.ui.feed.myadapter;
import com.example.logintest.ui.yesno.model2;
import com.example.logintest.ui.yesno.myadapter2;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

public class myadapter3 extends FirebaseRecyclerAdapter<model3, myadapter3.myviewholder>{

    RecyclerView recyclerView;

    public myadapter3(@NonNull FirebaseRecyclerOptions<model3> options) {
        super ( options );
    }

    @Override
    protected void onBindViewHolder(@NonNull myadapter3.myviewholder holder , int position , @NonNull final model3 model) {
        holder.BrandName.setText ( model.getBrandName () );
        //holder.BrandImage.setImageResource ( model.getBrandImage () );

        Glide.with ( holder.BrandImage.getContext () ).load ( model.getBrandImage () ).into ( holder.BrandImage );

    }

    @NonNull
    @Override
    public myadapter3.myviewholder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.singlerowdesign3, parent, false );
        return new myadapter3.myviewholder ( view );
    }


    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView BrandImage;
        TextView BrandName;

        public myviewholder(@NonNull View itemView) {
            super ( itemView );

            BrandImage = itemView.findViewById ( R.id.brandimage );
            BrandName = itemView.findViewById ( R.id.brandname );
        }
    }
}