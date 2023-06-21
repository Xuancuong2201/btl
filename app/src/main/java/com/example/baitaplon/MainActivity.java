package com.example.baitaplon;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baitaplon.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_Guide, R.id.nav_User,R.id.nav_Menu)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    private void ActionViewFlipper()
    {
        ArrayList<String> mauquangcao = new ArrayList<>();
        mauquangcao.add("https://ipos.vn/wp-content/webp-express/webp-images/uploads/2019/11/cap-nhat-chi-phi-nhuong-quyen.jpg.webp");
        mauquangcao.add("https://media.istockphoto.com/id/1313839727/vector/coffee-internet-and-social-media-promotion-template-advertising-advertising-banner-product.jpg?s=1024x1024&w=is&k=20&c=bzdsCpnJ5ya_dzc4SeN5D6bWQuKI3gYsj3P5QE8wHhA=");
        for(int i =0;i<mauquangcao.size();i++)
        {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(mauquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        viewFlipper.setFlipInterval(4000);
        viewFlippers.setA
    }
}