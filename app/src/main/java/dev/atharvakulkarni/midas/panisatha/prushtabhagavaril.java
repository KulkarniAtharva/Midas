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
    CardView cardView2,cardView3,cardView4,cardView5;
    FirebaseFirestore db;
    TextView total;
    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        prushtabhagavarilBinding = DataBindingUtil.setContentView(this, R.layout.prushtabhagavaril);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        cardView2 = prushtabhagavarilBinding.cardview2;
        cardView3 = prushtabhagavarilBinding.cardview3;
        cardView4 = prushtabhagavarilBinding.cardview4;
        cardView5 = prushtabhagavarilBinding.cardview5;

        cardView2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(prushtabhagavaril.this, dharan.class);
                startActivity(intent);
               // Toast.makeText(prushtabhagavaril.this, "Not Present", Toast.LENGTH_SHORT).show();
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(prushtabhagavaril.this, k_t_wiers.class);
                startActivity(intent);
               // Toast.makeText(prushtabhagavaril.this, "Not Present", Toast.LENGTH_SHORT).show();
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(prushtabhagavaril.this, plastic_gavtale.class);
                startActivity(intent);
            }
        });

        cardView5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(prushtabhagavaril.this, bin_plastic_gavtale.class);
                startActivity(intent);
                //Toast.makeText(prushtabhagavaril.this, "Not Present", Toast.LENGTH_SHORT).show();
            }
        });

        back = prushtabhagavarilBinding.back;

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });

        db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection(UserModel.getVillage()).document("pani_budget").collection("pani_satha").document("pani_satha").
                collection("prushthabhagavaril").document("prushthabhagavaril");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task)
            {
                if (task.isSuccessful())
                {
                    DocumentSnapshot document = task.getResult();
                    //if (document.exists())
                    //{
                    Log.d("TAG", "DocumentSnapshot data: " + document.getData());

                    // map.putAll(Objects.requireNonNull(document.getData()));

                   // total.setText(document.getString("total"));
                }
                else
                {
                    Log.d("TAG", "get failed with ", task.getException());
                }
            }
        });
    }
}