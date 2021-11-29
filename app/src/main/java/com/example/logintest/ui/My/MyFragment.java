package com.example.logintest.ui.My;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.logintest.BottomActivity;
import com.example.logintest.R;
import com.example.logintest.Regist;
import com.example.logintest.databinding.FragmentMyBinding;
import com.example.logintest.ui.feed.recfragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentMyBinding binding;

    ImageView dogimage;
    TextView dogtype, dogage, email, dogweight, name, carecheck, mungname;

    FirebaseAuth mAuth  = FirebaseAuth.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabase=database.getReference(),dataref,call;

    DatabaseReference mmDatabase = database.getReference().child("Users");

    FirebaseUser user = mAuth.getCurrentUser();

    DatabaseReference Dataref;
    StorageReference StorageRef;

    FrameLayout layout;

    FirebaseStorage storage = FirebaseStorage.getInstance("gs://mungmung-e8fb3.appspot.com");
    StorageReference storageRef = storage.getReference();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_my,container,false);

        dogage = rootview.findViewById(R.id.dog_age);
        dogtype = rootview.findViewById(R.id.txttype);
        dogweight = rootview.findViewById(R.id.dog_weight);
        name = rootview.findViewById(R.id.nameEt);
        dogimage = rootview.findViewById(R.id.imageView);
        email = rootview.findViewById(R.id.emailEt);
        carecheck = rootview.findViewById(R.id.care);
        mungname = rootview.findViewById(R.id.mungname);
        Dataref  = FirebaseDatabase.getInstance().getReference("Users");
        String uid = user.getUid();

        Bundle extra = this.getArguments();


        if(extra != null) {
            extra = getArguments();
            String title = extra.getString("type");
            String age = extra.getString("age");
            String time = extra.getString("weight");
            String dogname = extra.getString("name");
            // String email2 = extra.getString("email");
            String email2 = user.getEmail();
            String check = extra.getString("pork");
            String check2 = extra.getString("bean");
            String check3 = extra.getString("beef");
            String check4 = extra.getString("chicken");
            String check5 = extra.getString("egg");
            String check6 = extra.getString("fish");
            String check7 = extra.getString("fruit");
            String check8= extra.getString("rabbit");
            String check9 = extra.getString("sheep");
            String check10 = extra.getString("tan");
            String check11 = extra.getString("vege");



            dogage.setText(age);
            dogweight.setText(time);
            dogtype.setText(title);
            email.setText(email2);
            carecheck.setText(check);
            name.setText(dogname);

            Toast.makeText(getActivity(),title+age+time,Toast.LENGTH_SHORT).show();
        }

        mDatabase.child("Users").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                if (snapshot != null && snapshot.exists()) {
                    //Log.d(TAG, "Current data: " + snapshot.getData());

                    if (snapshot.getChildren() != null) {
                        //for (DataSnapshot snap : snapshot.getChildren()) {{
                        String breed = snapshot.child("type").getValue(String.class);
                        dogtype.setText(breed);
                        String age = snapshot.child("age").getValue(String.class);
                        dogage.setText(age);
                        String weight = snapshot.child("weight").getValue(String.class);
                        dogweight.setText(weight);
                        String email3 = snapshot.child("email").getValue(String.class);
                        email.setText(email3);
                        String check = snapshot.child("pork").getValue(String.class);
                        String check2 = snapshot.child("bean").getValue(String.class);
                        String check3 = snapshot.child("beef").getValue(String.class);
                        String check4 = snapshot.child("chicken").getValue(String.class);
                        String check5 = snapshot.child("egg").getValue(String.class);
                        String check6 = snapshot.child("fish").getValue(String.class);
                        String check7 = snapshot.child("fruit").getValue(String.class);
                        String check8 = snapshot.child("rabbit").getValue(String.class);
                        String check9 = snapshot.child("sheep").getValue(String.class);
                        String check10 = snapshot.child("tan").getValue(String.class);
                        String check11= snapshot.child("vege").getValue(String.class);
                        if(check.equals("돼지고기")){
                            carecheck.setText(check);
                        } else if (check2.equals("콩")){
                            carecheck.setText(check2);
                        }
                        else if (check3.equals("소고기")){
                            carecheck.setText(check3);
                        }
                        else if (check4.equals("닭고기")){
                            carecheck.setText(check4);
                        }
                        else if (check5.equals("유제품")){
                            carecheck.setText(check5);
                        }
                        else if (check6.equals("물고기")){
                            carecheck.setText(check6);
                        }
                        else if (check7.equals("과일")){
                            carecheck.setText(check7);
                        }
                        else if (check8.equals("토끼고기")){
                            carecheck.setText(check8);
                        }
                        else if (check9.equals("양고기")){
                            carecheck.setText(check9);
                        }
                        else if (check10.equals("탄수화물")){
                            carecheck.setText(check10);
                        }
                        else if (check11.equals("채소")){
                            carecheck.setText(check11);
                        }

                        String name2 = snapshot.child("name").getValue(String.class);
                        name.setText(name2);
                        mungname.setText(name2);

                        if(breed.equals("골든 리트리버")){

                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.goldenchacracter,contentsLayout,true);

                        }
                        else if(breed.equals("말티즈")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.maltisecharac,contentsLayout,true);
                        }
                        else if(breed.equals("비숑")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.bishongcharac,contentsLayout,true);
                        }
                        else if(breed.equals("치와와")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.chiwawacharac,contentsLayout,true);
                        }
                        else if(breed.equals("닥스훈트")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.dakshuntcharac,contentsLayout,true);
                        }
                        else if(breed.equals("달마시안")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.dalmasiancharac,contentsLayout,true);
                        }
                        else if(breed.equals("도베르만")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.dobermancharac,contentsLayout,true);
                        }
                        else if(breed.equals("시베리안 허스키")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.huskeycharac,contentsLayout,true);
                        }
                        else if(breed.equals("포메라니안")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.pomecharac,contentsLayout,true);
                        }
                        else if(breed.equals("푸들")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.poodlecharac,contentsLayout,true);
                        }
                        else if(breed.equals("퍼그")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.pugcharac,contentsLayout,true);
                        }
                        else if(breed.equals("슈나우저")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.shunauzercharac,contentsLayout,true);
                        }
                        else if(breed.equals("시바견")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.sibacharac,contentsLayout,true);
                        }
                        else if(breed.equals("웰시코기")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.kogicharac,contentsLayout,true);
                        }
                        else if(breed.equals("비글")){
                            LinearLayout contentsLayout = (LinearLayout) rootview.findViewById(R.id.layoutppp);
                            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            inflater.inflate(R.layout.beaglecharac,contentsLayout,true);
                        }

                        storageRef.child("dogImage").child(uid+".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                //이미지 로드 성공시

                                Glide.with(getContext())
                                        .load(uri)
                                        .into(dogimage);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                //이미지 로드 실패시
                                Toast.makeText(getContext(), "실패", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                } else{
                    dogtype.setText("등록정보없음");
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });



        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume ();
        FragmentActivity activity = getActivity ();
        if(activity != null){
            ((BottomActivity) activity).setActionBarTitle ( "My" );
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}