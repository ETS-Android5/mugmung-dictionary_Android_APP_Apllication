package com.android.mungmung_dictionary.ui.Dog_Food_Judgment;

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
//import com.makeramen.roundedimageview.RoundedImageView;

public class myadapter2 extends FirebaseRecyclerAdapter<model2, myadapter2.myviewholder>{

    RecyclerView recyclerView;

    public myadapter2(@NonNull FirebaseRecyclerOptions<model2> options) {
        super ( options );
    }

    @Override
    protected void onBindViewHolder(@NonNull myadapter2.myviewholder holder , int position , @NonNull final model2 model) {
        holder.foodnametext.setText ( model.getFoodname () );
        holder.functiontext.setText ( model.getFunction () );
        //holder.ingredienttext.setText ( model.getIngredient () );

        Glide.with ( holder.Foodimage.getContext () ).load ( model.getFoodimage () ).into ( holder.Foodimage );

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.dog_food_judgment_fragment_view, parent, false );
        return new myadapter2.myviewholder ( view );
    }


    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView Foodimage;
        TextView foodnametext, functiontext;

        public myviewholder(@NonNull View itemView) {
            super ( itemView );

            Foodimage = itemView.findViewById ( R.id.foodimage );
            foodnametext = itemView.findViewById ( R.id.foodnametext );
            functiontext = itemView.findViewById ( R.id.functiontext );
        }
    }
}