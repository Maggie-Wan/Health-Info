package com.example.student.health;
//https://kknews.cc/zh-tw/health/9z299b.html
//https://www.beforeout.com/article/138670.html
//https://www.i-fit.com.tw/context/227.html
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

public class B4 extends AppCompatActivity {
    RadioButton c1,c2;
    EditText waist2,weight2,age;
    Button ok4,home4;
    TextView fat,result4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b4);
        c1=(RadioButton) findViewById(R.id.c1);
        c2=(RadioButton) findViewById(R.id.c2);
        waist2=(EditText)findViewById(R.id.waist2);
        weight2=(EditText)findViewById(R.id.weight2);
        age=(EditText)findViewById(R.id.age);
        ok4=(Button)findViewById(R.id.ok4);
        home4=(Button)findViewById(R.id.home4);
        fat=(TextView)findViewById(R.id.fat);
        result4=(TextView)findViewById(R.id.result4);
    }
    public void home4(View v){
        Intent in=new Intent();
        in.setClass(B4.this,MainActivity.class);
        startActivity(in);
    }
    public void ok4(View v){
        try{
        double WA=Double.parseDouble(waist2.getText().toString());
       double WE=Double.parseDouble(weight2.getText().toString());
       double a=WA*0.74;
       double b=0;
       int AGE=Integer.parseInt(age.getText().toString());

       if(c1.isChecked()){
           b=(WE*0.082)+44.74;
       }else if(c2.isChecked()){
           b=(WE*0.082)+34.89;
       }
       double totalFat=a-b;
       double FAT=(int)((totalFat/WE)*100)/100.;

       fat.setText("您的體指率為:"+FAT);

        if(c1.isChecked()){
          if(AGE>=30){
            if(FAT>=0.25){
                result4.setText("您的體脂率已超標，為肥胖體型");
            }else if(FAT>=0.17){
                result4.setText("您的體脂率為標準值");
            }else {
                result4.setText("您的體脂率低於標準值");
            }
          }else{
              if(FAT>=0.20){
                  result4.setText("您的體脂率已超標，為肥胖體型");
              }else if(FAT>=0.14){
                  result4.setText("您的體脂率為標準值");
              }else {
                  result4.setText("您的體脂率低於標準值");
              }
          }
        }else if(c2.isChecked()){
            if(AGE>=30){
                if(FAT>=0.30){
                    result4.setText("您的體脂率已超標，為肥胖體型");
                }else if(FAT>=0.20){
                    result4.setText("您的體脂率為標準值");
                }else {
                    result4.setText("您的體脂率低於標準值");
                }
            }else{
                if(FAT>=0.25){
                    result4.setText("您的體脂率已超標，為肥胖體型");
                }else if(FAT>=0.17){
                    result4.setText("您的體脂率為標準值");
                }else {
                    result4.setText("您的體脂率低於標準值");
                }
            }
        }
        }catch (Exception e){
            Toast t=Toast.makeText(this,"輸入時，請勿空白或輸入非數字或輸入符號",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }

    }
}
/*1、女性的身體脂肪公式
參數a = 腰圍-公分(腰部的周長) x 0.74
參數b = (總體重-公斤 x 0.082) + 34.89
身體脂肪總重量-公斤 = a - b
身體脂肪百分比= (身體脂肪總重量÷ 體重) x 100%
2、男性的身體脂肪公式
參數a = 腰圍-公分 x 0.74
參數b = (體重-公斤 x 0.082) + 44.74
身體脂肪總重量-公斤= a - b
體脂率(身體脂肪百分比) = (身體脂肪總重量÷ 體重) x 100%

理想的體脂肪率，男性30歲以下為 14-20%，30歲以上為17-23%；女性 30歲以下為17-24%，30歲以上20-27%。男性體脂肪若超過25%，女性若超過30%則可判定為肥胖。
30 歲以下男性 ≧ 20％、女性 ≧ 25％，30 歲以上男性 ≧ 25％、女性 ≧ 30％，即為肥胖。
原文網址：https://kknews.cc/zh-tw/health/9z299b.html


          }else if(AGE>=30 && FAT>=0.17){

          }else if(AGE>=30 && FAT>=0){

*/