package dev.atharvakulkarni.midas.pikanchi_garaj;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import dev.atharvakulkarni.midas.R;
import dev.atharvakulkarni.midas.UserModel;
import dev.atharvakulkarni.midas.apekshit_sudharna;
import dev.atharvakulkarni.midas.databinding.RabbiBinding;

public class rabbi extends AppCompatActivity
{
    RabbiBinding rabbiBinding;
    PieChart pieChart;
    private float[] yData = {67.5f, 28.6f, 3.9f,11.8f,34.4f,43.f,11.4f};
    private String[] xData = {"Mitch", "Jessica" , "Mohammad","c","x","s","we"};
    private static String TAG = "MainActivity";
    CardView cardView2;
    FirebaseFirestore db;
    ImageButton back;
    final int x = 12;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        rabbiBinding = DataBindingUtil.setContentView(this, R.layout.rabbi);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        pieChart = rabbiBinding.chart1;

        cardView2 = rabbiBinding.cardview2;

        //pieChart.setDescription("Sales by employee (In Thousands $) ");
        pieChart.getDescription().setEnabled(false);

        cardView2.setOnClickListener(view -> {
            Intent intent=new Intent();
            setResult(2,intent);
            finish();//finishing activity
        });

        // pieChart.setRotationEnabled(true);
        pieChart.setUsePercentValues(false);
        //pieChart.setHoleColor(Color.BLUE);
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(80f);
        pieChart.setTransparentCircleAlpha(0);
        //pieChart.setCenterText(Html.fromHtml("Line1"+"<br>"+"Line2" + " <br>"+"Line3",0));
        pieChart.setCenterText("  पाणी वापरले: \n ६९१० टी.सी.एम");
        pieChart.setCenterTextSize(15);
        pieChart.setHoleColor(getResources().getColor(R.color.pink,getTheme()));

        // pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!

        back = rabbiBinding.back;

        back.setOnClickListener(view -> finish());

        cardView2.setOnClickListener(view -> {
           // setResult(Activity.RESULT_OK, x);
            finish();
        });

        addDataSet();


        db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection(UserModel.getVillage()).document("pani_budget").collection("pikanchi_garaj").document("pikanchi_garaj").
                collection("rabbi").document("rabbi");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task)
            {
                if (task.isSuccessful())
                {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists())
                    {
                        Log.d("TAG", "DocumentSnapshot data: " + document.getData());

                        // map.putAll(Objects.requireNonNull(document.getData()));

                        rabbiBinding.crop1.setText(document.getString("crop1"));
                        rabbiBinding.crop2.setText(document.getString("crop2"));
                        rabbiBinding.crop3.setText(document.getString("crop3"));
                        rabbiBinding.crop4.setText(document.getString("crop4"));
                        rabbiBinding.crop5.setText(document.getString("crop5"));

                        rabbiBinding.crop1Area.setText(document.getString("crop1_area"));
                        rabbiBinding.crop2Area.setText(document.getString("crop2_area"));
                        rabbiBinding.crop3Area.setText(document.getString("crop3_area"));
                        rabbiBinding.crop4Area.setText(document.getString("crop4_area"));
                        rabbiBinding.crop5Area.setText(document.getString("crop5_area"));

                        rabbiBinding.crop1Req.setText(document.getString("crop1_req"));
                        rabbiBinding.crop2Req.setText(document.getString("crop2_req"));
                        rabbiBinding.crop3Req.setText(document.getString("crop3_req"));
                        rabbiBinding.crop4Req.setText(document.getString("crop4_req"));
                        rabbiBinding.crop5Req.setText(document.getString("crop5_req"));
                    }
                }
                else
                {
                    Log.d("TAG", "get failed with ", task.getException());
                }
            }
        });
    }

    private void addDataSet()
    {
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < yData.length; i++)
        {
            yEntrys.add(new PieEntry(yData[i] , i));
        }

        for(int i = 1; i < xData.length; i++)
        {
            xEntrys.add(xData[i]);
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "");
        pieDataSet.setSliceSpace(0);
        pieDataSet.setValueTextSize(12);

        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(getResources().getColor(R.color.color6,getTheme()));
        colors.add(getResources().getColor(R.color.color7,getTheme()));
        colors.add(getResources().getColor(R.color.color8,getTheme()));
        colors.add(getResources().getColor(R.color.color9,getTheme()));
        colors.add(getResources().getColor(R.color.color10,getTheme()));
        colors.add(getResources().getColor(R.color.color11,getTheme()));
        colors.add(getResources().getColor(R.color.color12,getTheme()));

        pieDataSet.setColors(colors);

        //add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setEnabled(false);
        // legend.setForm(Legend.LegendForm.CIRCLE);
        //legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieData.setDrawValues(false);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}