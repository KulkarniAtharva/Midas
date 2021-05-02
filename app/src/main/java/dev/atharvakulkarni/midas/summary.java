package dev.atharvakulkarni.midas;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import dev.atharvakulkarni.midas.databinding.SummaryBinding;

public class summary extends AppCompatActivity
{
    SummaryBinding summaryBinding;
    private float[] yData = {100f};
    private String[] xData = {"Mitch"};
    private static String TAG = "MainActivity";
    CardView cardView1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        summaryBinding= DataBindingUtil.setContentView(this,R.layout.summary);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        cardView1 = summaryBinding.cardview1;

        cardView1.setOnClickListener(view -> finish());

        summaryBinding.back.setOnClickListener(view -> finish());
    }
}