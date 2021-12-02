package com.android.mungmung_dictionary;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;


public class OCR_Process extends AppCompatActivity {

    EditText mResultEt;
    ImageView mPreviewIv;

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference mdatabase=database.getReference();

    private static final int CAMERA_REQUEST_CODE = 200;
    private static final int STORAGE_REQUEST_CODE = 400;
    private static final int IMAGE_PICK_GALLERY_CODE = 1000;
    private static final int IMAGE_PICK_CAMERA_CODE = 1001;

    String cameraPermission[];
    String storagePermission[];

    Uri image_uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr_process);
        ActionBar actionBar = getSupportActionBar();

        mResultEt = findViewById(R.id.resultEt);
        mPreviewIv = findViewById(R.id.imageIV);


        //camera permission
        cameraPermission = new String[]{Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};

        storagePermission = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.addImages){
            showImageImportDialog();
        }
        if (id == R.id.settings){
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showImageImportDialog() {

        String[] items = {"Camera", "Gallery"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Select Image");
        dialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    //camera option clicked
                    if (!checkCameraPermission()){
                        //camera permission not allowed, request it
                        requestCameraPermission();
                    }
                    else{
                        //permission allowed, take pictures
                        pickCamera();
                    }
                }
                if(which == 1){
                    if (!checkStoragePermission()){
                        //camera permission not allowed, request it
                        requestStoragePermission();
                    }
                    else{
                        //permission allowed, take pictures
                        pickGallery();
                    }
                }
            }
        });
        dialog.create().show(); // show dialog
    }

    private void pickCamera() {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "NewPic");
        values.put(MediaStore.Images.Media.DESCRIPTION, "Image To text");
        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraintent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        startActivityForResult(cameraintent, IMAGE_PICK_CAMERA_CODE);
    }

    private void pickGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_GALLERY_CODE);
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(this, storagePermission, STORAGE_REQUEST_CODE);
    }

    private boolean checkStoragePermission() {
        return false;
    }

    private void requestCameraPermission() {
        ActivityCompat.requestPermissions(this, cameraPermission, CAMERA_REQUEST_CODE);
    }

    private boolean checkCameraPermission() {
        boolean result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) == (PackageManager.PERMISSION_GRANTED);
        boolean result1 = ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == (PackageManager.PERMISSION_GRANTED);
        return result && result1;
    }

    //handle permission result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case CAMERA_REQUEST_CODE:
                if (grantResults.length > 0) {
                    boolean cameraAccepted = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean writeStorageAccepted = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    if (cameraAccepted && writeStorageAccepted) {
                        pickCamera();
                    } else {
                        Toast.makeText(this, "permssion denied", Toast.LENGTH_SHORT).show();
                    }
                }
                break;

            case STORAGE_REQUEST_CODE:
                if (grantResults.length > 0) {
                    boolean writeStorageAccepted = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    if (writeStorageAccepted) {
                        pickGallery();
                    } else {
                        Toast.makeText(this, "permssion denied", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
        ;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_PICK_GALLERY_CODE) {
                CropImage.activity(data.getData())
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(this);
            }
            if (requestCode == IMAGE_PICK_CAMERA_CODE) {
                CropImage.activity(image_uri)
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .start(this);
            }
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                mPreviewIv.setImageURI(resultUri);

                BitmapDrawable bitmapDrawable = (BitmapDrawable) mPreviewIv.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();

                TextRecognizer recognizer = new TextRecognizer.Builder(getApplicationContext()).build();

                if (!recognizer.isOperational()) {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                } else {
                    Frame frame = new Frame.Builder().setBitmap(bitmap).build();
                    SparseArray<TextBlock> items = recognizer.detect(frame);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < items.size(); i++) {
                        TextBlock myItem = items.valueAt(i);
                        sb.append(myItem.getValue());
                        sb.append("\n");
                    }
                    mResultEt.setText(sb.toString());

                    if (sb.toString().contains("FINIKI") || sb.toString().contains("FlNlKl") || sb.toString().contains("F1N1K1")
                            || sb.toString().contains("FINIK") || sb.toString().contains("FlNlK") || sb.toString().contains("F1N1K")
                            || sb.toString().contains("FINI") || sb.toString().contains("FlNl") || sb.toString().contains("F1N1")
                            || sb.toString().contains("EINIKI") || sb.toString().contains("ElNlKl") || sb.toString().contains("E1N1K1")) {

                        String brandname="Finikiinfo";
                        String barandname2="finiki";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );


                    }


                    if (sb.toString().contains("STCHOICE") || sb.toString().contains("STCHOlCE") || sb.toString().contains("STCHO1CE")
                            || sb.toString().contains("TCHOICE") || sb.toString().contains("TCHOlCE") || sb.toString().contains("TCHO1CE ")
                            || sb.toString().contains("STHOICE") || sb.toString().contains("STHOlCE") || sb.toString().contains("STHO1CE")
                            || sb.toString().contains("CHOICE") || sb.toString().contains("CHOlCE") || sb.toString().contains("CHO1CE")
                            || sb.toString().contains("1CHOICE") || sb.toString().contains("1CHOlCE") || sb.toString().contains("1CHO1CE")
                            || sb.toString().contains("ICHOICE") || sb.toString().contains("ICHOlCE") || sb.toString().contains("ICHO1CE")
                            || sb.toString().contains("lCHOICE") || sb.toString().contains("lCHOlCE") || sb.toString().contains("lCHO1CE")
                            || sb.toString().contains("EHOICE") || sb.toString().contains("EHOlCE") || sb.toString().contains("EHO1CE")
                            || sb.toString().contains("CHoICE") || sb.toString().contains("CHolCE") || sb.toString().contains("CHo1CE")) {

                        String brandname="Firstchoiceinfo";
                        String barandname2="firstchoice";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("FISH4DOGs") || sb.toString().contains("FlSH4DOGs") || sb.toString().contains("F1SH4DOGs")
                            || sb.toString().contains("FISH4DOGS") || sb.toString().contains("FlSH4DOGS") || sb.toString().contains("F1SH4DOGS ")
                            || sb.toString().contains("FISH4D0Gs") || sb.toString().contains("FlSH4D0Gs") || sb.toString().contains("F1SH4D0Gs")
                            || sb.toString().contains("FIsh4DOGs") || sb.toString().contains("Flsh4DOGs") || sb.toString().contains("F1sh4DOGs")
                            || sb.toString().contains("FIsh4D0Gs") || sb.toString().contains("Flsh4D0Gs") || sb.toString().contains("F1sh4D0Gs")
                            || sb.toString().contains("FISH4D0GS") || sb.toString().contains("FlSH4D0GS") || sb.toString().contains("F1SH4D0GS")
                            || sb.toString().contains("FISH4 DOGS") || sb.toString().contains("FlSH4 DOGS") || sb.toString().contains("F1SH4 DOGS")
                            || sb.toString().contains("FISH4 DOGs") || sb.toString().contains("FlSH4 DOGs") || sb.toString().contains("F1SH4 DOGs")
                            || sb.toString().contains("FISH4 D0GS") || sb.toString().contains("FlSH4 D0GS") || sb.toString().contains("F1SH4 D0GS")
                            || sb.toString().contains("FISH4 D0Gs") || sb.toString().contains("FlSH4 D0Gs") || sb.toString().contains("F1SH4 D0Gs")
                            || sb.toString().contains("FISH 4 DOGs") || sb.toString().contains("FlSH 4 DOGs") || sb.toString().contains("F1SH 4 DOGs")
                            || sb.toString().contains("FISH 4 D0Gs") || sb.toString().contains("FlSH 4 D0Gs") || sb.toString().contains("F1SH 4 D0Gs")
                            || sb.toString().contains("FISH 4 DOGS") || sb.toString().contains("FlSH 4 DOGS") || sb.toString().contains("F1SH 4 DOGS")) {

                        String brandname="Fishfordogeinfo";
                        String barandname2="fishfordog";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("FORZA1") || sb.toString().contains("FORZAI") || sb.toString().contains("FORZAl")
                            || sb.toString().contains("RCZA") || sb.toString().contains("FOZA") || sb.toString().contains("F0ZA")
                            || sb.toString().contains("FCZA") || sb.toString().contains("FOZ") || sb.toString().contains("F0Z")
                            || sb.toString().contains("FoAA") || sb.toString().contains("FORZA") || sb.toString().contains("F0RZA")
                            || sb.toString().contains("FCZ") || sb.toString().contains("FCRZA") || sb.toString().contains("FOEZ")
                            || sb.toString().contains("FCIZA") || sb.toString().contains("FClZA") || sb.toString().contains("FC1ZA")
                            || sb.toString().contains("RORZA") || sb.toString().contains("R0RZA") || sb.toString().contains("F0EZ")) {

                        String brandname="Forzateniinfo";
                        String barandname2="forzaten";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("Harim") || sb.toString().contains("Harim Pet Food The Real") || sb.toString().contains("The Real")
                            || sb.toString().contains("Real") || sb.toString().contains("Rea1") || sb.toString().contains("ReaI")
                            || sb.toString().contains("The ReaI") || sb.toString().contains("The Rea1") || sb.toString().contains("Harim Pet Food The ReaI")
                            || sb.toString().contains("Harim Pet Food The Rea1")) {

                        String brandname="Hariminfo";
                        String barandname2="harim";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("Hills") || sb.toString().contains("HiIIs") || sb.toString().contains("Hi11s")
                            || sb.toString().contains("HiIls") || sb.toString().contains("HiI1s") || sb.toString().contains("HilIs")
                            || sb.toString().contains("Hil1s") || sb.toString().contains("Hi1Is") || sb.toString().contains("Hi1ls")) {

                        String brandname="Hillsinfo";
                        String barandname2="hills";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("PINNACL") || sb.toString().contains("PlNNACL") || sb.toString().contains("P1NNACL")
                            || sb.toString().contains("PINNACLEE") || sb.toString().contains("PlNNACLEE") || sb.toString().contains("P1NNACLEE")
                            || sb.toString().contains("PINNACLE") || sb.toString().contains("PlNNACLE") || sb.toString().contains("P1NNACLE")) {

                        String brandname="Pinnacleinfo";
                        String barandname2="pinnacle";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("PRO PLAN") || sb.toString().contains("PR0 PLAN")
                            || sb.toString().contains("PROPLAN") || sb.toString().contains("PR0PLAN")
                        /*|| sb.toString().contains("PURINA") || sb.toString().contains("PURlNA") || sb.toString().contains("PUR1NA")*/) {

                        String brandname="Proplaninfo";
                        String barandname2="proplan";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("ulmuone") || sb.toString().contains("uImuone") || sb.toString().contains("u1muone")
                            || sb.toString().contains("Pulmuone") || sb.toString().contains("PuImuone") || sb.toString().contains("Pu1muone")
                            || sb.toString().contains("Pulmudne") || sb.toString().contains("PuImudne") || sb.toString().contains("Pu1mudne")
                            || sb.toString().contains("Polemuone") || sb.toString().contains("PoIemuone") || sb.toString().contains("Po1emuone")
                            || sb.toString().contains("Polemudne") || sb.toString().contains("PoIemudne") || sb.toString().contains("Po1emudne")
                            || sb.toString().contains("amio") || sb.toString().contains("am") || sb.toString().contains("am&o") || sb.toString().contains("am.o")) {

                        String brandname="Pulmuoneinfo";
                        String barandname2="pulmuone";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("PureVita") || sb.toString().contains("Purelita") || sb.toString().contains("PureIita")
                            || sb.toString().contains("Pure1ita") || sb.toString().contains("rurevita") || sb.toString().contains("rerelita")
                            || sb.toString().contains("rereIita") || sb.toString().contains("rere1ita") || sb.toString().contains("Kve ta")
                            || sb.toString().contains("Kove ta") || sb.toString().contains("Foveia") || sb.toString().contains("F0veia")
                            || sb.toString().contains("veita") || sb.toString().contains("veuiTa") || sb.toString().contains("Fuverlit")
                            || sb.toString().contains("Fuver1it") || sb.toString().contains("FuverIit") || sb.toString().contains("Forealita")
                            || sb.toString().contains("ForeaIita") || sb.toString().contains("Forea1ita") || sb.toString().contains("rurerita")
                            || sb.toString().contains("oveaita") || sb.toString().contains("orerlita") || sb.toString().contains("orerIita")
                            || sb.toString().contains("orer1ita") || sb.toString().contains("oreita") || sb.toString().contains("Furerlita")
                            || sb.toString().contains("FurerIita") || sb.toString().contains("Furer1ita") || sb.toString().contains("Poverta")
                            || sb.toString().contains("Pve a") || sb.toString().contains("Povesia") || sb.toString().contains("Poveia")
                            || sb.toString().contains("Pve") || sb.toString().contains("Pveta") || sb.toString().contains("Pverta")
                            || sb.toString().contains("Poverlia") || sb.toString().contains("PoverIia") || sb.toString().contains("Pover1ia")
                            || sb.toString().contains("Pveri4") || sb.toString().contains("KoveUita") || sb.toString().contains("Fovelta")
                            || sb.toString().contains("FoveIta") || sb.toString().contains("Fove1ta") || sb.toString().contains("PoveFta")
                            || sb.toString().contains("oveUita") || sb.toString().contains("oveta") || sb.toString().contains("velita")
                            || sb.toString().contains("Preita") || sb.toString().contains("Purerlita") || sb.toString().contains("PurerIita")
                            || sb.toString().contains("Purer1ita") || sb.toString().contains("horerto") || sb.toString().contains("rorert")
                            || sb.toString().contains("urera") || sb.toString().contains("overlita") || sb.toString().contains("overIita")
                            || sb.toString().contains("over1ita") || sb.toString().contains("Porer") || sb.toString().contains("Poverfa")
                            || sb.toString().contains("Poveairt") || sb.toString().contains("Poverita") || sb.toString().contains("rures a")
                            || sb.toString().contains("ove") || sb.toString().contains("rove") || sb.toString().contains("uve ta")
                            || sb.toString().contains("uveUta")) {

                        String brandname="Purevitainfo";
                        String barandname2="purevita";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("PURINA") || sb.toString().contains("PURlNA") || sb.toString().contains("PUR1NA")) {

                        String brandname="Purinaoneinfo";
                        String barandname2="purinaone";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("Taste of the Wild") || sb.toString().contains("Taste of the WiId") || sb.toString().contains("Taste of the Wi1d")) {

                        String brandname="Towinfo";
                        String barandname2="tow";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("Triumph") || sb.toString().contains("Truiumphk") || sb.toString().contains("uiunp")
                            || sb.toString().contains("Fiumph") || sb.toString().contains("Fuumph") || sb.toString().contains("uumph")
                            || sb.toString().contains("iumph") || sb.toString().contains("riunpl") || sb.toString().contains("riunpI")
                            || sb.toString().contains("Triunph") || sb.toString().contains("EVOLVE") || sb.toString().contains("EV0LVE")) {

                        String brandname="Triumphinfo";
                        String barandname2="triumph";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }


                    if (sb.toString().contains("TROVET") || sb.toString().contains("TR0VET") || sb.toString().contains("VET")) {

                        String brandname="Trovetinfo";
                        String barandname2="trovet";
                        Intent intent = new Intent(OCR_Process.this, OCR_Result.class);
                        intent.putExtra("brandname", brandname);
                        intent.putExtra ("brandname2",barandname2 );
                        startActivity ( intent );

                    }



                }



            }
        }
    }
}