package com.example.smssender; 
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.smssender.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        ImageView imageViewLogo = findViewById(R.id.imageViewLogo);
        TextView textViewName = findViewById(R.id.textViewName);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        imageViewLogo.startAnimation(fadeIn);
        textViewName.startAnimation(fadeIn);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(SplashActivity.this, Task2.class);
                startActivity(intent);
                finish();
            }
        }).start();
    }
}
