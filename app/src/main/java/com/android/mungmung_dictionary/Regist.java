package com.android.mungmung_dictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mungmung_dictionary.ui.My.MyFragment;
import com.android.mungmung_dictionary.ui.feed.DrytabFragment;
import com.android.mungmung_dictionary.ui.feed.FeedFragment;
import com.android.mungmung_dictionary.ui.feed.recfragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;

public class Regist extends AppCompatActivity {

    private Interpreter getTfliteInterpreter(String modelPath) {
        try {
            return new Interpreter(loadModelFile(Regist.this, modelPath));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    public MappedByteBuffer loadModelFile(Activity activity, String modelPath) throws IOException {
        AssetFileDescriptor fileDescriptor = activity.getAssets().openFd(modelPath);
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength); //READ_ONLY
    }

    private static final String TAG = "RegisterActivity";
    EditText mEmailText, mPasswordText, mPasswordcheckText, mName, dogage, dogweight;
    //이메일, 비번, 비번 확인, 이름, 강아지나이, 강아지몸무게
    Button mregisterBtn;
    TextView dogtype;
    ImageView dogimage;
    private FirebaseAuth firebaseAuth;
    CheckBox porkck , beefck, chichkenck, sheepck, rabbitck, fishck, eggck, tanck, fruitck, vegeck, beanck;

    private static final int FROM_ALBUM=1;
    int requestCode ;
    int resultCode;
    Intent data;

    StorageReference storageref,imageref,spaceref;

    Uri imageUri;
    boolean isImageAdded = false;


    DatabaseReference Dataref;
    StorageReference StorageRef;

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);


        //액션 바 등록하기
        //  ActionBar actionBar = getSupportActionBar();
        //  actionBar.setTitle("Create Account");

        //  actionBar.setDisplayHomeAsUpEnabled(true); //뒤로가기버튼
        // actionBar.setDisplayShowHomeEnabled(true); //홈 아이콘

        //파이어베이스 접근 설정
        // user = firebaseAuth.getCurrentUser();
        firebaseAuth =  FirebaseAuth.getInstance();
        //firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        mEmailText = findViewById(R.id.emailEt);
        mPasswordText = findViewById(R.id.passwordEdt);
        mPasswordcheckText = findViewById(R.id.passwordcheckEdt);
        mregisterBtn = findViewById(R.id.register2_btn);
        mName = findViewById(R.id.nameEt);
        dogage = findViewById(R.id.dog_age);
        dogweight = findViewById(R.id.dog_weight);
        dogimage = findViewById(R.id.imageView);
        dogtype = findViewById(R.id.txttype);

        porkck = (CheckBox)findViewById(R.id.porkck);
        beefck = (CheckBox)findViewById(R.id.beefck);
        chichkenck = (CheckBox)findViewById(R.id.chickenck);
        sheepck = (CheckBox)findViewById(R.id.checkBox4);
        rabbitck = (CheckBox)findViewById(R.id.checkBox5);
        fishck = (CheckBox)findViewById(R.id.checkBox6);
        eggck = (CheckBox)findViewById(R.id.checkBox7);
        tanck = (CheckBox)findViewById(R.id.checkBox8);
        fruitck = (CheckBox)findViewById(R.id.checkBox9);
        vegeck =(CheckBox)findViewById(R.id.checkBox10);
        beanck = (CheckBox)findViewById(R.id.checkBox11);

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        Dataref  = FirebaseDatabase.getInstance().getReference("Users");
        StorageRef = FirebaseStorage.getInstance().getReference().child("dogImage");

        //   FirebaseUser user = firebaseAuth.getCurrentUser();

        //파이어베이스 user 로 접글

        layout = findViewById(R.id.layout);

        dogimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent();
                intent.setType("image/*");                      // 이미지만
                intent.setAction(Intent.ACTION_GET_CONTENT);    // 카메라(ACTION_IMAGE_CAPTURE)
                startActivityForResult(intent, FROM_ALBUM);

            }
        });

        //가입버튼 클릭리스너   -->  firebase에 데이터를 저장한다.
        mregisterBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                final String imageName = dogtype.getText ().toString ();
                // if(isImageAdded != false && imageName!=null) {
                // uploadImage(imageName);
                // }

                //가입 정보 가져오기
                final String email = mEmailText.getText().toString().trim();
                String pwd = mPasswordText.getText().toString().trim();
                String pwdcheck = mPasswordcheckText.getText().toString().trim();


                if(pwd.equals(pwdcheck)) {
                    Log.d(TAG, "등록 버튼 " + email + " , " + pwd);
                    final ProgressDialog mDialog = new ProgressDialog(Regist.this);
                    mDialog.setMessage("가입중입니다...");
                    mDialog.show();

                    //파이어베이스에 신규계정 등록하기
                    firebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Regist.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            //가입 성공시
                            if (task.isSuccessful()) {
                                mDialog.dismiss();

                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                String email = user.getEmail();
                                String uid = user.getUid();
                                String name = mName.getText().toString().trim();
                                String age =dogage.getText().toString().trim();
                                String weight=dogweight.getText().toString().trim();
                                String type=dogtype.getText().toString().trim();


                                // String check1, check2, check3;
                                String pork = "", beef="", chicken="",rabbit="", fish="", sheep="", egg="", tan="", fruit="", vege="", bean="" ;
                                if(porkck.isChecked()){
                                    pork = porkck.getText().toString();
                                }
                                if(beefck.isChecked()){
                                    beef=beefck.getText().toString();
                                }
                                if(chichkenck.isChecked()){
                                    chicken=chichkenck.getText().toString();
                                }
                                if(sheepck.isChecked()){
                                    sheep=sheepck.getText().toString();
                                }
                                if(rabbitck.isChecked()){
                                    rabbit=rabbitck.getText().toString();
                                }
                                if(fishck.isChecked()){
                                    fish=fishck.getText().toString();
                                }
                                if(eggck.isChecked()){
                                    egg=eggck.getText().toString();
                                }
                                if(tanck.isChecked()){
                                    tan=tanck.getText().toString();
                                }
                                if(fruitck.isChecked()){
                                    fruit=fruitck.getText().toString();
                                }
                                if(vegeck.isChecked()){
                                    vege=vegeck.getText().toString();
                                }
                                if(beanck.isChecked()){
                                    bean=beanck.getText().toString();
                                }

                                //해쉬맵 테이블을 파이어베이스 데이터베이스에 저장
                                HashMap<Object,String> hashMap = new HashMap<>();

                                hashMap.put("uid",uid);
                                hashMap.put("email",email);
                                hashMap.put("name",name);
                                hashMap.put("age",age);
                                hashMap.put("weight",weight);
                                hashMap.put("type",type);
                                hashMap.put("pork",pork);
                                hashMap.put("beef",beef);
                                hashMap.put("chicken",chicken);
                                hashMap.put("rabbit",rabbit);
                                hashMap.put("fish",fish);
                                hashMap.put("sheep",sheep);
                                hashMap.put("egg",egg);
                                hashMap.put("tan",tan);
                                hashMap.put("fruit",fruit);
                                hashMap.put("vege",vege);
                                hashMap.put("bean",bean);

                                //fragment로 데이터 넘겨줌
                                MyFragment fragment = new MyFragment();
                                recfragment regfragment = new recfragment();
                                FeedFragment feedFragment = new FeedFragment();
                                DrytabFragment drytabFragment = new DrytabFragment();

                                Bundle bundle = new Bundle();
                                bundle.putString("email",email);
                                bundle.putString("dog_age",age);
                                bundle.putString("dog_weight",weight);
                                bundle.putString("dog_type",type);
                                bundle.putString("uid",uid);
                                bundle.putString("pork",pork);
                                bundle.putString("beef",beef);
                                bundle.putString("chicken",chicken);
                                bundle.putString("rabbit",rabbit);
                                bundle.putString("fish",fish);
                                bundle.putString("sheep",sheep);
                                bundle.putString("egg",egg);
                                bundle.putString("tan",tan);
                                bundle.putString("fruit",fruit);
                                bundle.putString("vege",vege);
                                bundle.putString("bean",bean);
                                fragment.setArguments(bundle);
                                regfragment.setArguments(bundle);
                                feedFragment.setArguments(bundle);
                                drytabFragment.setArguments(bundle);

                                String key = Dataref.push().getKey();
                                StorageRef.child(uid + ".jpg").putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                        StorageRef.child(uid + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                            @Override
                                            public void onSuccess(Uri uri) {
                                                //HashMap hashMap = new HashMap();
                                                hashMap.put("dogtype", imageName);
                                                hashMap.put("ImageUrl", uri.toString());

                                                //밑 두줄 fragment로 데이터 넘겨줌
                                                bundle.putString("dog_image",uri.toString());
                                                fragment.setArguments(bundle);

                                                Dataref.child(uid).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Toast.makeText(Regist.this, "Data Successfully Uploaded!", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference reference = database.getReference("Users");
                                reference.child(uid).setValue(hashMap);

                                //가입이 이루어져을시 가입 화면을 빠져나감.
                                Intent intent = new Intent(Regist.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(Regist.this, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();

                            } else {
                                mDialog.dismiss();
                                Toast.makeText(Regist.this, "이미 존재하는 아이디 입니다.", Toast.LENGTH_SHORT).show();
                                return;  //해당 메소드 진행을 멈추고 빠져나감.

                            }

                        }
                    });

                    //비밀번호 오류시
                }else{

                    Toast.makeText(Regist.this, "비밀번호가 틀렸습니다. 다시 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }

    /*  private void uploadImage(final String imageName) {
          String key = Dataref.push().getKey();
          StorageRef.child(key + ".jpg").putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
              @Override
              public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                  StorageRef.child(key + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                      @Override
                      public void onSuccess(Uri uri) {
                          HashMap hashMap = new HashMap();
                          hashMap.put("CarName", imageName);
                          hashMap.put("ImageUrl", uri.toString());

                          Dataref.child(uid).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                              @Override
                              public void onSuccess(Void aVoid) {
                                  Toast.makeText(Regist.this, "Data Successfully Uploaded!", Toast.LENGTH_SHORT).show();
                              }
                          });
                      }
                  });
              }
          });
      }*/
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 카메라를 다루지 않기 때문에 앨범 상수에 대해서 성공한 경우에 대해서만 처리
        super.onActivityResult(requestCode, resultCode, data);
        //if (requestCode != FROM_ALBUM || resultCode != RESULT_OK){
        if(requestCode ==FROM_ALBUM && data!=null){
            imageUri = data.getData();
            isImageAdded = true;
            dogimage.setImageURI(imageUri);
        }


        float[][][][] input = new float[1][64][64][3];
        float[][] output = new float[1][15]; //종류 3개

        int i;


        try {
            int batchNum = 0;
            InputStream buf = getContentResolver().openInputStream(data.getData());
            Bitmap bitmap = BitmapFactory.decodeStream(buf);
            buf.close();




            // x,y 최댓값 사진 크기에 따라 달라짐 (조절 해줘야함)
            for (int x = 0; x < 64; x++) {
                for (int y = 0; y < 64; y++) {
                    int pixel = bitmap.getPixel(x, y);
                    input[batchNum][x][y][0] = Color.red(pixel) / 1.0f;
                    input[batchNum][x][y][1] = Color.green(pixel) / 1.0f;
                    input[batchNum][x][y][2] = Color.blue(pixel) / 1.0f;
                }
            }

            // tflite 이름
            Interpreter lite = getTfliteInterpreter("model10.tflite");
            lite.run(input, output);

            //이미지 뷰에 선택한 사진 띄우기
            dogimage.setScaleType(ImageView.ScaleType.FIT_XY);
            dogimage.setImageBitmap(bitmap);

        } catch (IOException e) {
            e.printStackTrace();
        }

         for (i = 0; i < 15; i++)
            if (output[0][i] * 100 > 50) {
                if (i == 0) {
                    dogtype.setText(String.format("비글"));
                } else if (i == 1) {
                    dogtype.setText(String.format("비숑"));
                } else if (i ==2 ){
                    dogtype.setText(String.format("치와와"));
                } else if (i ==3 ){
                    dogtype.setText(String.format("닥스훈트"));
                   // dogtype.setText(String.format(" %.5f", output[0][0] * 100));
                } else if (i ==4 ){
                    dogtype.setText(String.format("달마시안"));
                } else if (i ==5 ){
                    dogtype.setText(String.format("도베르만"));
                } else if (i ==6 ){
                    dogtype.setText(String.format("골든 리트리버"));
                } else if (i==7){
                    dogtype.setText(String.format("시베리안 허스키"));
                } else if (i==8){
                    dogtype.setText(String.format("말티즈"));
                } else if (i==9){
                    dogtype.setText(String.format("포메라니안"));
                } else if (i==10){
                    dogtype.setText(String.format("푸들"));
                } else if (i==11){
                    dogtype.setText(String.format("퍼그"));
                } else if (i==12){
                    dogtype.setText(String.format("슈나우저"));
                } else if (i==13){
                    dogtype.setText(String.format("시바견"));
                } else {
                    dogtype.setText(String.format("웰시코기"));
                }
            } else
                continue;


    }

    public boolean onSupportNavigateUp(){
        onBackPressed();; // 뒤로가기 버튼이 눌렸을시
        return super.onSupportNavigateUp(); // 뒤로가기 버튼
    }


}