package dev.atharvakulkarni.midas.panisatha;

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
import dev.atharvakulkarni.midas.databinding.PrushtabhagavarilBinding;

public class prushtabhagavaril extends AppCompatActivity
{
    PrushtabhagavarilBinding prushtabhagavarilBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        prushtabhagavarilBinding = DataBindingUtil.setContentView(this, R.layout.prushtabhagavaril);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        prushtabhagavarilBinding.cardview2.setOnClickListener(view -> {
            Intent intent = new Intent(prushtabhagavaril.this, dharan.class);
            startActivity(intent);
        });

        prushtabhagavarilBinding.cardview2.setOnClickListener(view -> {
            Intent intent = new Intent(prushtabhagavaril.this, k_t_wiers.class);
            startActivity(intent);
        });

        prushtabhagavarilBinding.cardview4.setOnClickListener(view -> {
            Intent intent = new Intent(prushtabhagavaril.this, plastic_gavtale.class);
            startActivity(intent);
        });

        prushtabhagavarilBinding.cardview5.setOnClickListener(view -> {
            Intent intent = new Intent(prushtabhagavaril.this, bin_plastic_gavtale.class);
            startActivity(intent);
            //Toast.makeText(prushtabhagavaril.this, "Not Present", Toast.LENGTH_SHORT).show();
        });

        prushtabhagavarilBinding.back.setOnClickListener(view -> finish());
    }
}