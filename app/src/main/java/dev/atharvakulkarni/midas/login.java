package dev.atharvakulkarni.midas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class login extends AppCompatActivity
{
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

        submit.setOnClickListener(view -> {
            username = username_edittext.getText().toString()+"@gmail.com";
            password = password_edittext.getText().toString();


        });

        getWindow().setStatusBarColor(getResources().getColor(R.color.white,getTheme()));

        //Typeface tf = Typeface.createFromAsset(getAssets(), "marathi.ttf");
       // textView.setTypeface(tf);
    }
}