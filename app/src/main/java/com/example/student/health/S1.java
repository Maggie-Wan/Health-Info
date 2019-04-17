package com.example.student.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class S1 extends AppCompatActivity {
    Button homeS1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s1);
        homeS1=(Button)findViewById(R.id.homeS1);
    }

    public void homeS1(View v){
        Intent in=new Intent();
        in.setClass(S1.this,MainActivity.class);
        startActivity(in);
    }
}