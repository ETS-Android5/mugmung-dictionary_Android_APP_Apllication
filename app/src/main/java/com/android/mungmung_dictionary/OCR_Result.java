package com.android.mungmung_dictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.jetbrains.annotations.NotNull;

public class OCR_Result extends AppCompatActivity {

    TextView name, info, top1name,top2name, top3name;
    ImageView logo, img1,img2, img3;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference mdatabase=database.getReference();

    FirebaseStorage storage = FirebaseStorage.getInstance("gs://mungmung-e8fb3.appspot.com");
    StorageReference storageRef = storage.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_ocr_result );

        name = findViewById ( R.id.name );
        info = findViewById ( R.id.info );
        top1name = findViewById ( R.id.top1name );
        top2name = findViewById(R.id.top2name);
        top3name = findViewById(R.id.top3name);
        logo = findViewById ( R.id.logo );
        img1 = findViewById(R.id.top1img);
        img2 = findViewById(R.id.top2img);
        img3 = findViewById(R.id.top3img);

        Intent intent = getIntent();
        String brandname = intent.getExtras().getString("brandname");
        String brandname2=intent.getExtras ().getString ( "brandname2" );

        mdatabase.child(brandname).addValueEventListener(new ValueEventListener () {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(snapshot !=null&&snapshot.exists())
                {
                    if(snapshot.getChildren()!=null)
                    {
                        //브랜드 이름
                        String feedbrandname = snapshot.child ( brandname2+"name" ).getValue (String.class);
                        //브랜드 정보
                        String feedinfo = snapshot.child( brandname2+"info" ).getValue (String.class);
                        //브랜드 로고
                        //String feedlogo = snapshot.child ( brandname2+"brand" ).getValue (String.class);

                        storageRef.child("로고").child(brandname2+".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                //이미지 로드 성공시
                                Glide.with(getApplicationContext())
                                        .load(uri)
                                        .into(logo);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                //이미지 로드 실패시
                                Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                            }
                        });

                        //인기사료 top1
                        //  String top_01_profile = snapshot.child( brandname2+"_top_01" ).child("profile").getValue (String.class);
                        storageRef.child(brandname2+"_top").child(brandname2+"01.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                //이미지 로드 성공시
                                Glide.with(getApplicationContext())
                                        .load(uri)
                                        .into(img1);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                //이미지 로드 실패시
                                Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                            }
                        });
                        storageRef.child(brandname2+"_top").child(brandname2+"02.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                //이미지 로드 성공시
                                Glide.with(getApplicationContext())
                                        .load(uri)
                                        .into(img2);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                //이미지 로드 실패시
                                Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                            }
                        });
                        storageRef.child(brandname2+"_top").child(brandname2+"03.jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                //이미지 로드 성공시
                                Glide.with(getApplicationContext())
                                        .load(uri)
                                        .into(img3);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                //이미지 로드 실패시
                                Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                            }
                        });
                        String top_01_name = snapshot.child ( brandname2+"_top_01" ).child ( "name" ).getValue (String.class);
                        String top_02_name = snapshot.child ( brandname2+"_top_02" ).child ( "name" ).getValue (String.class);
                        String top_03_name = snapshot.child ( brandname2+"_top_03" ).child ( "name" ).getValue (String.class);

                        name.setText( feedbrandname );
                        info.setText ( feedinfo );
                        top1name.setText ( top_01_name );
                        top2name.setText ( top_02_name );
                        top3name.setText ( top_03_name );
                    }

                }
            }
            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }

        });
    }
}