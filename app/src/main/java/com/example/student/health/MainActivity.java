package com.example.student.health;

import android.annotation.TargetApi;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btns1,btns2,btn1,btn2,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btns1=(Button)findViewById(R.id.btns1);
        btns2=(Button)findViewById(R.id.btns2);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
    }
    public void btns1(View v){
        Intent in=new Intent();
        in.setClass(MainActivity.this,S1.class);
        startActivity(in);
    }
    public void btns2(View v){
        Intent in=new Intent();
        in.setClass(MainActivity.this,S2.class);
        startActivity(in);
    }
    public void btn1(View v){
        Intent in=new Intent();
        in.setClass(MainActivity.this,B1.class);
        startActivity(in);
    }
    public void btn2(View v){
        Intent in=new Intent();
        in.setClass(MainActivity.this,B2.class);
        startActivity(in);
    }
    public void btn3(View v){
        Intent in=new Intent();
        in.setClass(MainActivity.this,B3.class);
        startActivity(in);
    }
    public void btn4(View v){
        Intent in=new Intent();
        in.setClass(MainActivity.this,B4.class);
        startActivity(in);
    }
    public void btn5(View v){
        Intent in=new Intent();
        in.setClass(MainActivity.this,B5.class);
        startActivity(in);
    }
    public void btn6(View v){
        Intent in=new Intent();
        in.setClass(MainActivity.this,B6.class);
        startActivity(in);
    }

}
