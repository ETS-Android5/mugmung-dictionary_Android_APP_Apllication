package com.android.mungmung_dictionary.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.android.mungmung_dictionary.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

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