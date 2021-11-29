package com.example.logintest.ui.feed;

import android.os.Bundle;

import androidx.annotation.NonNull;
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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class WettabFragment extends Fragment {

    RecyclerView Wetrecview;
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
        View view = inflater.inflate(R.layout.tab_wetfragment, container, false);

        Wetrecview = (RecyclerView)view.findViewById ( R.id.Wetrecview );
        Wetrecview.setLayoutManager ( new LinearLayoutManager( getContext () ) );

        arrayList = new ArrayList<>();//model 객체를 담을 리스트



        Bundle extra = this.getArguments();

        String uid = user.getUid();

        if(extra != null){
            extra=getArguments();
        }

        final Button btn = (Button) view.findViewById(R.id.wetbutton);

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Wet2" ) , model.class)
                        .build();

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                PopupMenu popup = new PopupMenu(getContext(), v);

                popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {

                            case R.id.menu0:
                                btn.setText("전체");
                                FirebaseRecyclerOptions<model> options0 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Wet2"), model.class)
                                                .build();

                                adpter = new myadapter ( options0 );
                                Wetrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu1:
                                btn.setText("FINIKI");
                                FirebaseRecyclerOptions<model> options =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Wet").child ("Finiki"), model.class)
                                                .build();

                                adpter = new myadapter ( options );
                                Wetrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;


                            case R.id.menu2:
                                btn.setText("FORZATEN");
                                FirebaseRecyclerOptions<model> options2 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Wet").child ("Forzaten") , model.class)
                                                .build();

                                adpter = new myadapter ( options2 );
                                Wetrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu3:
                                btn.setText("건강백서");
                                FirebaseRecyclerOptions<model> options3 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Wet").child ("Gungang"), model.class)
                                                .build();

                                adpter = new myadapter ( options3 );
                                Wetrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu4:
                                btn.setText("HARIM");
                                FirebaseRecyclerOptions<model> options4 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Wet").child ("Harim") , model.class)
                                                .build();

                                adpter = new myadapter ( options4 );
                                Wetrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;

                            case R.id.menu5:
                                btn.setText("HILLS");
                                FirebaseRecyclerOptions<model> options5 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Wet").child ("Hills") , model.class)
                                                .build();

                                adpter = new myadapter ( options5 );
                                Wetrecview.setAdapter ( adpter );
                                adpter.startListening ();
                                break;


                            case R.id.menu6:
                                btn.setText("PROPLAN");
                                FirebaseRecyclerOptions<model> options6 =
                                        new FirebaseRecyclerOptions.Builder<model>()
                                                .setQuery( FirebaseDatabase.getInstance ().getReference ().child("Wet").child ("Proplan") , model.class)
                                                .build();

                                adpter = new myadapter ( options6);
                                Wetrecview.setAdapter ( adpter );
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
        Wetrecview.setAdapter ( adpter );

        mDatabase.child("Users").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                if(snapshot != null && snapshot.exists()){
                    if(snapshot.getChildren() != null) {

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

                        if (pork.equals("돼지고기")) {
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("poke").equalTo("n"), model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options0 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("poke").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options0);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Finiki").orderByChild("poke").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu2:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Forzaten").orderByChild("poke").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options2);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Gungang").orderByChild("poke").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options3);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Harim").orderByChild("poke").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options4);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Hills").orderByChild("poke").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options5);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu6:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Proplan").orderByChild("poke").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options6);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
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

                            adpter = new myadapter(options);
                            Wetrecview.setAdapter(adpter);

                            adpter.startListening();
                        }

                        else if(beef.equals("소고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Wet2" ).orderByChild("beef").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options0 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("beef").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options0);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Finiki").orderByChild("beef").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu2:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Forzaten").orderByChild("beef").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options2);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Gungang").orderByChild("beef").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options3);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Harim").orderByChild("beef").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options4);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Hills").orderByChild("beef").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options5);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu6:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Proplan").orderByChild("beef").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options6);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
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

                            adpter = new myadapter(options);
                            Wetrecview.setAdapter(adpter);

                            adpter.startListening();
                        }

                        else if(beef.equals("닭고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Wet2" ).orderByChild("chicken").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options0 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("chicken").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options0);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Finiki").orderByChild("chicken").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu2:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Forzaten").orderByChild("chicken").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options2);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Gungang").orderByChild("chicken").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options3);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Harim").orderByChild("chicken").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options4);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Hills").orderByChild("chicken").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options5);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu6:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Proplan").orderByChild("chicken").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options6);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
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

                            adpter = new myadapter(options);
                            Wetrecview.setAdapter(adpter);

                            adpter.startListening();
                        }

                        else if(beef.equals("토끼고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Wet2" ).orderByChild("rabbit").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options0 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("rabbit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options0);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Finiki").orderByChild("rabbit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu2:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Forzaten").orderByChild("rabbit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options2);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Gungang").orderByChild("rabbit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options3);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Harim").orderByChild("rabbit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options4);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Hills").orderByChild("rabbit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options5);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu6:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Proplan").orderByChild("rabbit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options6);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
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

                            adpter = new myadapter(options);
                            Wetrecview.setAdapter(adpter);

                            adpter.startListening();
                        }

                        else if(beef.equals("물고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Wet2" ).orderByChild("fish").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options0 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("fish").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options0);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Finiki").orderByChild("fish").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu2:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Forzaten").orderByChild("fish").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options2);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Gungang").orderByChild("fish").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options3);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Harim").orderByChild("fish").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options4);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Hills").orderByChild("fish").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options5);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu6:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Proplan").orderByChild("fish").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options6);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
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

                            adpter = new myadapter(options);
                            Wetrecview.setAdapter(adpter);

                            adpter.startListening();
                        }

                        else if(beef.equals("양고기")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Wet2" ).orderByChild("sheep").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options0 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("sheep").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options0);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Finiki").orderByChild("sheep").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu2:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Forzaten").orderByChild("sheep").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options2);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Gungang").orderByChild("sheep").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options3);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Harim").orderByChild("sheep").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options4);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Hills").orderByChild("sheep").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options5);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu6:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Proplan").orderByChild("sheep").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options6);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
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

                            adpter = new myadapter(options);
                            Wetrecview.setAdapter(adpter);

                            adpter.startListening();
                        }

                        else if(beef.equals("유제품")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Wet2" ).orderByChild("egg").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options0 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("egg").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options0);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Finiki").orderByChild("egg").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu2:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Forzaten").orderByChild("egg").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options2);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Gungang").orderByChild("egg").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options3);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Harim").orderByChild("egg").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options4);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Hills").orderByChild("egg").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options5);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu6:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Proplan").orderByChild("egg").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options6);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
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

                            adpter = new myadapter(options);
                            Wetrecview.setAdapter(adpter);

                            adpter.startListening();
                        }

                        else if(beef.equals("탄수화물")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Wet2" ).orderByChild("tan").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options0 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("tan").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options0);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Finiki").orderByChild("tan").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu2:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Forzaten").orderByChild("tan").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options2);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Gungang").orderByChild("tan").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options3);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Harim").orderByChild("beef").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options4);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Hills").orderByChild("tan").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options5);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu6:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Proplan").orderByChild("tan").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options6);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
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

                            adpter = new myadapter(options);
                            Wetrecview.setAdapter(adpter);

                            adpter.startListening();
                        }

                        else if(beef.equals("과일")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Wet2" ).orderByChild("fruit").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options0 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("fruit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options0);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Finiki").orderByChild("fruit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu2:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Forzaten").orderByChild("fruit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options2);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Gungang").orderByChild("fruit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options3);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Harim").orderByChild("fruit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options4);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Hills").orderByChild("fruit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options5);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu6:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Proplan").orderByChild("fruit").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options6);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
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

                            adpter = new myadapter(options);
                            Wetrecview.setAdapter(adpter);

                            adpter.startListening();
                        }

                        else if(beef.equals("채소")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Wet2" ).orderByChild("vege").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options0 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("vege").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options0);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Finiki").orderByChild("vege").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu2:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Forzaten").orderByChild("vege").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options2);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Gungang").orderByChild("vege").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options3);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Harim").orderByChild("vege").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options4);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Hills").orderByChild("vege").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options5);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu6:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Proplan").orderByChild("vege").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options6);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
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

                            adpter = new myadapter(options);
                            Wetrecview.setAdapter(adpter);

                            adpter.startListening();
                        }

                        else if(beef.equals("콩")){
                            FirebaseRecyclerOptions<model> options =
                                    new FirebaseRecyclerOptions.Builder<model>()
                                            .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "Wet2" ).orderByChild("bean").equalTo("n") , model.class)
                                            .build();

                            btn.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    PopupMenu popup = new PopupMenu(getContext(), v);

                                    popup.getMenuInflater().inflate(R.menu.wet_item, popup.getMenu());
                                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem menuItem) {
                                            switch (menuItem.getItemId()) {
                                                case R.id.menu0:
                                                    btn.setText("전체");
                                                    FirebaseRecyclerOptions<model> options0 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet2").orderByChild("bean").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options0);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu1:
                                                    btn.setText("FINIKI");
                                                    FirebaseRecyclerOptions<model> options =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Finiki").orderByChild("bean").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu2:
                                                    btn.setText("FORZATEN");
                                                    FirebaseRecyclerOptions<model> options2 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Forzaten").orderByChild("bean").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options2);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu3:
                                                    btn.setText("건강백서");
                                                    FirebaseRecyclerOptions<model> options3 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Gungang").orderByChild("bean").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options3);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu4:
                                                    btn.setText("HARIM");
                                                    FirebaseRecyclerOptions<model> options4 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Harim").orderByChild("bean").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options4);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;

                                                case R.id.menu5:
                                                    btn.setText("HILLS");
                                                    FirebaseRecyclerOptions<model> options5 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Hills").orderByChild("bean").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options5);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
                                                    break;


                                                case R.id.menu6:
                                                    btn.setText("PROPLAN");
                                                    FirebaseRecyclerOptions<model> options6 =
                                                            new FirebaseRecyclerOptions.Builder<model>()
                                                                    .setQuery(FirebaseDatabase.getInstance().getReference().child("Wet").child("Proplan").orderByChild("bean").equalTo("n"), model.class)
                                                                    .build();

                                                    adpter = new myadapter(options6);
                                                    Wetrecview.setAdapter(adpter);
                                                    adpter.startListening();
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

                            adpter = new myadapter(options);
                            Wetrecview.setAdapter(adpter);

                            adpter.startListening();
                        }


                    }
                }
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

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