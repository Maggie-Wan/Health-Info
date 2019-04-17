package com.example.student.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class B2 extends AppCompatActivity {
    RadioButton a1,a2;
    EditText h2;
    Button ok2,home2;
    TextView weight,result2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2);
        a1=(RadioButton) findViewById(R.id.a1);
        a2=(RadioButton) findViewById(R.id.a2);
        h2=(EditText)findViewById(R.id.h2);
        ok2=(Button)findViewById(R.id.ok2);
        home2=(Button)findViewById(R.id.home2);
        weight=(TextView)findViewById(R.id.weight);
        result2=(TextView)findViewById(R.id.result2);
    }
    public void home2(View v){
        Intent in=new Intent();
        in.setClass(B2.this,MainActivity.class);
        startActivity(in);
    }
    public void ok2(View v){
        try{
        double H=Double.parseDouble(h2.getText().toString());
        double S=0;
        if (a1.isChecked()){
            S=(H-80)*0.7;
        }else if(a2.isChecked()){
            S=(H-70)*0.6;
        }
        S=(int)(S*100)/100.;
        double r1=S*0.9;
        double r2=S*1.1;
        r2=(int)(r2*100)/100.;
        weight.setText(S+"公斤");
        result2.setText(r1+"公斤~"+r2+"公斤");
        }catch (Exception e){
            Toast t= Toast.makeText(this,
                    "輸入身高時，請勿空白或輸入非數字或輸入符號",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }
    }
}
/*
男性： （身高cm－80）×70﹪＝標準體重
女性： （身高cm－70）×60﹪＝標準體重
超重計算公式

超重%＝｛（實際體重－理想體重）／（理想體重）｝×100%

超重百分比	代表意義
大於＋20%	肥胖
20%～10%	體重過重
＋10%～－10%	正常
－10%～－20%	體重過輕
小於－20%	瘦弱


 */