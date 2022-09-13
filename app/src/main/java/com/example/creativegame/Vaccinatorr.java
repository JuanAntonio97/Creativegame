package com.example.creativegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.airbnb.lottie.LottieAnimationView;

public class Vaccinatorr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccinatorr);
        Animation ani1 = AnimationUtils.loadAnimation(this, R.anim.desp_arriba);
        Animation ani2 = AnimationUtils.loadAnimation(this, R.anim.desp_abajo);

        LottieAnimationView lo4 = findViewById(R.id.lo4);
        LottieAnimationView lo3= findViewById(R.id.lo3);

        lo4.setAnimation(ani1);
        lo3.setAnimation(ani2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Vaccinatorr.this, Menu.class);
                startActivity(i);
                finish();
            }
        }, 4000);

    }
}