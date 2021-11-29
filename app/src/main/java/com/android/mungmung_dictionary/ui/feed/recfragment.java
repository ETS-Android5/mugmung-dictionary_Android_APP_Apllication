package com.android.mungmung_dictionary.ui.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.mungmung_dictionary.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class recfragment extends Fragment {
    RecyclerView recview;
    myadapter adpter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    FirebaseAuth mAuth  = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    DatabaseReference mDatabase=database.getReference();

    public recfragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater ,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate ( R.layout.fragment_recfragment, container, false );

        recview = (RecyclerView)view.findViewById ( R.id.recview );
        recview.setLayoutManager ( new LinearLayoutManager ( getContext () ) );


        Bundle extra = this.getArguments();

        String uid = user.getUid();

        if(extra != null){
            extra=getArguments();
        }


        mDatabase.child("Users").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                if (snapshot != null && snapshot.exists()) {


                    if (snapshot.getChildren() != null) {

                        String pork = snapshot.child("pork").getValue(String.class);
                        String beef = snapshot.child("beef").getValue(String.class);


                        if(pork.equals("돼지고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry" ).orderByChild("poke").equalTo("n") , model.class)
                                            .build();

                            adpter = new myadapter ( options );
                            recview.setAdapter ( adpter );

                            adpter.startListening ();
                        }

                        if(beef.equals("소고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry" ).orderByChild("beef").equalTo("n") , model.class)
                                            .build();

                            adpter = new myadapter ( options );
                            recview.setAdapter ( adpter );

                            adpter.startListening ();
                        }

                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        return view;
    }


}