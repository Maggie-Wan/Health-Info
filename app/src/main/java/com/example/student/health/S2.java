package com.example.student.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class S2 extends AppCompatActivity {
    Button home7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s2);
        home7=(Button)findViewById(R.id.home7);
    }
    public void home7(View v){
        Intent in=new Intent();
        in.setClass(S2.this,MainActivity.class);
        startActivity(in);
    }
}
