package com.levent.ntigo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;


public class SplashActivity extends AppCompatActivity {

    ImageView ntiLogo,ctsLogo;
    TextView girisText;
    Animator alttanAnimator, soldanAnimator, sagdanAnimator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        ntiLogo=findViewById(R.id.ntilogo);
        ctsLogo=findViewById(R.id.ctslogo);
        girisText=findViewById(R.id.mobil_uygulama_giriş_text);

        alttanAnimator= AnimatorInflater.loadAnimator(SplashActivity.this,R.animator.alttankay);
        soldanAnimator= AnimatorInflater.loadAnimator(SplashActivity.this,R.animator.soldankay);
        sagdanAnimator= AnimatorInflater.loadAnimator(SplashActivity.this,R.animator.sagdankay);


        alttanAnimator.setTarget(girisText);
        soldanAnimator.setTarget(ctsLogo);
        sagdanAnimator.setTarget(ntiLogo);
        alttanAnimator.start();
        soldanAnimator.start();
        sagdanAnimator.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                               Intent intent = new Intent(SplashActivity.this,DeviceListActivity.class);
                               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                               startActivity(intent);
                               Animatoo.animateFade(SplashActivity.this);

            }

        }, 3000);
    }
}
