package com.example.logintest.ui.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.logintest.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<model, myadapter.myviewholder>{

    RecyclerView recyclerView;

    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super ( options );
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder , int position , @NonNull final model model) {
        holder.nametext.setText ( model.getName () );
        holder.brandtext.setText ( model.getBrand () );



        Glide.with ( holder.img1.getContext () ).load ( model.getProfile () ).into ( holder.img1 );

        holder.img1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext ();
                activity.getSupportFragmentManager ().beginTransaction ().replace ( R.id.frame_layout, //wrapper
                        new descfragment (model.getName (), model.getBrand (), model.getMaterial (), model.getProfile (), model.getIngredients ()) ).addToBackStack ( null ).commit ();
            }
        } );
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.singlerowdesign, parent, false );
        return new myviewholder ( view );
    }


    public class myviewholder extends RecyclerView.ViewHolder{
        ImageView img1;
        TextView nametext, brandtext;

        public myviewholder(@NonNull View itemView) {
            super ( itemView );

            img1 = itemView.findViewById ( R.id.img1 );
            nametext = itemView.findViewById ( R.id.nametext );
            brandtext = itemView.findViewById ( R.id.brandtext );
        }
    }
}
