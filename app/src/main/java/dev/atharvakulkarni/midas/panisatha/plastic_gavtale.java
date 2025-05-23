package dev.atharvakulkarni.midas.panisatha;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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
import dev.atharvakulkarni.midas.databinding.PlasticGavtaleBinding;

public class plastic_gavtale extends AppCompatActivity
{
    PlasticGavtaleBinding plasticGavtaleBinding;
    PieChart pieChart;
    private float[] yData = {77.1f, 22.9f};
    private String[] xData = {"Mitch", "Jessica"};
    private static String TAG = "MainActivity";
    TextView baashpibhavan, jaminivaril;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        plasticGavtaleBinding = DataBindingUtil.setContentView(this, R.layout.plastic_gavtale);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        pieChart = plasticGavtaleBinding.chart1;
        //pieChart.setDescription("Sales by employee (In Thousands $) ");
        pieChart.getDescription().setEnabled(false);

        // pieChart.setRotationEnabled(true);
        pieChart.setUsePercentValues(false);
        //pieChart.setHoleColor(Color.BLUE);
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(80f);
        pieChart.setTransparentCircleAlpha(0);
        //pieChart.setCenterText(Html.fromHtml("Line1"+"<br>"+"Line2" + " <br>"+"Line3",0));
        pieChart.setCenterText("एकूण जमिनीवरील पाणी: \n ११.२ को.टी");
        pieChart.setCenterTextSize(15);
        pieChart.setHoleColor(getResources().getColor(R.color.pink,getTheme()));

        // pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!

        addDataSet();

       // total = plasticGavtaleBinding.total;
        baashpibhavan = plasticGavtaleBinding.bashpibhavan;
        jaminivaril = plasticGavtaleBinding.jaminivaril;

        plasticGavtaleBinding.back.setOnClickListener(view -> finish());
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
        colors.add(getResources().getColor(R.color.color6,getTheme()));

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