package com.example.logintest.ui.feed;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.PopupMenu;

import com.bumptech.glide.load.model.Model;
import com.example.logintest.R;
import com.example.logintest.ui.yesno.model2;
import com.example.logintest.ui.yesno.myadapter2;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DrytabFragment extends Fragment {

    RecyclerView Dryrecview;
    myadapter adpter;
    ExpandableListView listMain;

    private ArrayList<Model> arrayList;
    Query query;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    FirebaseAuth mAuth  = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    DatabaseReference mDatabase=database.getReference();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tab_dryfragment, container, false);

        Dryrecview = (RecyclerView)view.findViewById ( R.id.Dryrecview );
        Dryrecview.setLayoutManager ( new LinearLayoutManager( getContext () ) );

        arrayList = new ArrayList<>();//model 객체를 담을 리스트


        Bundle extra = this.getArguments();

        String uid = user.getUid();

        if(extra != null){
            extra=getArguments();
              }

        final Button btn = (Button) view.findViewById(R.id.drybutton);

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery( FirebaseDatabase.getInstance ().getReference ().child ("Dry2"), model.class)
                        .build();

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                PopupMenu popup = new PopupMenu(getContext(), v);

                popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {

                            case R.id.menu0:
                                btn.setText("전체");
                                FirebaseRecyclerOptions<model> options0 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("poke").equalTo("n"), model.class)
                                                .build();

                                adpter = new myadapter ( options0 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu1:
                                btn.setText("FINIKI");
                                FirebaseRecyclerOptions<model> options =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu2:
                                btn.setText("FIRST CHOICE");
                                FirebaseRecyclerOptions<model> options2 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options2 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu3:
                                btn.setText("FISH FOR DOG");
                                FirebaseRecyclerOptions<model> options3 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options3 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu4:
                                btn.setText("FORZATEN");
                                FirebaseRecyclerOptions<model> options4 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options4 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu5:
                                btn.setText("건강백서");
                                FirebaseRecyclerOptions<model> options5 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options5 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu6:
                                btn.setText("HARIM");
                                FirebaseRecyclerOptions<model> options6 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options6 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu7:
                                btn.setText("HILLS");
                                FirebaseRecyclerOptions<model> options7 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options7 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu8:
                                btn.setText("PINNACLE");
                                FirebaseRecyclerOptions<model> options8 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options8 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu9:
                                btn.setText("PROPLAN");
                                FirebaseRecyclerOptions<model> options9 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options9);
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu10:
                                btn.setText("풀무원");
                                FirebaseRecyclerOptions<model> options10 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options10 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu11:
                                btn.setText("PUREVITA");
                                FirebaseRecyclerOptions<model> options11 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options11 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu12:
                                btn.setText("PURINAONE");
                                FirebaseRecyclerOptions<model> options12 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options12 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu13:
                                btn.setText("TOW");
                                FirebaseRecyclerOptions<model> options13 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options13 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu14:
                                btn.setText("TRIUMPH");
                                FirebaseRecyclerOptions<model> options14 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options14 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu15:
                                btn.setText("TROVET");
                                FirebaseRecyclerOptions<model> options15 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("poke").equalTo("n") , model.class)
                                                .build();

                                adpter = new myadapter ( options15 );
                                Dryrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            default:
                                break;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });

        adpter = new myadapter ( options );
        Dryrecview.setAdapter ( adpter );

        mDatabase.child("Users").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                if (snapshot != null && snapshot.exists()) {
                    //Log.d(TAG, "Current data: " + snapshot.getData());

                    if (snapshot.getChildren() != null) {
                        //for (DataSnapshot snap : snapshot.getChildren()) {{
                        String pork = snapshot.child("pork").getValue(String.class);
                        String beef = snapshot.child("beef").getValue(String.class);
                        String chicken = snapshot.child("chicken").getValue(String.class);
                        String fish = snapshot.child("fish").getValue(String.class);
                        String rabbit = snapshot.child("rabbit").getValue(String.class);
                        String sheep = snapshot.child("sheep").getValue(String.class);
                        String milk = snapshot.child("milk").getValue(String.class);
                        String tan = snapshot.child("tan").getValue(String.class);
                        String fruit = snapshot.child("fruit").getValue(String.class);
                        String bean = snapshot.child("bean").getValue(String.class);
                        String vege = snapshot.child("vege").getValue(String.class);

                        //textView.setText(check);

                        if(pork.equals("돼지고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry2" ).orderByChild("poke").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener(){
                                public void onClick(View v){
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options );
                                                    Dryrecview.setAdapter ( adpter );

                                                    adpter.startListening ();
                                                    break;
                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options1 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options1 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu2:
                                                    btn.setText("FIRST CHOICE");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options2 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("FISH FOR DOG");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options3 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options4 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options5 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu6:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options6 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu7:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options7 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options7 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu8:
                                                    btn.setText("PINNACLE");
                                                    FirebaseRecyclerOptions<model> options8 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options8 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu9:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options9 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options9);
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu10:
                                                    btn.setText("풀무원");
                                                    FirebaseRecyclerOptions<model> options10 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options10 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu11:
                                                    btn.setText("PUREVITA");
                                                    FirebaseRecyclerOptions<model> options11 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options11 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu12:
                                                    btn.setText("PURINAONE");
                                                    FirebaseRecyclerOptions<model> options12 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options12 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu13:
                                                    btn.setText("TOW");
                                                    FirebaseRecyclerOptions<model> options13 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options13 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu14:
                                                    btn.setText("TRIUMPH");
                                                    FirebaseRecyclerOptions<model> options14 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options14 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu15:
                                                    btn.setText("TROVET");
                                                    FirebaseRecyclerOptions<model> options15 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options15 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                default:
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                    popup.show();
                                }
                            });

                            adpter = new myadapter ( options );
                            Dryrecview.setAdapter ( adpter );

                            adpter.startListening ();
                        }

                        else if(beef.equals("소고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry2" ).orderByChild("beef").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener(){
                                public void onClick(View v){
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options );
                                                    Dryrecview.setAdapter ( adpter );

                                                    adpter.startListening ();
                                                    break;
                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options1 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options1 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu2:
                                                    btn.setText("FIRST CHOICE");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options2 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("FISH FOR DOG");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options3 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options4 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options5 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu6:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options6 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu7:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options7 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options7 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu8:
                                                    btn.setText("PINNACLE");
                                                    FirebaseRecyclerOptions<model> options8 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options8 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu9:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options9 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options9);
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu10:
                                                    btn.setText("풀무원");
                                                    FirebaseRecyclerOptions<model> options10 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options10 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu11:
                                                    btn.setText("PUREVITA");
                                                    FirebaseRecyclerOptions<model> options11 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options11 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu12:
                                                    btn.setText("PURINAONE");
                                                    FirebaseRecyclerOptions<model> options12 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options12 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu13:
                                                    btn.setText("TOW");
                                                    FirebaseRecyclerOptions<model> options13 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options13 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu14:
                                                    btn.setText("TRIUMPH");
                                                    FirebaseRecyclerOptions<model> options14 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options14 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu15:
                                                    btn.setText("TROVET");
                                                    FirebaseRecyclerOptions<model> options15 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("beef").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options15 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                default:
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                    popup.show();
                                }
                            });

                            adpter = new myadapter ( options );
                            Dryrecview.setAdapter ( adpter );
                            adpter.startListening ();
                        }

                        else if(chicken.equals("닭고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry2" ).orderByChild("chicken").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener(){
                                public void onClick(View v){
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options );
                                                    Dryrecview.setAdapter ( adpter );

                                                    adpter.startListening ();
                                                    break;
                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options1 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options1 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu2:
                                                    btn.setText("FIRST CHOICE");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options2 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("FISH FOR DOG");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options3 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options4 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options5 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu6:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options6 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu7:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options7 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options7 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu8:
                                                    btn.setText("PINNACLE");
                                                    FirebaseRecyclerOptions<model> options8 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options8 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu9:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options9 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options9);
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu10:
                                                    btn.setText("풀무원");
                                                    FirebaseRecyclerOptions<model> options10 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options10 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu11:
                                                    btn.setText("PUREVITA");
                                                    FirebaseRecyclerOptions<model> options11 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options11 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu12:
                                                    btn.setText("PURINAONE");
                                                    FirebaseRecyclerOptions<model> options12 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options12 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu13:
                                                    btn.setText("TOW");
                                                    FirebaseRecyclerOptions<model> options13 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options13 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu14:
                                                    btn.setText("TRIUMPH");
                                                    FirebaseRecyclerOptions<model> options14 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options14 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu15:
                                                    btn.setText("TROVET");
                                                    FirebaseRecyclerOptions<model> options15 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("chicken").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options15 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                default:
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                    popup.show();
                                }
                            });

                            adpter = new myadapter ( options );
                            Dryrecview.setAdapter ( adpter );
                            adpter.startListening ();
                        }

                        else if(fish.equals("물고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry2" ).orderByChild("fish").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener(){
                                public void onClick(View v){
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options );
                                                    Dryrecview.setAdapter ( adpter );

                                                    adpter.startListening ();
                                                    break;
                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options1 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options1 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu2:
                                                    btn.setText("FIRST CHOICE");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options2 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("FISH FOR DOG");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options3 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options4 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options5 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu6:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options6 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu7:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options7 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options7 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu8:
                                                    btn.setText("PINNACLE");
                                                    FirebaseRecyclerOptions<model> options8 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options8 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu9:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options9 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options9);
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu10:
                                                    btn.setText("풀무원");
                                                    FirebaseRecyclerOptions<model> options10 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options10 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu11:
                                                    btn.setText("PUREVITA");
                                                    FirebaseRecyclerOptions<model> options11 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options11 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu12:
                                                    btn.setText("PURINAONE");
                                                    FirebaseRecyclerOptions<model> options12 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options12 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu13:
                                                    btn.setText("TOW");
                                                    FirebaseRecyclerOptions<model> options13 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options13 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu14:
                                                    btn.setText("TRIUMPH");
                                                    FirebaseRecyclerOptions<model> options14 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options14 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu15:
                                                    btn.setText("TROVET");
                                                    FirebaseRecyclerOptions<model> options15 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("fish").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options15 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                default:
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                    popup.show();
                                }
                            });

                            adpter = new myadapter ( options );
                            Dryrecview.setAdapter ( adpter );
                            adpter.startListening ();
                        }

                        else if(rabbit.equals("토끼고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry2" ).orderByChild("rabbit").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener(){
                                public void onClick(View v){
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options );
                                                    Dryrecview.setAdapter ( adpter );

                                                    adpter.startListening ();
                                                    break;
                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options1 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options1 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu2:
                                                    btn.setText("FIRST CHOICE");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options2 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("FISH FOR DOG");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options3 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options4 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("poke").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options5 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu6:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options6 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu7:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options7 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options7 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu8:
                                                    btn.setText("PINNACLE");
                                                    FirebaseRecyclerOptions<model> options8 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options8 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu9:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options9 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options9);
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu10:
                                                    btn.setText("풀무원");
                                                    FirebaseRecyclerOptions<model> options10 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options10 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu11:
                                                    btn.setText("PUREVITA");
                                                    FirebaseRecyclerOptions<model> options11 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options11 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu12:
                                                    btn.setText("PURINAONE");
                                                    FirebaseRecyclerOptions<model> options12 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options12 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu13:
                                                    btn.setText("TOW");
                                                    FirebaseRecyclerOptions<model> options13 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options13 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu14:
                                                    btn.setText("TRIUMPH");
                                                    FirebaseRecyclerOptions<model> options14 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options14 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu15:
                                                    btn.setText("TROVET");
                                                    FirebaseRecyclerOptions<model> options15 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("rabbit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options15 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                default:
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                    popup.show();
                                }
                            });

                            adpter = new myadapter ( options );
                            Dryrecview.setAdapter ( adpter );
                            adpter.startListening ();
                        }

                        else if(sheep.equals("양고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry2" ).orderByChild("sheep").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener(){
                                public void onClick(View v){
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options );
                                                    Dryrecview.setAdapter ( adpter );

                                                    adpter.startListening ();
                                                    break;
                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options1 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options1 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu2:
                                                    btn.setText("FIRST CHOICE");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options2 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("FISH FOR DOG");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options3 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options4 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options5 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu6:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options6 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu7:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options7 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options7 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu8:
                                                    btn.setText("PINNACLE");
                                                    FirebaseRecyclerOptions<model> options8 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options8 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu9:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options9 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options9);
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu10:
                                                    btn.setText("풀무원");
                                                    FirebaseRecyclerOptions<model> options10 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options10 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu11:
                                                    btn.setText("PUREVITA");
                                                    FirebaseRecyclerOptions<model> options11 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options11 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu12:
                                                    btn.setText("PURINAONE");
                                                    FirebaseRecyclerOptions<model> options12 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options12 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu13:
                                                    btn.setText("TOW");
                                                    FirebaseRecyclerOptions<model> options13 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options13 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu14:
                                                    btn.setText("TRIUMPH");
                                                    FirebaseRecyclerOptions<model> options14 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options14 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu15:
                                                    btn.setText("TROVET");
                                                    FirebaseRecyclerOptions<model> options15 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("sheep").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options15 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                default:
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                    popup.show();
                                }
                            });

                            adpter = new myadapter ( options );
                            Dryrecview.setAdapter ( adpter );
                            adpter.startListening ();
                        }

                        else if(milk.equals("유제품")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry2" ).orderByChild("egg").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener(){
                                public void onClick(View v){
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options );
                                                    Dryrecview.setAdapter ( adpter );

                                                    adpter.startListening ();
                                                    break;
                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options1 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options1 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu2:
                                                    btn.setText("FIRST CHOICE");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options2 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("FISH FOR DOG");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options3 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options4 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options5 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu6:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options6 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu7:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options7 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options7 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu8:
                                                    btn.setText("PINNACLE");
                                                    FirebaseRecyclerOptions<model> options8 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options8 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu9:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options9 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options9);
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu10:
                                                    btn.setText("풀무원");
                                                    FirebaseRecyclerOptions<model> options10 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options10 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu11:
                                                    btn.setText("PUREVITA");
                                                    FirebaseRecyclerOptions<model> options11 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options11 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu12:
                                                    btn.setText("PURINAONE");
                                                    FirebaseRecyclerOptions<model> options12 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options12 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu13:
                                                    btn.setText("TOW");
                                                    FirebaseRecyclerOptions<model> options13 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options13 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu14:
                                                    btn.setText("TRIUMPH");
                                                    FirebaseRecyclerOptions<model> options14 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options14 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu15:
                                                    btn.setText("TROVET");
                                                    FirebaseRecyclerOptions<model> options15 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("egg").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options15 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                default:
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                    popup.show();
                                }
                            });

                            adpter = new myadapter ( options );
                            Dryrecview.setAdapter ( adpter );
                            adpter.startListening ();
                        }

                        else if(fruit.equals("과일")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry2" ).orderByChild("fruit").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener(){
                                public void onClick(View v){
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options );
                                                    Dryrecview.setAdapter ( adpter );

                                                    adpter.startListening ();
                                                    break;
                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options1 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options1 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu2:
                                                    btn.setText("FIRST CHOICE");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options2 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("FISH FOR DOG");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options3 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options4 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options5 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu6:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options6 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu7:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options7 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options7 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu8:
                                                    btn.setText("PINNACLE");
                                                    FirebaseRecyclerOptions<model> options8 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options8 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu9:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options9 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options9);
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu10:
                                                    btn.setText("풀무원");
                                                    FirebaseRecyclerOptions<model> options10 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options10 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu11:
                                                    btn.setText("PUREVITA");
                                                    FirebaseRecyclerOptions<model> options11 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options11 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu12:
                                                    btn.setText("PURINAONE");
                                                    FirebaseRecyclerOptions<model> options12 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options12 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu13:
                                                    btn.setText("TOW");
                                                    FirebaseRecyclerOptions<model> options13 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options13 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu14:
                                                    btn.setText("TRIUMPH");
                                                    FirebaseRecyclerOptions<model> options14 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options14 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu15:
                                                    btn.setText("TROVET");
                                                    FirebaseRecyclerOptions<model> options15 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("fruit").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options15 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                default:
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                    popup.show();
                                }
                            });

                            adpter = new myadapter ( options );
                            Dryrecview.setAdapter ( adpter );
                            adpter.startListening ();
                        }

                        else if(tan.equals("탄수화물")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry2" ).orderByChild("tan").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener(){
                                public void onClick(View v){
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options );
                                                    Dryrecview.setAdapter ( adpter );

                                                    adpter.startListening ();
                                                    break;
                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options1 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options1 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu2:
                                                    btn.setText("FIRST CHOICE");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options2 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("FISH FOR DOG");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options3 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options4 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options5 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu6:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options6 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu7:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options7 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options7 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu8:
                                                    btn.setText("PINNACLE");
                                                    FirebaseRecyclerOptions<model> options8 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options8 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu9:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options9 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options9);
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu10:
                                                    btn.setText("풀무원");
                                                    FirebaseRecyclerOptions<model> options10 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options10 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu11:
                                                    btn.setText("PUREVITA");
                                                    FirebaseRecyclerOptions<model> options11 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options11 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu12:
                                                    btn.setText("PURINAONE");
                                                    FirebaseRecyclerOptions<model> options12 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options12 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu13:
                                                    btn.setText("TOW");
                                                    FirebaseRecyclerOptions<model> options13 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options13 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu14:
                                                    btn.setText("TRIUMPH");
                                                    FirebaseRecyclerOptions<model> options14 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options14 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu15:
                                                    btn.setText("TROVET");
                                                    FirebaseRecyclerOptions<model> options15 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("tan").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options15 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                default:
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                    popup.show();
                                }
                            });

                            adpter = new myadapter ( options );
                            Dryrecview.setAdapter ( adpter );
                            adpter.startListening ();
                        }

                        else if(vege.equals("채소")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry2" ).orderByChild("vege").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener(){
                                public void onClick(View v){
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options );
                                                    Dryrecview.setAdapter ( adpter );

                                                    adpter.startListening ();
                                                    break;
                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options1 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options1 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu2:
                                                    btn.setText("FIRST CHOICE");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options2 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("FISH FOR DOG");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options3 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options4 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options5 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu6:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options6 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu7:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options7 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options7 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu8:
                                                    btn.setText("PINNACLE");
                                                    FirebaseRecyclerOptions<model> options8 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options8 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu9:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options9 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options9);
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu10:
                                                    btn.setText("풀무원");
                                                    FirebaseRecyclerOptions<model> options10 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options10 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu11:
                                                    btn.setText("PUREVITA");
                                                    FirebaseRecyclerOptions<model> options11 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options11 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu12:
                                                    btn.setText("PURINAONE");
                                                    FirebaseRecyclerOptions<model> options12 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options12 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu13:
                                                    btn.setText("TOW");
                                                    FirebaseRecyclerOptions<model> options13 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options13 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu14:
                                                    btn.setText("TRIUMPH");
                                                    FirebaseRecyclerOptions<model> options14 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options14 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu15:
                                                    btn.setText("TROVET");
                                                    FirebaseRecyclerOptions<model> options15 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("vege").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options15 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                default:
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                    popup.show();
                                }
                            });

                            adpter = new myadapter ( options );
                            Dryrecview.setAdapter ( adpter );
                            adpter.startListening ();
                        }

                        else if(bean.equals("콩")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Dry2" ).orderByChild("bean").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener(){
                                public void onClick(View v){
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.brand_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry2").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options );
                                                    Dryrecview.setAdapter ( adpter );

                                                    adpter.startListening ();
                                                    break;
                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options1 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Finiki").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options1 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu2:
                                                    btn.setText("FIRST CHOICE");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Firstchoice").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options2 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("FISH FOR DOG");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Fishfordog").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options3 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Forzaten").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options4 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Gungang").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options5 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu6:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Harim").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options6 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu7:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options7 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Hills").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options7 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu8:
                                                    btn.setText("PINNACLE");
                                                    FirebaseRecyclerOptions<model> options8 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pinnacle").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options8 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu9:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options9 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Proplan").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options9);
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu10:
                                                    btn.setText("풀무원");
                                                    FirebaseRecyclerOptions<model> options10 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Pulmuone").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options10 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu11:
                                                    btn.setText("PUREVITA");
                                                    FirebaseRecyclerOptions<model> options11 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purevita").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options11 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu12:
                                                    btn.setText("PURINAONE");
                                                    FirebaseRecyclerOptions<model> options12 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Purinaone").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options12 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu13:
                                                    btn.setText("TOW");
                                                    FirebaseRecyclerOptions<model> options13 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Tow").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options13 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu14:
                                                    btn.setText("TRIUMPH");
                                                    FirebaseRecyclerOptions<model> options14 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Triumph").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options14 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                case R.id.menu15:
                                                    btn.setText("TROVET");
                                                    FirebaseRecyclerOptions<model> options15 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Dry").child ("Trovet").orderByChild("bean").equalTo("n") , model.class)
                                                                    .build();

                                                    adpter = new myadapter ( options15 );
                                                    Dryrecview.setAdapter ( adpter );
                                                    adpter.startListening ();
                                                    break;

                                                default:
                                                    break;
                                            }
                                            return false;
                                        }
                                    });
                                    popup.show();
                                }
                            });

                            adpter = new myadapter ( options );
                            Dryrecview.setAdapter ( adpter );
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