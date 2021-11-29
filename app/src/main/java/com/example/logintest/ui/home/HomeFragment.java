package com.example.logintest.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.logintest.BottomActivity;
import com.example.logintest.OCR_Process;
import com.example.logintest.R;
import com.example.logintest.databinding.FragmentHomeBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    RecyclerView recview;
    myadapter3 adpter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    FirebaseAuth mAuth  = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();
    DatabaseReference mDatabase=database.getReference();

    public HomeFragment(){

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView(R.layout.activity_main);

    }

    private void setContentView(int activity_main) {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate( R.layout.fragment_home,container, false);

        Button btn_ocr=(Button)view.findViewById(R.id.btn_ocr);
        btn_ocr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), OCR_Process.class);
                startActivity(intent);
            }
        });

        ImageSlider imageSlider = (ImageSlider) view.findViewById(R.id.slider);

        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://blogfiles.pstatic.net/MjAyMTA2MDdfMTE2/MDAxNjIzMDQyMjc0NTgw.ryUragoo9BWBfsdSoUmFtGXNYanERQt5lX3S-D6n-Nkg.mywS0XO1x_5CbUsC0ueybQnAFoXq5p4QDChTOLfmYU0g.PNG.99j3/bab.png"));
        slideModels.add(new SlideModel("https://blogfiles.pstatic.net/MjAyMTA2MDdfMjU0/MDAxNjIzMDQyMjc0Nzg4.SgWdxebgWf6w1W2nXHvsjgu1yEoBrXjb_jlt-pXDCwog.ALFRKOAt9Did7xUPTRBVa5dH5ezY1M3Nog1FsgVZgHsg.PNG.99j3/gang.png"));
        slideModels.add(new SlideModel("https://blogfiles.pstatic.net/MjAyMTA2MDdfMjg5/MDAxNjIzMDQyMjc0NzYw.5nXPNyLYRWlC8OtpL8PgWLTFWqLjtVx_5ODmd5DqkTQg.8xGqW5CEzblFg9Le-51ZcC4Z2RjJPSBzAf10DzhPYhAg.PNG.99j3/mouth.png"));
        slideModels.add(new SlideModel("https://blogfiles.pstatic.net/MjAyMTA2MDdfMTEx/MDAxNjIzMDQyMjc0NzA0.HM9okXNSsyEjCTVkIncpPTtUpKRJDT-NpKHJL9jzN_Ag.LUfkr7B_1kCsXSdsg-5wegn2939RFqiQBSpTIBuL3ngg.PNG.99j3/nobuy.png"));
        imageSlider.setImageList(slideModels,true);


        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);

        //home recyclerview
        recview = (RecyclerView)view.findViewById ( R.id.Homerecview );
        recview.setLayoutManager(layoutManager);

        FirebaseRecyclerOptions<model3> options =
                new FirebaseRecyclerOptions.Builder<model3>()
                        .setQuery( FirebaseDatabase.getInstance ().getReference ().child ( "BrandPhoto" ) , model3.class)
                        .build();


        adpter = new myadapter3 ( options );
        recview.setAdapter ( adpter );

        return view;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onResume() {
        super.onResume ();
        FragmentActivity activity = getActivity ();
        if(activity != null){
            ((BottomActivity) activity).setActionBarTitle ( "Home" );
        }
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