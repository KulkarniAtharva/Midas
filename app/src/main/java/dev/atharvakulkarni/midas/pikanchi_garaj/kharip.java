package dev.atharvakulkarni.midas.pikanchi_garaj;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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
import dev.atharvakulkarni.midas.databinding.KharipBinding;

public class kharip extends AppCompatActivity
{
    KharipBinding kharipBinding;
    PieChart pieChart;
    private float[] yData = {67.5f, 28.6f, 3.9f,11.8f,34.4f,43.f,11.4f};
    private String[] xData = {"Mitch", "Jessica" , "Mohammad","c","x","s","we"};
    private static String TAG = "MainActivity";
   // TextView crop1, crop2, crop3, crop4, crop5, crop6, crop7, crop8, crop1_area,crop2_area,crop3_area,crop4_area,crop5_area,crop6_area,crop7_area,crop8_area,;
    //TextView crop1_req,crop2_req,crop3_req,crop4_req,crop5_req,crop6_req,crop7_req,crop8_req;
    FirebaseFirestore db;
    ImageButton back;
    CardView cardView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        kharipBinding = DataBindingUtil.setContentView(this, R.layout.kharip);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        pieChart = kharipBinding.chart1;
        //pieChart.setDescription("Sales by employee (In Thousands $) ");
        pieChart.getDescription().setEnabled(false);

        // pieChart.setRotationEnabled(true);
        pieChart.setUsePercentValues(false);
        //pieChart.setHoleColor(Color.BLUE);
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(80f);
        pieChart.setTransparentCircleAlpha(0);
        //pieChart.setCenterText(Html.fromHtml("Line1"+"<br>"+"Line2" + " <br>"+"Line3",0));
        pieChart.setCenterText("  पाणी वापरले: \n १०३.८ को.टी");
        pieChart.setCenterTextSize(15);
        pieChart.setHoleColor(getResources().getColor(R.color.pink,getTheme()));

        // pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!


        back = kharipBinding.back;
        cardView2 = kharipBinding.cardview2;

        back.setOnClickListener(view -> finish());

        cardView2.setOnClickListener(view -> finish());

        addDataSet();

        db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection(UserModel.getVillage()).document("pani_budget").collection("pikanchi_garaj").document("pikanchi_garaj").
                collection("kharip").document("kharip");
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

                       // kharipBinding.total.setText(document.getString("total"));

                        kharipBinding.crop1.setText(document.getString("crop1"));
                        kharipBinding.crop2.setText(document.getString("crop2"));
                        kharipBinding.crop3.setText(document.getString("crop3"));
                        kharipBinding.crop4.setText(document.getString("crop4"));
                        kharipBinding.crop5.setText(document.getString("crop5"));
                        kharipBinding.crop6.setText(document.getString("crop6"));
                        kharipBinding.crop7.setText(document.getString("crop7"));

                        kharipBinding.crop1Area.setText(document.getString("crop1_area"));
                        kharipBinding.crop2Area.setText(document.getString("crop2_area"));
                        kharipBinding.crop3Area.setText(document.getString("crop3_area"));
                        kharipBinding.crop4Area.setText(document.getString("crop4_area"));
                        kharipBinding.crop5Area.setText(document.getString("crop5_area"));
                        kharipBinding.crop6Area.setText(document.getString("crop6_area"));
                        kharipBinding.crop7Area.setText(document.getString("crop7_area"));


                        kharipBinding.crop1Req.setText(document.getString("crop1_req"));
                        kharipBinding.crop2Req.setText(document.getString("crop2_req"));
                        kharipBinding.crop3Req.setText(document.getString("crop3_req"));
                        kharipBinding.crop4Req.setText(document.getString("crop4_req"));
                        kharipBinding.crop5Req.setText(document.getString("crop5_req"));
                        kharipBinding.crop6Req.setText(document.getString("crop6_req"));
                        kharipBinding.crop7Req.setText(document.getString("crop7_req"));
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