package com.example.student.health;
//https://ifitness.tw/ffmi-calculator/
//http://alphasportstraining.blogspot.tw/2015/09/61-ffmi_15.html


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

public class B5 extends AppCompatActivity {
    RadioButton d1,d2;
    EditText height,weight3,fat2;
    Button ok5,home5;
    TextView ffmi,result5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b5);
        d1=(RadioButton) findViewById(R.id.d1);
        d2=(RadioButton) findViewById(R.id.d2);
        height=(EditText)findViewById(R.id.height);
        weight3=(EditText)findViewById(R.id.weight3);
        fat2=(EditText)findViewById(R.id.fat2);
        ok5=(Button)findViewById(R.id.ok5);
        home5=(Button)findViewById(R.id.home5);
        ffmi=(TextView)findViewById(R.id.ffmi);
        result5=(TextView)findViewById(R.id.result5);
    }
    public void home5(View v){
        Intent in=new Intent();
        in.setClass(B5.this,MainActivity.class);
        startActivity(in);
    }
    public void ok5(View v){
        try{
        double H=Double.parseDouble(height.getText().toString());
        double W=Double.parseDouble(weight3.getText().toString());
        double F2=Double.parseDouble(fat2.getText().toString());
        double FF=(int)((W*(1-F2/100))/Math.pow(H/100,2)*100)/100.;
        ffmi.setText("您的ffmi指數為:"+FF);

        if(d1.isChecked()){
            if(FF>=28){
                result5.setText("不用藥不可能達到");
            }else if(FF>=26){
                result5.setText("可能有使用禁藥喔!");
            }else if(FF>=23){
                result5.setText("肌肉量很高");
            }else if(FF>=20){
                result5.setText("肌肉量高於平均值");
            }else if(FF>=18){
                result5.setText("肌肉量在平均值");
            }else{
                result5.setText("肌肉量低於平均");
            }
        }else if(d2.isChecked()){
            if(FF>=22){
                result5.setText("不用藥不可能達到");
            }else if(FF>=19){
                result5.setText("肌肉量很高");
            }else if(FF>=17){
                result5.setText("肌肉量高於平均值");
            }else if(FF>=15){
                result5.setText("肌肉量在平均值");
            }else{
                result5.setText("肌肉量低於平均");
            }
        }
        }catch (Exception e){
            Toast t=Toast.makeText(this,"輸入時，請勿空白或輸入非數字或輸入符號",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }
    }
}
//ffmi=[體重*(100%-體脂率)]/身高(m)的平方
/*
男性:

■ 16 – 17: 肌肉量低於平均
■ 18 – 19: 肌肉量在平均值
■ 20 – 21: 肌肉量高於平均值
■ 22: 肌肉量蠻高
■ 23– 25: 肌肉量很高
■ 26 – 27: 肌肉量已經高到有可能有用藥了
■ 28 – 30: 不用藥不可能達到的數值
一般女性的數值大概在15左右，然後超過22的人則很有可能有使用禁藥(類固醇、生長激素等等)
女性:
■ 13 – 14: : 肌肉量低於平均
■ 15 – 16: 肌肉量在平均值
■ 17 – 18: 肌肉量高於平均值
■ 19 – 21: 肌肉量很高
■ > 22: 不用藥不可能達到的數值
 */