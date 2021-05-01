package dev.atharvakulkarni.midas.panisatha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;

import com.google.firebase.firestore.FirebaseFirestore;

import dev.atharvakulkarni.midas.R;
import dev.atharvakulkarni.midas.databinding.JalsandharanBinding;

public class jalsandharan extends AppCompatActivity
{
    JalsandharanBinding jalsandharanBinding;
    CardView cardView,cardView1,cardView2,cardView3;
    TextView total;
    FirebaseFirestore db;
    ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        jalsandharanBinding = DataBindingUtil.setContentView(this, R.layout.jalsandharan);


        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        cardView = jalsandharanBinding.cardview;
        cardView1 = jalsandharanBinding.cardview1;
        cardView2 = jalsandharanBinding.cardview2;
        cardView3 = jalsandharanBinding.cardview3;
       // total = jalsandharanBinding.total;

        cardView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(jalsandharan.this, cement_nala_band.class);
                startActivity(intent);
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(jalsandharan.this, matiche_nala_band.class);
                startActivity(intent);
               // Toast.makeText(jalsandharan.this, "Not Present", Toast.LENGTH_SHORT).show();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(jalsandharan.this, sarv_gav_talav.class);
                startActivity(intent);
               // Toast.makeText(jalsandharan.this, "Not Present", Toast.LENGTH_SHORT).show();
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(jalsandharan.this, cct.class);
                startActivity(intent);
               // Toast.makeText(jalsandharan.this, "Not Present", Toast.LENGTH_SHORT).show();
            }
        });

        back = jalsandharanBinding.back;

        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });




       /* db = FirebaseFirestore.getInstance();

        DocumentReference docRef = db.collection(UserModel.getVillage()).document("pani_budget").collection("pani_satha").document("pani_satha").
                collection("jalsandharan").document("jalsandharan");
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
        });*/
    }
}
