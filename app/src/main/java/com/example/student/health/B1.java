package com.example.student.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class B1 extends AppCompatActivity {
    EditText h1,w1;
    Button ok1,home1;
    TextView bmi,result1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1);
        h1=(EditText)findViewById(R.id.h1);
        w1=(EditText)findViewById(R.id.w1);
        ok1=(Button)findViewById(R.id.ok1);
        home1=(Button)findViewById(R.id.home1);
        bmi=(TextView)findViewById(R.id.bmi);
        result1=(TextView)findViewById(R.id.result1);
    }
    public void home1(View v){
        Intent in=new Intent();
        in.setClass(B1.this,MainActivity.class);
        startActivity(in);
    }
    public void ok1(View v){
        try{
        double W=Double.parseDouble(w1.getText().toString());
        double H=(Double.parseDouble(h1.getText().toString()))/100;
        double BMI=(int)((W/Math.pow(H,2))*100)/100.;
        bmi.setText(""+BMI);
        if (BMI>=35){
            result1.setText("您屬於重度肥胖 ");
        }else if(BMI>=30){
            result1.setText("您屬於中度肥胖 ");
        }else if(BMI>=27){
            result1.setText("您屬於輕度肥胖 ");
        }else if(BMI>=24){
            result1.setText("您的體重過重 ");
        }else if(BMI>=18.5){
            result1.setText("您的BMI在正常範圍 ");
        }else{
            result1.setText("您的體重過輕 ");
        }
        }catch (Exception e){
            Toast t= Toast.makeText(this,
                    "輸入欄位時，請勿空白或輸入非數字或輸入符號",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }
    }
}

/*

體重過輕	BMI ＜ 18.5
正常範圍	18.5 ≦ BMI ＜24
過    重	24 ≦ BMI ＜ 27
輕度肥胖	27 ≦ BMI ＜ 30
中度肥胖	30 ≦ BMI ＜ 35
重度肥胖	BMI ≧ 35

 */