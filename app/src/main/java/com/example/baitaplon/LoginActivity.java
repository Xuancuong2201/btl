package com.example.baitaplon;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void mainActivity(View view) {
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }

    public void register(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }
}


