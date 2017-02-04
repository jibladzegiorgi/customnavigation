package com.example.giorgi.navigationview;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private DrawerLayout.DrawerListener mDrawerToggle;
    private Toolbar toolbar;
    float x = 0;
    float x_1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.RecyclerView);
        final RelativeLayout linearLayout2 = (RelativeLayout) findViewById(R.id.linear);
        Button button = (Button) findViewById(R.id.btn1);
        Button button2 = (Button) findViewById(R.id.btn2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click_1", Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click_2", Toast.LENGTH_SHORT).show();
            }
        });


        linearLayout.setOnTouchListener(new OnSwipeTouchListener() {
            @Override
            public void onSwipeLeft() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                final ObjectAnimator oa_y = ObjectAnimator.ofFloat(linearLayout2, "y", 200);
                final ObjectAnimator oa = ObjectAnimator.ofFloat(linearLayout2, "x", -200);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(oa,oa_y);
                animatorSet.start();
                super.onSwipeLeft();
            }

            @Override
            public void onSwipeRight() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                final ObjectAnimator oa_y = ObjectAnimator.ofFloat(linearLayout2, "y", 0);
                final ObjectAnimator oa = ObjectAnimator.ofFloat(linearLayout2, "x", 0);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(oa,oa_y);
                animatorSet.start();
                super.onSwipeRight();
            }
        });

//        toolbar = (Toolbar) findViewById(R.id.tool_bar);
//        setSupportActionBar(toolbar);


//        final DrawerLayout Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
//        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, toolbar, R.string.app_name, R.string.app_name) {
//
//
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                if (x == 0) {
//                    x = drawerView.getX();
//                } else {
//                    x_1 = x-drawerView.getX();
//
//                    final ObjectAnimator oa = ObjectAnimator.ofFloat(linearLayout, "x", -x_1)
//                            .setDuration(0);
//                    oa.start();
//                }
//                super.onDrawerSlide(drawerView, slideOffset);
//            }
//
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                super.onDrawerOpened(drawerView);
//                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
//                // open I am not going to put anything here)
//            }
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                super.onDrawerClosed(drawerView);
//                // Code here will execute once drawer is closed
//            }
//
//
//        }; // Drawer Toggle Object Made
//        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
//        //mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State

    }
}

