package dev.atharvakulkarni.midas;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.atharvakulkarni.midas.databinding.HomeBinding;
import dev.atharvakulkarni.midas.interfaces.HamburgerDrawer;

public class Home extends Fragment
{
    HomeBinding homeBinding;
    TextView village;

    Map<String, Object> map = new HashMap<String, Object>();
    List<String> input = new ArrayList<>();
    List<String> output = new ArrayList<>();
    //ImageButton left_arrow,right_arrow;
    LinearLayout linearLayout1,linearLayout2,linearLayout3;
    FirebaseFirestore db;
    TextView sarasari_paus, paus_2020, evaporation_rate, reduce_area, increase_area, vaparlel_pani, rabbi_sathi, ekun_shillak;
    ImageButton hamburger;
    DrawerLayout drawerLayout;

    HamburgerDrawer hamburgerDrawer;

    public Home(HamburgerDrawer hdrawer)
    {
        this.hamburgerDrawer = hdrawer;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.home, container, false);
        View view = homeBinding.getRoot();

        village = homeBinding.village;
        //left_arrow = homeBinding.leftArrow;
       // right_arrow = homeBinding.rightArrow;
        linearLayout1 = homeBinding.linearlayout1;
        linearLayout2 = homeBinding.linearlayout2;
        linearLayout3 = homeBinding.linearlayout3;
        sarasari_paus = homeBinding.sarasariPaus;
        paus_2020 = homeBinding.paus2020;
       // evaporation_rate = homeBinding.reduceArea;
       // reduce_area = homeBinding.increaseArea;
       // increase_area = homeBinding.increaseArea;
        vaparlel_pani = homeBinding.vaparlelPani;
        rabbi_sathi = homeBinding.rabbisathi;
        ekun_shillak = homeBinding.ekunShillak;

        hamburger = homeBinding.hamburgerH;

        hamburger.setOnClickListener(view1 -> {
            hamburgerDrawer.onHamburgerClick();
        });

        db = FirebaseFirestore.getInstance();

        /*left_arrow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (linearLayout1.getVisibility() == View.VISIBLE)
                {
                    linearLayout1.setVisibility(View.GONE);
                    linearLayout2.setVisibility(View.GONE);
                    linearLayout3.setVisibility(View.VISIBLE);
                }
                else if (linearLayout2.getVisibility() == View.VISIBLE)
                {
                    linearLayout1.setVisibility(View.VISIBLE);
                    linearLayout2.setVisibility(View.GONE);
                    linearLayout3.setVisibility(View.GONE);
                }
                else if (linearLayout3.getVisibility() == View.VISIBLE)
                {
                    linearLayout1.setVisibility(View.GONE);
                    linearLayout2.setVisibility(View.VISIBLE);
                    linearLayout3.setVisibility(View.GONE);
                }
            }
        });

        right_arrow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (linearLayout1.getVisibility() == View.VISIBLE)
                {
                    linearLayout1.setVisibility(View.GONE);
                    linearLayout2.setVisibility(View.VISIBLE);
                    linearLayout3.setVisibility(View.GONE);
                }
                else if (linearLayout2.getVisibility() == View.VISIBLE)
                {
                    linearLayout1.setVisibility(View.GONE);
                    linearLayout2.setVisibility(View.GONE);
                    linearLayout3.setVisibility(View.VISIBLE);
                }
                else if (linearLayout3.getVisibility() == View.VISIBLE)
                {
                    linearLayout1.setVisibility(View.VISIBLE);
                    linearLayout2.setVisibility(View.GONE);
                    linearLayout3.setVisibility(View.GONE);
                }
            }
        });*/

        village.setText(UserModel.getVillage());

        DocumentReference docRef = db.collection(UserModel.getVillage()).document("होम");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task)
            {
                if (task.isSuccessful())
                {
                    DocumentSnapshot document = task.getResult();
                    //if (document.exists())
                    //{
                    Log.d("TAG", "DocumentSnapshot data: " + document.getData());

                    // map.putAll(Objects.requireNonNull(document.getData()));

                    sarasari_paus.setText(document.getString("सरासरी_पाऊस"));
                    paus_2020.setText(document.getString("पाऊस_२०२०"));
                   // evaporation_rate.setText(document.getString("सरासरी पाऊस"));
                   // reduce_area.setText(document.getString("सरासरी पाऊस"));
                   // increase_area.setText(document.getString("सरासरी पाऊस"));
                    vaparlel_pani.setText(document.getString("वापरलेल_पाणी"));
                    rabbi_sathi.setText(document.getString("रब्बी_साठी_उपलब्ध_पाणी"));
                    ekun_shillak.setText(document.getString("एकूण_शिल्लक_पाणी"));
                }
                else
                {
                    Log.d("TAG", "get failed with ", task.getException());
                }
            }
        });
        return view;
    }
}