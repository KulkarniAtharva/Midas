package dev.atharvakulkarni.midas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import dev.atharvakulkarni.midas.databinding.ActivityMainBinding;
import dev.atharvakulkarni.midas.interfaces.HamburgerDrawer;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    Fragment fragment = null;
    ActivityMainBinding activityMainBinding;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

       // getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.transparent,getTheme()));

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch(item.getItemId())
                {
                    case R.id.home:
                                        fragment = new Home(() -> drawerLayout.openDrawer(GravityCompat.START));
                                        switchfragment(fragment);

                                    return true;
                    case R.id.pani_budget:
                                        fragment = new pani_budget(() -> drawerLayout.openDrawer(GravityCompat.START));
                                        switchfragment(fragment);

                                    return true;
                    case R.id.niyojan:
                                        fragment = new niyojan(() -> drawerLayout.openDrawer(GravityCompat.START));
                                        switchfragment(fragment);
                                    return true;

                    case R.id.suchna:
                                        fragment = new suchna();
                                        switchfragment(fragment);
                                    return true;
                }

               // bottomNavigationView.setSelectedItemId(item.getItemId());


                return false;
            }
        });

        if (savedInstanceState == null)
        {
            bottomNavigationView.setSelectedItemId(R.id.home); // change to whichever id should be default
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        switch (menuItem.getItemId())
        {
            case R.id.profile:     break;
            case R.id.faqs:    break;
            case R.id.contactus:   cart(); break;
            case R.id.feedback:     break;
            case R.id.language:     break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    void cart()
    {
        //Intent intent = new Intent(this,CartActivity.class);
        //startActivity(intent);
    }

    void switchfragment(Fragment fragment)
    {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.framelayout,fragment).commit();
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

            Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
            fragment = new niyojan(() -> drawerLayout.openDrawer(GravityCompat.START));
            switchfragment(fragment);







        }
    }
}