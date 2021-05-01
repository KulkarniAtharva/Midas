package dev.atharvakulkarni.midas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity
{
    private static final String TAG = "ask";
    private FirebaseAuth mAuth;
    Button submit;
    EditText username_edittext,password_edittext;
    String username,password;
    private ProgressBar progressbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        submit = findViewById(R.id.submit_btn);
        username_edittext = findViewById(R.id.username_edittext);
        password_edittext = findViewById(R.id.password_edittext);
        progressbar = findViewById(R.id.progressbar);
        textView = findViewById(R.id.midas);

        mAuth = FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                username = username_edittext.getText().toString()+"@gmail.com";
                password = password_edittext.getText().toString();

                loginUserAccount(username,password);
            }
        });

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        //Typeface tf = Typeface.createFromAsset(getAssets(), "marathi.ttf");
       // textView.setTypeface(tf);
    }

    private void loginUserAccount(String username,String password)
    {
        Toast.makeText(this, username+" "+password, Toast.LENGTH_SHORT).show();
        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                           // updateUI(user);

                            UserModel.setVillage("कोनांबे");

                            Intent intent = new Intent(login.this,MainActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });
    }

    @Override
    public void onStart()
    {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
}