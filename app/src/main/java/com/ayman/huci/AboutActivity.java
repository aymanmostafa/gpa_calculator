package com.ayman.huci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import junit.framework.Test;

public class AboutActivity extends AppCompatActivity {

    TextView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        a=(TextView) findViewById(R.id.aboutid);
        a.setText("\nHUCI App v1.2\n\n\nDeveloped by\nAyman Mostafa");

    }

}
