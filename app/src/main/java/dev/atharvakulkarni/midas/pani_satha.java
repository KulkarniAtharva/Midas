package dev.atharvakulkarni.midas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import com.google.firebase.firestore.FirebaseFirestore;

import dev.atharvakulkarni.midas.databinding.PaniSathaBinding;
import dev.atharvakulkarni.midas.panisatha.jalsandharan;
import dev.atharvakulkarni.midas.panisatha.prushtabhagavaril;

public class pani_satha extends AppCompatActivity
{
    PaniSathaBinding paniSathaBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        paniSathaBinding = DataBindingUtil.setContentView(this,R.layout.pani_satha);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        paniSathaBinding.cardview1.setOnClickListener(view -> {
            Intent intent = new Intent(pani_satha.this, prushtabhagavaril.class);
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