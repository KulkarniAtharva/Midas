package dev.atharvakulkarni.midas;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import dev.atharvakulkarni.midas.databinding.PausBinding;

public class paus extends AppCompatActivity
{
    PausBinding pausBinding;
    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        pausBinding = DataBindingUtil.setContentView(this,R.layout.paus);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));


        back = pausBinding.back;

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