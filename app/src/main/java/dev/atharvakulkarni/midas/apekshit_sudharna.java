package dev.atharvakulkarni.midas;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import dev.atharvakulkarni.midas.databinding.ApekshitSudharnaBinding;

public class apekshit_sudharna extends AppCompatActivity
{
    ApekshitSudharnaBinding apekshitSudharnaBinding;
    private float[] yData1 = {100f};
    private float[] yData2 = {70.70f,30.0f};
    private String[] xData = {"Mitch"};
    private static String TAG = "MainActivity";
    Button purna;
    CardView cardView2,cardView3;
    ImageButton back;
    boolean rec1 = false, rec2 = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        apekshitSudharnaBinding = DataBindingUtil.setContentView(this,R.layout.apekshit_sudharna);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        purna = apekshitSudharnaBinding.purna;
        cardView2 = apekshitSudharnaBinding.cardview2;
        cardView3 = apekshitSudharnaBinding.cardview3;

        purna.setOnClickListener(view -> {
            final AlertDialog.Builder builder = new AlertDialog.Builder(apekshit_sudharna.this);

            builder.setCancelable(true);

            final AlertDialog alertDialog = builder.create();

            LayoutInflater inflater = getLayoutInflater();
            View dialoglayout = inflater.inflate(R.layout.recommendation_dialog1, null);

            alertDialog.setView(dialoglayout);

            // Show the Alert Dialog box
            alertDialog.show();

            Button yes = dialoglayout.findViewById(R.id.yes);
            Button no = dialoglayout.findViewById(R.id.no);

            yes.setOnClickListener(v -> {
                alertDialog.dismiss();
                Intent intent = new Intent(apekshit_sudharna.this,summary.class);
                startActivity(intent);

            });

            no.setOnClickListener(v -> alertDialog.dismiss());
        });

        cardView2.setOnClickListener(view -> {
            rec1 = true;

            cardView2.setBackgroundColor(getResources().getColor(R.color.color8,getTheme()));
            cardView3.setBackgroundColor(getResources().getColor(R.color.white,getTheme()));

            ImageView imageView = findViewById(R.id.well_animation);
            Glide.with(apekshit_sudharna.this).load(R.drawable.well_animation).into(imageView);
        });

        cardView3.setOnClickListener(view -> {
            rec2 = true;

            cardView3.setBackgroundColor(getResources().getColor(R.color.color8,getTheme()));
            cardView2.setBackgroundColor(getResources().getColor(R.color.white,getTheme()));

            ImageView imageView = findViewById(R.id.well_animation);
            Glide.with(apekshit_sudharna.this).load(R.drawable.well_animation).into(imageView);
        });

        back = apekshitSudharnaBinding.back;

        back.setOnClickListener(view -> finish());
    }
}