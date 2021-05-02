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
    LinearLayout linearLayout1,linearLayout2,linearLayout3;
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
        linearLayout1 = homeBinding.linearlayout1;
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

        village.setText(UserModel.getVillage());

        return view;
    }
}