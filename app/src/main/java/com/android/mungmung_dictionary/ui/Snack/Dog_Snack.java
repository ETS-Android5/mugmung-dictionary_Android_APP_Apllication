package com.android.mungmung_dictionary.ui.Snack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.mungmung_dictionary.Function_List;
import com.android.mungmung_dictionary.R;
import com.android.mungmung_dictionary.databinding.UiSnackBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class Dog_Snack extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private UiSnackBinding binding;

    private RecyclerView recyclerView;
    ExpandableListView listMain;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate( R.layout.ui_snack,container, false);



// 부모리스트와 자식리스트를 선언
        ArrayList<HashMap<String,String>> groupData = new ArrayList<> ();
        ArrayList<ArrayList<HashMap<String, String>>> childData = new ArrayList<> ();


//부모 리스트에 들어갈 요소들을 추가
        HashMap<String,String> groupA = new HashMap<>();
        groupA.put("group","두부고구마볼");
        HashMap<String,String> groupB = new HashMap<>();
        groupB.put("group","단호박 요거트빵");
        HashMap<String,String> groupC = new HashMap<>();
        groupC.put("group","당근 시금치 쿠키");
        HashMap<String,String> groupD = new HashMap<>();
        groupD.put("group","사과 & 바나나칩");
        HashMap<String,String> groupE = new HashMap<>();
        groupE.put("group","닭가슴살 토마토 스튜");
        HashMap<String,String> groupF = new HashMap<>();
        groupF.put("group","애플치킨완자");
        HashMap<String,String> groupG = new HashMap<>();
        groupG.put("group","치킨 요거트 샐러드");
        HashMap<String,String> groupH = new HashMap<>();
        groupH.put("group","닭가슴살 야채쿠키");
        HashMap<String,String> groupI = new HashMap<>();
        groupI.put("group","두부버거");
        HashMap<String,String> groupJ = new HashMap<>();
        groupJ.put("group","소고기 감자 계란국");
        HashMap<String,String> groupK = new HashMap<>();
        groupK.put("group","과일 우유껌");
        HashMap<String,String> groupL = new HashMap<>();
        groupL.put("group","오리고기 단호박 스프");
        HashMap<String,String> groupM = new HashMap<>();
        groupM.put("group","병아리콩 스테이크");
        HashMap<String,String> groupN = new HashMap<>();
        groupN.put("group","돼지 불고기");
        HashMap<String,String> groupO = new HashMap<>();
        groupO.put("group","연어된장죽");

        groupData.add(groupA);
        groupData.add(groupB);
        groupData.add(groupC);
        groupData.add(groupD);
        groupData.add(groupE);
        groupData.add(groupF);
        groupData.add(groupG);
        groupData.add(groupH);
        groupData.add(groupI);
        groupData.add(groupJ);
        groupData.add(groupK);
        groupData.add(groupL);
        groupData.add(groupM);
        groupData.add(groupN);
        groupData.add(groupO);


//자식리스트에 들어갈 요소들 추가

        ArrayList<HashMap<String, String>> childListA = new ArrayList<> ();

        HashMap<String,String> childAA = new HashMap<>();
        childAA.put("name", "1. 두부를 반으로 잘라 끓는 물에 2분 정도 데칩니다. 그런 다음 물을 새로 갈아 이 과정을 한 번 더 반복합니다. 건져낸 두부는 숟가락을 이용해 으깨줍니다.");
        childListA.add(childAA);

        HashMap<String,String> childAB = new HashMap<>();
        childAB.put("name", "2. 고구마를 익힌 다음 숟가락을 이용해 으깹니다");
        childListA.add(childAB);

        HashMap<String,String> childAC = new HashMap<>();
        childAC.put("name", "3. 파프리카를 잘게 다져줍니다");
        childListA.add(childAC);

        HashMap<String,String> childAD = new HashMap<>();
        childAD.put("name", "4. 검은깨는 반려견이 소화하기 쉽도록 믹서로 갈아줍니다.");
        childListA.add(childAD);

        HashMap<String,String> childAE = new HashMap<>();
              childAE.put("name", "5. 볼에 두부와 고구마, 파프리카, 검은깨, 달걀을 넣고 잘 섞어 반죽을 만듭니다.(반죽이 묽어지지 않도록 하기 위해 달걀 노른자만 넣어줍니다)");
        childListA.add(childAE);

        HashMap<String,String> childAF = new HashMap<>();
        childAF.put("name", "6. 반죽을 지름 2.5cm ~ 3cm의 크기로 둥글게 빚은 다음 180도 오븐에서 20분, 뒤집어 10분 동안 구우면 두부 고구마 볼이 완성됩니다.");
        childListA.add(childAF);

        childData.add(childListA);



        ArrayList<HashMap<String,String>> childListB = new ArrayList<>();

        HashMap<String, String> childBA = new HashMap<>();
         childBA.put("name", "1. 단호박을 전자레인지에 2분정도 돌려서 8등분으로 잘라줍니다.");
        childListB.add(childBA);

        HashMap<String, String> childBB = new HashMap<>();
        childBB.put("name", "2. 잘라둔 단호박의 씨를 제거합니다");
        childListB.add(childBB);

        HashMap<String, String> childBC = new HashMap<>();
        childBC.put("name", "3. 씨를 제거한 단호박을 찜기에 쩌준 후 껍질을 제거해줍니다.(단호박을 냄비 뚜겅을 닫고 13분 정도 쪄주면 부드럽게 잘 익습니다)");
        childListB.add(childBC);

        HashMap<String, String> childBD = new HashMap<>();
        childBD.put("name", "4. 단호박을 쪄서 껍질을 제거해주고 볼에 담은 후 부드럽게 으깨줍니다.");
        childListB.add(childBD);

        HashMap<String, String> childBE = new HashMap<>();
        childBE.put("name", "5. 으깬 단호박을 달걀물에 섞은 후 전자레인지에 5분 돌려주면 단호박빵이 완성됩니다.");
        childListB.add(childBE);

        HashMap<String, String> childBF = new HashMap<>();
        childBF.put("name", "6. 완성된 단호박 빵은 강아지가 먹기 좋은 크기로 잘라주고 볼이나 강아지 그릇에 담아줍니다.");
        childListB.add(childBF);

        HashMap<String, String> childBG = new HashMap<>();
        childBG.put("name", "7. 플레인 요거트가 잘 스며들도록 골고루 부어주고 블루베리를 올려 플레이팅을 해주면 완성됩니다.");
        childListB.add(childBG);
        childData.add(childListB);



        ArrayList<HashMap<String,String>>childListC = new ArrayList<>();

        HashMap<String,String> childCA = new HashMap<>();
        childCA.put("name", "1. 당근을 깨끗이 씻고 뿌리 끝과 줄기 부분을 칼로 살짝 잘라 준 후 껍질을 벗겨줍니다.");
        childListC.add(childCA);

        HashMap<String,String> childCB = new HashMap<>();
        childCB.put("name", "2. 잘게 다지기 위해 당근을 먼저 채썰어주고 뜨거운 물에 살짝 데쳐줍니다.");
        childListC.add(childCB);

        HashMap<String,String> childCC = new HashMap<>();
        childCC.put("name", "3. 마찬가지로 시금치도 살짝 데쳐줍니다.(시금치는 오래 데치면 영양소가 쉽게 파괴되니 살짝 담궜다 꺼낸다는 느낌으로 데쳐줍니다)");
        childListC.add(childCC);

        HashMap<String,String> childCD = new HashMap<>();
        childCD.put("name", "4. 채소의 물기를 꽉 짜고 다져줍니다. 물기를 꽉 짜주지 않으면 반죽 시 질어지니 물기를 최대한 짜주는게 좋습니다.");
        childListC.add(childCD);

        HashMap<String,String> childCE = new HashMap<>();
        childCE.put("name", "5. 당근과 쌀가루를 1:1 비율로 넣습니다.");
        childListC.add(childCE);

        HashMap<String,String> childCF = new HashMap<>();
        childCF.put("name", "6. 달걀물을 만들어 절반만 넣어주고 꿀은 1티스푼 계량하여 넣어준 뒤 반죽하시면 됩니다.");
        childListC.add(childCF);

        HashMap<String,String> childCG = new HashMap<>();
        childCG.put("name", "7. 시금치도 당근과 같은 방법으로 반죽해서 준비해주세요.");
        childListC.add(childCG);

        HashMap<String,String> childCH = new HashMap<>();
        childCH.put("name", "8. 종이호일을 깔고 당근 반죽과 시금치 반죽을 이용해 당근 시금치 쿠키를 빚어주고 잘 빚어진 쿠키를 전자레인지에서 딱딱헤 질 떼까지 구어주면 완성됩니다.");
        childListC.add(childCH);
        childData.add(childListC);



        ArrayList<HashMap<String,String>>childListD = new ArrayList<>();

        HashMap<String,String> childDA = new HashMap<>();
        childDA.put("name", "1. 베이킹소다 한 숟가락(밥 숟가락 기준)을 녹인 물에 사과를 5분 정도 담그고 물을 새로 갈아 식초 한 숟가락을 넣고 10분 정도 사과를 담아 세척합니다.");
        childListD.add(childDA);

        HashMap<String,String> childDB = new HashMap<>();
        childDB.put("name", "2. 사과를 흐르는 물에 한 번 더 씻은 다음 꼭지와 씨를 제거하고 5mm 두께로 썰어줍니다.");
        childListD.add(childDB);

        HashMap<String,String> childDC = new HashMap<>();
        childDC.put("name", "3. 바나나를 물에 깨끗이 씻어 껍질을 벗기고 사과와 같은 두께로 썹니다.(바나나 껍질엔 농약이 많이 묻어있으므로 알맹이를 만지기 전 세척을 하고 꼭지 부분을 1cm 정도 잘라내고 사용하는 것이 좋습니다)");
        childListD.add(childDC);

        HashMap<String,String> childDD = new HashMap<>();
        childDD.put("name", "4. 트레이 위에 사과와 바나나를 넣고 70도에서 4시간, 60도에서 3시간 동안 건조하고, 과일이 골고루 건조되도록 중간에 뒤집어줍니다.");
        childListD.add(childDD);

        childData.add(childListD);



        ArrayList<HashMap<String,String>>childListE = new ArrayList<>();

        HashMap<String,String> childEA = new HashMap<>();
        childEA.put("name", "1. 쌀을 40분정도 미리 불려줍니다.");
        childListE.add(childEA);

        HashMap<String,String> childEB = new HashMap<>();
        childEB.put("name", "2. 닭가슴살(150g)을 먹기 좋은 크기로 썰고 살짝 삶아줍니다.");
        childListE.add(childEB);

        HashMap<String,String> childEC = new HashMap<>();
        childEC.put("name", "3. 애호박(40g), 당근(45g), 감자(45g)을 먹기 좋은 크기로 썰어줍니다.");
        childListE.add(childEC);

        HashMap<String,String> childED = new HashMap<>();
        childED.put("name", "4. 올리브오일(10ml)과 불린 쌀을 볶아줍니다.");
        childListE.add(childED);

        HashMap<String,String> childEE = new HashMap<>();
        childEE.put("name", "5. 모든 재료를 넣고 재료가 잠글 때까지 물을 충분히 넣어주고 20분 정도 끓여줍니다.(끓이다가 마지막에 소금 한 꼬집을 넣어줍니다)");
        childListE.add(childEE);

        HashMap<String,String> childEF = new HashMap<>();
        childEF.put("name", "6. 파슬리를 넣어 마무리 합니다.(컬리파슬리는 가급적 사용하지 않는 것이 좋습니다)");
        childListE.add(childEF);
        childData.add(childListE);



        ArrayList<HashMap<String,String>>childListF = new ArrayList<>();

        HashMap<String,String> childFA = new HashMap<>();
        childFA.put("name", "1. 사과(1/6개)를 적당한 크기로 자르고 전자레인지에 1분 정도 돌려줍니다.");
        childListF.add(childFA);

        HashMap<String,String> childFB = new HashMap<>();
        childFB.put("name", "2. 사과(1/6개), 당근(10g), 파프리카(10g), 닭가슴살(200g)을 믹서기에 넣어줍니다.(믹서기가 없으면 모든 재료를 잘게 다져줍니다)");
        childListF.add(childFB);

        HashMap<String,String> childFC = new HashMap<>();
        childFC.put("name", "3. 반죽을 동그랗게 빚어줍니다.");
        childListF.add(childFC);

        HashMap<String,String> childFD = new HashMap<>();
        childFD.put("name", "4. 올리브오일(0.5T)를 후라이팬에 두른 후 사과가 들어있어서 잘 탈 수 있으니 약불에 뒤집어가며 노릇하게 구워줍니다.");
        childListF.add(childFD);
        childData.add(childListF);



        ArrayList<HashMap<String,String>>childListG = new ArrayList<>();

        HashMap<String,String> childGA = new HashMap<>();

        childGA.put("name", "1. 껍질을 벗긴 고구마(40g)와 닭가슴살(200g)을 먹기 좋은 크기로 잘라줍니다.");
        childListG.add(childGA);

        HashMap<String,String> childGB = new HashMap<>();
        childGB.put("name", "2. 닭가슴살과 고구마를 끓인 물에 삶아줍니다.");
        childListG.add(childGB);

        HashMap<String,String> childGC = new HashMap<>();
        childGC.put("name", "3. 파프리카(20g)를 먹기 좋은 크기로 잘라줍니다.");
        childListG.add(childGC);

        HashMap<String,String> childGD = new HashMap<>();
        childGD.put("name", "4. 블루베리(8개)를 1/4 크기로 잘라줍니다.");
        childListG.add(childGD);

        HashMap<String,String> childGE = new HashMap<>();
        childGE.put("name", "5. 삶은 닭가슴살과 고구마를 잘 식혀준 후 모든 재료를 볼에 담아 무가당 요거트와 잘 섞어주면 완성입니다.");
        childListG.add(childGE);
        childData.add(childListG);



        ArrayList<HashMap<String,String>>childListH = new ArrayList<>();

        HashMap<String,String> childHA = new HashMap<>();
        childHA.put("name", "1. 닭가슴살(50g)을 믹서기로 갈아줍니다.");
        childListH.add(childHA);

        HashMap<String,String> childHB = new HashMap<>();
        childHB.put("name", "2. 브로콜리(10g), 빨간 파프리카(10g)을 잘게 다져줍니다.");
        childListH.add(childHB);

        HashMap<String,String> childHC = new HashMap<>();
        childHC.put("name", "3. 달걀 노른자(20g)와 올리브 오일(15g)을 섞어줍니다.");
        childListH.add(childHC);

        HashMap<String,String> childHD = new HashMap<>();
        childHD.put("name", "4. 쌀가루(50g)를 여러번 채에 쳐주고 쌀가루에 모든 재료를 넣은 후 재료들을 잘 섞어줍니다.");
        childListH.add(childHD);

        HashMap<String,String> childHE = new HashMap<>();
        childHE.put("name", "5. 반죽을 먹기 좋은 크기로 동그랗게 빚은 후 180도로 예열시킨 오븐에서 20~25분 구워주면 완성입니다.");
        childListH.add(childHE);

        childData.add(childListH);



        ArrayList<HashMap<String,String>>childListI = new ArrayList<>();

        HashMap<String,String> childIA = new HashMap<>();
        childIA.put("name", "1. 두부(250g)를 키친타올로 물기를 빼줍니다.");
        childListI.add(childIA);

        HashMap<String,String> childIB = new HashMap<>();
        childIB.put("name", "2. 가로 세로 4cm 크기로 자른 두부를 바싹 구워줍니다.");
        childListI.add(childIB);

        HashMap<String,String> childIC = new HashMap<>();
        childIC.put("name", "3. 껍질을 벗긴 고구마(75g)를 시간 단축을 위해 잘려주고 익혀줍니다.");
        childListI.add(childIC);

        HashMap<String,String> childID = new HashMap<>();
        childID.put("name", "4. 다 익힌 고구마를 건져서 으깬 후 작게 다진 당근(10g), 노란 파프리카(10g)와 섞어줍니다.");
        childListI.add(childID);

        HashMap<String,String> childIE = new HashMap<>();
        childIE.put("name", "5. 두부 사이에 작게 다진 채소와 으깬 고구마를 섞은 것을 넣고 샌드위치 모양으로 만들어줍니다.");
        childListI.add(childIE);
        childData.add(childListI);



        ArrayList<HashMap<String,String>>childListJ = new ArrayList<>();

        HashMap<String,String> childJA = new HashMap<>();
        childJA.put("name", "1. 멸치(2마리 10g)를 물에 씻어 충분히 염분을 제거해줍니다.");
        childListJ.add(childJA);

        HashMap<String,String> childJB = new HashMap<>();
        childJB.put("name", "2. 감자(10g), 당근(30g), 감자(30g)을 적당한 크기로 다져줍니다.");
        childListJ.add(childJB);

        HashMap<String,String> childJC = new HashMap<>();
        childJC.put("name", "3. 소고기 우둔살(100g)을 다지듯 잘게 썰어주고, 계란 1개(20g)를 풀어줍니다.(흰자도 사용 가능합니다.)");
        childListJ.add(childJC);

        HashMap<String,String> childJD = new HashMap<>();
        childJD.put("name", "4. 냄비에 물 400ml을 붓고 씻은 멸치와 다시마 1장을 넣고 끓인 뒤 5분 뒤에 건더기를 건져줍니다.");
        childListJ.add(childJD);

        HashMap<String,String> childJE = new HashMap<>();
        childJE.put("name", "5. 만들어진 육수에 소고기와 야채들을 넣고 익을 때까지 끓여줍니다.");
        childListJ.add(childJE);

        HashMap<String,String> childJF = new HashMap<>();
        childJF.put("name", "6. 풀어놨던 달걀을 국에 넣어주면 완성입니다.");
        childListJ.add(childJF);
        childData.add(childListJ);



        ArrayList<HashMap<String,String>>childListK = new ArrayList<>();

        HashMap<String,String> childKA = new HashMap<>();
        childKA.put("name", "1. 락토프리 우유 한팩(930ml)과 한천가루(15g)가 잘 섞이도록 저어준 후 30분 간 불려줍니다.");
        childListK.add(childKA);

        HashMap<String,String> childKB = new HashMap<>();
        childKB.put("name", "2. 불려주는 동안 딸기, 한라봉, 키위, 블루베리, 바나나 등 다양한 과일을 미리 손질하여 용기에 깔아둡니다.");
        childListK.add(childKB);

        HashMap<String,String> childKC = new HashMap<>();
        childKC.put("name", "3. 불려둔 락토프리 우유와 한천가루를 약불로 맞춘 후 20분간 저어주며 끓여줍니다.");
        childListK.add(childKC);

        HashMap<String,String> childKD = new HashMap<>();
        childKD.put("name", "4. 끓인 우유를 과일이 담긴 용기에 부어줍니다.");
        childListK.add(childKD);

        HashMap<String,String> childKE = new HashMap<>();
        childKE.put("name", "5. 1시간 이상 냉장 보관을 해주면 푸딩이 완성됩니다. (노견의 경우 푸딩으로 급여해주는 것이 좋습니다.)");
        childListK.add(childKE);

        HashMap<String,String> childKF = new HashMap<>();
        childKF.put("name", "6. 먹기 좋은 크기로 잘라 70도에서 6시간 건조합니다.");
        childListK.add(childKF);

        childData.add(childListK);

        ArrayList<HashMap<String,String>>childListL = new ArrayList<>();

        HashMap<String,String> childLA = new HashMap<>();
        childLA.put("name", "1. 껍질을 벗긴 단호박(300g)을 작게 썰어 물어 넣고 익힌다.");
        childListL.add(childLA);

        HashMap<String,String> childLB = new HashMap<>();
        childLB.put("name", "2. 단호박이 익히면 물을 버린 후 락토프리 우유(200ml)를 넣고 핸드믹서로 갈아준 뒤 끓인다.");
        childListL.add(childLB);

        HashMap<String,String> childLC = new HashMap<>();
        childLC.put("name", "3. 오리 안심(100g)은 작게 다져서 팬에서 볶아준다.");
        childListL.add(childLC);

        HashMap<String,String> childLD = new HashMap<>();
        childLD.put("name", "4. 단호박을 간 우유에 오리안심을 넣고 한 번 더 끓여주고, 먹기 직전 코코넛 분말을 첨가한다(20g)");
        childListL.add(childLD);

        childData.add(childListL);



        ArrayList<HashMap<String,String>>childListM = new ArrayList<>();

        HashMap<String,String> childMA = new HashMap<>();
        childMA.put("name", "1. 병아리콩(100g)을 12시간 정도 물에 불려 압력밥솥으로 익혀준다.");
        childListM.add(childMA);

        HashMap<String,String> childMB = new HashMap<>();
        childMB.put("name", "2. 고구마(30g), 당근(20g)은 스틱 모양으로 썰어 준비하고, 브로콜리(20g)은 한 입 크기로 준비한다.");
        childListM.add(childMB);

        HashMap<String,String> childMC = new HashMap<>();
        childMC.put("name", "3. 두부(50g)는 끓는 물에 염분을 제거 후 불린 병아리콩과 같이 으깬 후 섞어준다.");
        childListM.add(childMC);

        HashMap<String,String> childMD = new HashMap<>();
        childMD.put("name", "4. 섞은 두부와 병아리콩에 달걀 노른자 1개와 쌀가루(50g)을 넣고 잘 치댄 다음 스테이크 모양으로 빚어준다.");
        childListM.add(childMD);

        HashMap<String,String> childME = new HashMap<>();
        childME.put("name", "5. 팬에 기름을 두르고 스틱 모양의 고구마, 당근 그리고 한 입 크기의 브로콜리를 넣고 익혀준다.");
        childListM.add(childME);

        HashMap<String,String> childMF = new HashMap<>();
        childMF.put("name", "6. 만들어둔 병아리콩 스테이크를 구워준다.");
        childListM.add(childMF);

        childData.add(childListM);



        ArrayList<HashMap<String,String>>childListN = new ArrayList<>();

        HashMap<String,String> childNA = new HashMap<>();
        childNA.put("name", "1. 돼지넓적다리살(30g)과 무(5g)는 한 입 크기로 썰고 당근(10g)과 민가닥버섯(5g)은 잘게 다진다.");
        childListN.add(childNA);

        HashMap<String,String> childNB = new HashMap<>();
        childNB.put("name", "2. 곤약(10g)은 끓는 물에 넣어 특유의 냄새를 없앤 뒤 잘게 썰어준다.");
        childListN.add(childNB);

        HashMap<String,String> childNC = new HashMap<>();
        childNC.put("name", "3. 육수에 무, 당근을 넣고 불에 올린 후, 끓어오르면 돼지고기를 넣고 계속 끓인다.");
        childListN.add(childNC);

        HashMap<String,String> childND = new HashMap<>();
        childND.put("name", "4. 채소가 모두 부드러워지면 민가닥버섯과 곤약을 넣는다.");
        childListN.add(childND);

        HashMap<String,String> childNE = new HashMap<>();
        childNE.put("name", "5. 민가닥버섯이 익으면 불을 끄고 사람 체온 정도로 식힌다.");
        childListN.add(childNE);

        HashMap<String,String> childNF = new HashMap<>();
        childNF.put("name", "6. 사료는 평소 주던 양의 75% 정도만 그릇에 담아 식힌 음식을 국물째로 붓는다.");
        childListN.add(childNF);

        childData.add(childListN);



        ArrayList<HashMap<String,String>>childListO = new ArrayList<>();

        HashMap<String,String> childOA = new HashMap<>();
        childOA.put("name", "1. 생연어(100g), 무(20g), 고구마(20g)은 한 입 크기로, 소송채(20g) 또는 청경채(20g)와 잎새버섯(10g)은 잘게 썬다.");
        childListO.add(childOA);

        HashMap<String,String> childOB = new HashMap<>();
        childOB.put("name", "2. 냄비에 육수, 연어, 채소류와 버섯, 흰쌀밥(1/4 공기)를 넣고 거품을 걷어내면서 모든 채소와 버섯이 부드러워질 때까지 중불에서 끓인다.");
        childListO.add(childOB);

        HashMap<String,String> childOC = new HashMap<>();
        childOC.put("name", "3. 불을 끄고 된장(1/8 작은 술)을 풀어서 넣은 후 생강가루를 더한 다음 5분 정도 더 끓인다.");
        childListO.add(childOC);

        childData.add(childListO);




        listMain = (ExpandableListView) view.findViewById ( R.id.expandableListView );

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                getContext(), groupData,android.R.layout.simple_expandable_list_item_1,
                new String[] {"group"},new int[] {android.R.id.text1},
                childData, android.R.layout.simple_expandable_list_item_2,new String[] {"name","group"},new int[]
                {android.R.id.text1,android.R.id.text2});

//ExpandableListView에 생성한 Adapter를 설정한다.
        ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        listView.setAdapter(adapter);

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
            ((Function_List) activity).setActionBarTitle ( "Food" );
        }
    }
}