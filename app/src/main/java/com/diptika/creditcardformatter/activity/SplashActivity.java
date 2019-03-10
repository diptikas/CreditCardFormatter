package com.diptika.creditcardformatter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.diptika.creditcardformatter.R;


public class SplashActivity extends AppCompatActivity {
    private static final int DELAY=2000;
    private ImageView ivSplash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivSplash = findViewById(R.id.iv_splash_logo);

        Animation a = new AlphaAnimation(1.00f, 0.00f);
        a.setDuration(DELAY);
        a.setAnimationListener(new Animation.AnimationListener() {

            public void onAnimationStart(Animation animation) {
                //no-op
            }

            public void onAnimationRepeat(Animation animation) {
                // no-op

            }

            public void onAnimationEnd(Animation animation) {
                ivSplash.setVisibility(View.GONE);
                startActivity(new Intent(SplashActivity.this,CreditCardFormatterActivity.class));
                finish();
            }
        });

        ivSplash.startAnimation(a);

    }
}
