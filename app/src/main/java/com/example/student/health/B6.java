package com.example.student.health;
//https://www.taiwannutrition.com/blog/about-bmr-tdee-cutting-bulking/
//https://www.iifym.com/iifym-calculator/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class B6 extends AppCompatActivity {
    RadioButton e1,e2;
    EditText height2,weight4,age2;
    Button ok6,home6;
    TextView bmr,tedd;
    Spinner spn;
    String [] x={"久坐族／無運動習慣者","輕度運動者／一周一至三天運動",
            "中度運動者／一周三至五天運動","激烈運動者／一周六至七天運動","超激烈運動者／體力活的工作／一天訓練兩次"};
    //變數a要在最上面宣告，後面才能使用
    double a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b6);
        e1=(RadioButton) findViewById(R.id.e1);
        e2=(RadioButton) findViewById(R.id.e2);
        height2=(EditText)findViewById(R.id.height2);
        weight4=(EditText)findViewById(R.id.weight4);
        age2=(EditText)findViewById(R.id.age2);
        ok6=(Button)findViewById(R.id.ok6);
        home6=(Button)findViewById(R.id.home6);
        bmr=(TextView)findViewById(R.id.bmr);
        tedd=(TextView)findViewById(R.id.tedd);
        spn=(Spinner)findViewById(R.id.spn);
        ArrayAdapter<String> ada=new ArrayAdapter<String>(
          this,android.R.layout.simple_spinner_item,x);
        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(ada);
        spn.setOnItemSelectedListener(L1);

    }
    Spinner.OnItemSelectedListener L1=new Spinner.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> adp, View view, int i, long l) {
            String msg=adp.getSelectedItem().toString();
            if(msg.equals("久坐族／無運動習慣者")){
                a=1.2;
            }else if(msg.equals("輕度運動者／一周一至三天運動")){
                a=1.375;
            }else if(msg.equals("中度運動者／一周三至五天運動")){
                a=1.55;
            }else if(msg.equals("激烈運動者／一周六至七天運動")){
                a=1.725;
            }else if(msg.equals("超激烈運動者／體力活的工作／一天訓練兩次")){
                a=1.9;
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    };
    public void home6(View v){
        Intent in=new Intent();
        in.setClass(B6.this,MainActivity.class);
        startActivity(in);
    }

    public void ok6(View v){
        try{
        double H=Double.parseDouble(height2.getText().toString());
        double W=Double.parseDouble(weight4.getText().toString());
        double A=Double.parseDouble(age2.getText().toString());
        double BMR=0;

        if(e1.isChecked()){
            BMR=10*W+6.25*H-5*A+5;
        }else if(e2.isChecked()){
            BMR=10*W+6.25*H-5*A-161;
        }
;
        bmr.setText("基礎代謝率為："+BMR+"大卡");
        tedd.setText("每日消耗熱量為:"+(BMR*a)+"大卡");

        }catch (Exception e){
            Toast t=Toast.makeText(this,"輸入時，請勿空白或輸入非數字或輸入符號",Toast.LENGTH_SHORT);
            t.setGravity(Gravity.CENTER,0,0);
            t.show();
        }
    }
}
/*
活動程度數值	描述
1.2	久坐族／無運動習慣者
1.375	輕度運動者／一周一至三天運動
1.55	中度運動者／一周三至五天運動
1.725	激烈運動者／一周六至七天運動
1.9	超激烈運動者／體力活的工作／一天訓練兩次

男人

基礎代謝率 ＝ 10 x 【體重公斤】 + 6.25 x 【身高公分】 – 5 x 【年紀】 + 5

女人

基礎代謝率 ＝ 10 x 【體重公斤】 + 6.25 x 【身高公分】 – 5 x 【年紀】 -161

*/