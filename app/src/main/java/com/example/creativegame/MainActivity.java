package com.example.creativegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.desp_arriba);
        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.desp_abajo);

        ImageView logo = findViewById(R.id.logo);
        LottieAnimationView an = findViewById(R.id.an);

        logo.setAnimation(anim1);
        an.setAnimation(anim2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);
                finish();
            }
        }, 4000);
    }
}