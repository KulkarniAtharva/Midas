package dev.atharvakulkarni.midas.pikanchi_garaj;

import android.content.Intent;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import dev.atharvakulkarni.midas.R;
import dev.atharvakulkarni.midas.UserModel;
import dev.atharvakulkarni.midas.databinding.PikanchiGarajBinding;

public class pikanchi_garaj extends AppCompatActivity
{
    PikanchiGarajBinding pikanchiGarajBinding;
    CardView cardView2,cardView3,cardView4;
    TextView kharip, varshik_kharip, rabbi;
    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        pikanchiGarajBinding = DataBindingUtil.setContentView(this, R.layout.pikanchi_garaj);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        cardView2 = pikanchiGarajBinding.cardview2;
        cardView3 = pikanchiGarajBinding.cardview3;
        cardView4 = pikanchiGarajBinding.cardview4;

        cardView2.setOnClickListener(view -> {
            Intent intent = new Intent(pikanchi_garaj.this, kharip.class);
            startActivity(intent);
            finish();
        });

        cardView3.setOnClickListener(view -> {
            Intent intent = new Intent(pikanchi_garaj.this, varshik_kharip.class);
            startActivity(intent);
            finish();
        });

        cardView4.setOnClickListener(view -> {
            Intent intent = new Intent(pikanchi_garaj.this, rabbi.class);
            startActivityForResult(intent, 2);
            finish();
        });

        kharip = pikanchiGarajBinding.kharip;
        varshik_kharip = pikanchiGarajBinding.varshikkharip;
        rabbi = pikanchiGarajBinding.rabbi;

        back = pikanchiGarajBinding.back;

        back.setOnClickListener(view -> finish());
    }

    // Call Back method  to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            // String message=data.getStringExtra("MESSAGE");
            // textView1.setText(message);

            //  Toast.makeText(this, "ask", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent();
            setResult(2,intent);
            finish();//finishing activity
        }
    }
}