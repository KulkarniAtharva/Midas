package dev.atharvakulkarni.midas;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import dev.atharvakulkarni.midas.databinding.ApekshitSudharnaBinding;
import dev.atharvakulkarni.midas.databinding.CctBinding;
import dev.atharvakulkarni.midas.databinding.PurnaBinding;

public class purna extends AppCompatActivity
{
    PurnaBinding purnaBinding;
    PieChart pieChart;
    private float[] yData = {100f};
    private String[] xData = {"Mitch"};
    private static String TAG = "MainActivity";
    CardView cardView2;
    Fragment fragment = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        purnaBinding = DataBindingUtil.setContentView(this,R.layout.purna);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        pieChart = purnaBinding.chart1;
        cardView2 = purnaBinding.cardview2;
        //pieChart.setDescription("Sales by employee (In Thousands $) ");
        pieChart.getDescription().setEnabled(false);

        View view2 = getWindow().getLayoutInflater().inflate(R.layout.activity_main, null);

        cardView2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               /* Intent intent = new Intent(purna.this,pani_budget.class);
                startActivity(intent);*/

               // Fragment mFragment = null;
               // mFragment = new pani_budget();
               // FragmentManager fragmentManager = getSupportFragmentManager();
             //   fragmentManager.beginTransaction().replace(view2.findViewById(R.id.framelayout), mFragment).commit();
            }
        });

        // pieChart.setRotationEnabled(true);
        pieChart.setUsePercentValues(false);
        //pieChart.setHoleColor(Color.BLUE);
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(85f);
        pieChart.setTransparentCircleAlpha(0);
        //pieChart.setCenterText(Html.fromHtml("Line1"+"<br>"+"Line2" + " <br>"+"Line3",0));
        pieChart.setCenterText("पाणी वापरले: \n ४४३८/४४३८ टी.सी.एम");
        pieChart.setCenterTextSize(15);

        // pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!

        addDataSet();



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
        colors.add(getResources().getColor(R.color.color5,getTheme()));


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