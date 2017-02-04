package com.example.giorgi.navigationview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Animation animation_first;
    Animation animation_two;
    LinearLayout humburger_1;
    LinearLayout humburger_2;
    LinearLayout humburger_3;
    LinearLayout humburger_4;
    Animation test;
    boolean isShow = false;
    Animation fadein;
    Animation rotateback;
    int l;
    Animation rotatetwoback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.RecyclerView);
        RelativeLayout humburger = (RelativeLayout) findViewById(R.id.humburger_main);
        final RelativeLayout linearLayout2 = (RelativeLayout) findViewById(R.id.linear);
        final RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.DrawerLayout);
        Button button2 = (Button) findViewById(R.id.btn2);
        humburger_1 = (LinearLayout) findViewById(R.id.humburger_1);
        humburger_2 = (LinearLayout) findViewById(R.id.humburger_2);
        humburger_3 = (LinearLayout) findViewById(R.id.humburger_3);
        humburger_4 = (LinearLayout) findViewById(R.id.humburger_4);
        test = AnimationUtils.loadAnimation(this, R.anim.test);
        animation_first = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
        animation_two = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotatetwo);
        fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
        rotateback = AnimationUtils.loadAnimation(this, R.anim.rotateback);
        rotatetwoback = AnimationUtils.loadAnimation(this, R.anim.rotatetwoback);


  /*      humburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShow) {
                    humburger_4.startAnimation(test);
                    humburger_3.startAnimation(test);
                    humburger_1.startAnimation(animation_first);
                    humburger_2.startAnimation(animation_two);
                    isShow = true;
                } else {
                    humburger_4.startAnimation(fadein);
                    humburger_3.startAnimation(fadein);
                    humburger_1.startAnimation(rotateback);
                    humburger_2.startAnimation(rotatetwoback);
                    isShow = false;
                }
            }
        });*/


        humburger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShow) {
                    l = mainLayout.getMeasuredWidth();
                    final ObjectAnimator oa_y = ObjectAnimator.ofFloat(linearLayout2, "y", (float) (l * 0.08));
                    final ObjectAnimator oa = ObjectAnimator.ofFloat(linearLayout2, "x", -(float) ((l) * 0.70));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(oa, oa_y);
                    animatorSet.start();
                    humburger_4.startAnimation(test);
                    humburger_3.startAnimation(test);
                    humburger_1.startAnimation(animation_first);
                    humburger_2.startAnimation(animation_two);
                    isShow=true;

                } else {
                    final ObjectAnimator oa_y = ObjectAnimator.ofFloat(linearLayout2, "y", 0);
                    final ObjectAnimator oa = ObjectAnimator.ofFloat(linearLayout2, "x", 0);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(oa, oa_y);
                    animatorSet.start();
                    humburger_4.startAnimation(fadein);
                    humburger_3.startAnimation(fadein);
                    humburger_1.startAnimation(rotateback);
                    humburger_2.startAnimation(rotatetwoback);
                    isShow=false;
                }
            }
        });


        mainLayout.setOnTouchListener(new OnSwipeTouchListener() {
            @Override
            public void onSwipeLeft() {
                l = mainLayout.getMeasuredWidth();
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                final ObjectAnimator oa_y = ObjectAnimator.ofFloat(linearLayout2, "y", (float) (l * 0.08));
                final ObjectAnimator oa = ObjectAnimator.ofFloat(linearLayout2, "x", -(float) ((l) * 0.70));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(oa, oa_y);

                if (!isShow) {
                    humburger_4.startAnimation(test);
                    humburger_3.startAnimation(test);
                    humburger_1.startAnimation(animation_first);
                    humburger_2.startAnimation(animation_two);
                    isShow = true;
                }
                animatorSet.start();
                super.onSwipeLeft();
            }

            @Override
            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                final ObjectAnimator oa_y = ObjectAnimator.ofFloat(linearLayout2, "y", 0);
                final ObjectAnimator oa = ObjectAnimator.ofFloat(linearLayout2, "x", 0);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(oa, oa_y);
                if (isShow){
                    humburger_4.startAnimation(fadein);
                    humburger_3.startAnimation(fadein);
                    humburger_1.startAnimation(rotateback);
                    humburger_2.startAnimation(rotatetwoback);
                    isShow = false;
                }
                animatorSet.start();
                super.onSwipeRight();
            }
        });

    }
}

