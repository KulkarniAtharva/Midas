package dev.atharvakulkarni.midas;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import dev.atharvakulkarni.midas.databinding.GhetleJanarePikBinding;

public class ghetle_janare_pik extends AppCompatActivity
{
    GhetleJanarePikBinding ghetleJanarePikBinding;
    private float[] yData = {100f};
    private String[] xData = {"Mitch"};
    private static String TAG = "MainActivity";
    CardView cardView1;
    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ghetleJanarePikBinding= DataBindingUtil.setContentView(this,R.layout.ghetle_janare_pik);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        cardView1 = ghetleJanarePikBinding.cardview1;

        cardView1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });

        back = ghetleJanarePikBinding.back;

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }
}