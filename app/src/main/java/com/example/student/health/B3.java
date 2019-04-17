package com.example.student.health;
//http://163.20.103.193/~chen06/b/conclusion.htm
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

public class B3 extends AppCompatActivity {
    RadioButton b1,b2;
    EditText waist,butt;
    Button ok3,home3;
    TextView wb,result3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b3);
        b1=(RadioButton) findViewById(R.id.b1);
        b2=(RadioButton) findViewById(R.id.b2);
        waist=(EditText)findViewById(R.id.waist);
        butt=(EditText)findViewById(R.id.butt);
        ok3=(Button)findViewById(R.id.ok3);
        home3=(Button)findViewById(R.id.home3);
        wb=(TextView)findViewById(R.id.wb);
        result3=(TextView)findViewById(R.id.result3);

        ok3.setOnClickListener(cal1);
        home3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent();
                in.setClass(B3.this, MainActivity.class);
                startActivity(in);
            }
        });

    }
    private Button.OnClickListener cal1=new Button.OnClickListener(){
        public void onClick(View view) {
            try{
            double W=Double.parseDouble(waist.getText().toString());
            double B=Double.parseDouble(butt.getText().toString());
            double WB=(int)(W/B*100)/100.;
            if(b1.isChecked()){
               if(WB<=0){
                   result3.setText("您的體脂肪分布為正常值");
               }else{
                   result3.setText("您屬於上半身肥胖型，要注意心血管疾病、高血壓、糖尿病等慢性病的危險");
               }
            }else if(b2.isChecked()){
                if(WB<=0.8){
                    result3.setText("您的體脂肪分布為正常值");
                }else{
                    result3.setText("您屬於上半身肥胖型，要注意心血管疾病、高血壓、糖尿病等慢性病的危險");
                }
            }
            wb.setText("您的腰臀比為："+WB);
            }catch(Exception e){
                Toast t=Toast.makeText(B3.this,"輸入時，請勿空白或輸入非數字或輸入符號",Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER,0,0);
                t.show();
            }
        }
    };

}
