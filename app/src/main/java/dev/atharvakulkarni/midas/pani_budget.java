package dev.atharvakulkarni.midas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import dev.atharvakulkarni.midas.databinding.PaniBudgetBinding;
import dev.atharvakulkarni.midas.interfaces.HamburgerDrawer;

public class pani_budget extends Fragment
{
    PaniBudgetBinding paniBudgetBinding;
    GridLayout gridLayout;
    TextView pausamule_uplabdh, ekun_vaparlel, ekun_rabbi, paus, pani_satha, gharguti_vapar, pikanchi_garaj;
    ImageButton hamburger;

    HamburgerDrawer hamburgerDrawer;

    public pani_budget(HamburgerDrawer hdrawer)
    {
        this.hamburgerDrawer = hdrawer;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        paniBudgetBinding = DataBindingUtil.inflate(inflater, R.layout.pani_budget, container, false);
        View view = paniBudgetBinding.getRoot();

        //title = homeBinding.title;

        gridLayout = paniBudgetBinding.grid;
        pausamule_uplabdh = paniBudgetBinding.pausamuleuplabdh;
        ekun_vaparlel = paniBudgetBinding.ekunvaparlel;
        ekun_rabbi = paniBudgetBinding.ekunRabbi;
        paus = paniBudgetBinding.paus;
        pani_satha = paniBudgetBinding.paniSatha;
        gharguti_vapar = paniBudgetBinding.ghargutiVapar;
        pikanchi_garaj = paniBudgetBinding.pikanchiGaraj;
        hamburger = paniBudgetBinding.hamburgerPb;

        setSingleEvent(gridLayout);

        hamburger.setOnClickListener(view1 -> {
            hamburgerDrawer.onHamburgerClick();
        });

        return view;
    }

    private void setSingleEvent(GridLayout gridLayout)
    {
        for(int i=0;i<gridLayout.getChildCount();i++)
        {
            CardView cardView = (CardView)gridLayout.getChildAt(i);
            final int fin = i;
            cardView.setOnClickListener(v -> {
                if(fin == 0)
                    paus();
                else if(fin == 1)
                    pani_satha();
                else if(fin == 2)
                    gharguti_vapar();
                else if(fin == 3)
                    pikanchi_garaj();
            });
        }
    }

    void paus()
    {
        Intent intent = new Intent(getContext(), paus.class);
        startActivity(intent);
        //intent.putExtra("Uname",uname);
        // finish();
    }

    void gharguti_vapar()
    {
        Intent intent = new Intent(getContext(), gharguti_vapar.class);
        startActivity(intent);
        //intent.putExtra("Uname",uname);
        // finish();
    }

    void pani_satha()
    {
        Intent intent = new Intent(getContext(), dev.atharvakulkarni.midas.panisatha.pani_satha.class);
        startActivity(intent);
        //intent.putExtra("Uname",uname);
        // finish();
    }

    void pikanchi_garaj()
    {
        Intent intent = new Intent(getContext(), dev.atharvakulkarni.midas.pikanchi_garaj.pikanchi_garaj.class);
        startActivityForResult(intent, 2);
        //intent.putExtra("Uname",uname);
        // finish();
    }

    // Call Back method  to get the Message form other Activity
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            // String message=data.getStringExtra("MESSAGE");
            // textView1.setText(message);

            //  Toast.makeText(this, "ask", Toast.LENGTH_SHORT).show();

           // Intent intent=new Intent();
           // getActivity().setResult(2,intent);
           // getActivity().finish();//finishing activity

            Toast.makeText(getActivity(), "yoooo", Toast.LENGTH_SHORT).show();


            //FragmentManager manager = getSupportFragmentManager();
            //manager.beginTransaction().replace(R.id.framelayout,fragment).commit();
        }
    }
}