package com.example.logintest.ui.feed;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.logintest.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
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

    /*    TextView textView ;
        textView = view.findViewById(R.id.textView);
       // textView.setText(FirebaseDatabase.getInstance ().getReference ().child ( "Dry" ).orderByChild("salmon").equalTo("yes"));
        Query query ;
        query = FirebaseDatabase.getInstance ().getReference ().child ( "Dry" ).orderByChild("salmon").equalTo("yes");
        textView.setText(query.toString()); */

        Bundle extra = this.getArguments();

        String uid = user.getUid();

        if(extra != null){
            extra=getArguments();
            // String porkcheck = extra.getString("pork");
        }
       /* FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry" ).orderByChild("salmon").equalTo("yes") , model.class)
                        .build();*/

        mDatabase.child("Users").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                if (snapshot != null && snapshot.exists()) {
                    //Log.d(TAG, "Current data: " + snapshot.getData());

                    if (snapshot.getChildren() != null) {
                        //for (DataSnapshot snap : snapshot.getChildren()) {{
                        String pork = snapshot.child("pork").getValue(String.class);
                        String beef = snapshot.child("beef").getValue(String.class);

                        //textView.setText(check);

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
       /* FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry" ).orderByChild("salmon").equalTo("yes") , model.class)
                        .build();*/



        // adpter = new myadapter ( options );
        //recview.setAdapter ( adpter );




        return view;
    }

   /* @Override
    public void onStart() {
        super.onStart ();
       // adpter.startListening ();
    }

    @Override
    public void onStop() {
        super.onStop ();
       // adpter.stopListening ();
    }*/


}