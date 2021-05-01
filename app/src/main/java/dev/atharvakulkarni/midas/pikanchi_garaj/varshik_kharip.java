package dev.atharvakulkarni.midas.pikanchi_garaj;

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
import dev.atharvakulkarni.midas.databinding.VarshikKharipBinding;

public class varshik_kharip extends AppCompatActivity
{
    VarshikKharipBinding varshikKharipBinding;
    PieChart pieChart;
    private float[] yData = {100f};
    private String[] xData = {"Mitch"};
    private static String TAG = "MainActivity";
    FirebaseFirestore db;
    ImageButton back;
    CardView cardView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        varshikKharipBinding = DataBindingUtil.setContentView(this, R.layout.varshik_kharip);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        pieChart =varshikKharipBinding.chart1;
        //pieChart.setDescription("Sales by employee (In Thousands $) ");
        pieChart.getDescription().setEnabled(false);

        // pieChart.setRotationEnabled(true);
        pieChart.setUsePercentValues(false);
        //pieChart.setHoleColor(Color.BLUE);
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(80f);
        pieChart.setTransparentCircleAlpha(0);
        //pieChart.setCenterText(Html.fromHtml("Line1"+"<br>"+"Line2" + " <br>"+"Line3",0));
        pieChart.setCenterText("  पाणी वापरले: \n ७२ को.टी");
        pieChart.setCenterTextSize(15);
        pieChart.setHoleColor(getResources().getColor(R.color.pink,getTheme()));

        // pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!

        addDataSet();

        back = varshikKharipBinding.back;
        cardView2 = varshikKharipBinding.cardview2;

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });


        db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection(UserModel.getVillage()).document("pani_budget").collection("pikanchi_garaj").document("pikanchi_garaj").
                collection("varshik_kharip").document("varshik_kharip");
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

                       // varshikKharipBinding.total.setText(document.getString("total"));

                        varshikKharipBinding.crop1.setText(document.getString("crop1"));
                        varshikKharipBinding.crop1Area.setText(document.getString("crop1_area"));
                        varshikKharipBinding.crop1Req.setText(document.getString("crop1_req"));
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
        colors.add(getResources().getColor(R.color.color13,getTheme()));

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
