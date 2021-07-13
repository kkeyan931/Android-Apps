package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean flag = true;

    public void animate(View view){

        ImageView image1 = findViewById(R.id.imageView);
        ImageView image2 = findViewById(R.id.imageView2);

        if(flag) {
            flag = false;
            image1.animate().alpha(0).setDuration(3000);

            image2.animate().alpha(1).setDuration(3000);

        }
        else {
            flag = true;

            image1.animate().alpha(1).setDuration(3000);

            image2.animate().alpha(0).setDuration(3000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}