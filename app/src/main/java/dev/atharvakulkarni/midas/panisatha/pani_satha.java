package dev.atharvakulkarni.midas.panisatha;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import dev.atharvakulkarni.midas.R;
import dev.atharvakulkarni.midas.databinding.PaniSathaBinding;

public class pani_satha extends AppCompatActivity
{
    PaniSathaBinding paniSathaBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        paniSathaBinding = DataBindingUtil.setContentView(this, R.layout.pani_satha);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        paniSathaBinding.cardview1.setOnClickListener(view -> {
            Intent intent = new Intent(pani_satha.this, canal.class);
            startActivity(intent);
        });

        paniSathaBinding.cardview2.setOnClickListener(view -> {
            Intent intent = new Intent(pani_satha.this, prushtabhagavaril.class);
            startActivity(intent);
        });

        paniSathaBinding.cardview3.setOnClickListener(view -> {
            Intent intent = new Intent(pani_satha.this, jalsandharan.class);
            startActivity(intent);
        });

        paniSathaBinding.back.setOnClickListener(view -> finish());
    }
}