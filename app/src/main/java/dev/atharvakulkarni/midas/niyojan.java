package dev.atharvakulkarni.midas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import dev.atharvakulkarni.midas.databinding.NiyojanBinding;
import dev.atharvakulkarni.midas.interfaces.HamburgerDrawer;

public class niyojan extends Fragment
{
    NiyojanBinding niyojanBinding;
    TextView title;
    CardView cardView1,cardView2;
    ImageButton hamburger;

    HamburgerDrawer hamburgerDrawer;

    public niyojan(HamburgerDrawer hdrawer)
    {
        this.hamburgerDrawer = hdrawer;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        niyojanBinding = DataBindingUtil.inflate(inflater, R.layout.niyojan, container, false);
        View view = niyojanBinding.getRoot();

        //title = homeBinding.title;

        cardView1 = niyojanBinding.cardview1;
        cardView2 = niyojanBinding.cardview2;
        hamburger = niyojanBinding.hamburgerN;

        cardView1.setOnClickListener(view13 -> {
            Intent intent = new Intent(getContext(),apekshit_sudharna.class);
            startActivity(intent);
        });

        cardView2.setOnClickListener(view12 -> {
            Intent intent = new Intent(getContext(),summary.class);
            startActivity(intent);
        });

        hamburger.setOnClickListener(view1 -> {
            hamburgerDrawer.onHamburgerClick();
        });


        return view;
    }
}
