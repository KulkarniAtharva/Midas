package dev.atharvakulkarni.midas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import com.google.firebase.firestore.FirebaseFirestore;

import dev.atharvakulkarni.midas.databinding.PaniSathaBinding;
import dev.atharvakulkarni.midas.panisatha.jalsandharan;
import dev.atharvakulkarni.midas.panisatha.prushtabhagavaril;

public class pani_satha extends AppCompatActivity
{
    PaniSathaBinding paniSathaBinding;
    CardView cardView,cardView1;
    FirebaseFirestore db;
    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        paniSathaBinding = DataBindingUtil.setContentView(this,R.layout.pani_satha);

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        cardView = paniSathaBinding.cardview;
        cardView1 = paniSathaBinding.cardview1;

        cardView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(pani_satha.this, prushtabhagavaril.class);
                startActivity(intent);
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(pani_satha.this, jalsandharan.class);
                startActivity(intent);
            }
        });

        back = paniSathaBinding.back;

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });


        /*db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection(UserModel.getVillage()).document("pani_budget").collection("pani_satha").document("pani_satha");
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

                    total.setText(document.getString("total"));

                }
                else
                {
                    Log.d("TAG", "get failed with ", task.getException());
                }
            }
        });*/
    }
}