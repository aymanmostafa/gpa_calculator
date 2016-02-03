package com.ayman.huci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    TextView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        a=(TextView) findViewById(R.id.aboutid);
        a.setText("\nHUCI App v1.3\n\n\nDeveloped by\nAyman Mostafa");

    }

}
