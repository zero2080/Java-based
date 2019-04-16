package com.tj.ch04_cal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private Button btnCE, btnC, btnDel;
    private Button btnAdd, btnSub, btnMul, btnDiv, btnResult;
    private Button btnPoint;
    private Button[] btnNum = new Button[10];
    private int[] ids = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3,
            R.id.btnNum4, R.id.btnNum5, R.id.btnNum6,
            R.id.btnNum7, R.id.btnNum8, R.id.btnNum9};
    private double n1=0, n2=0;
    private String op = ""; // 잠시 연산자를 저장하는 용도
    private String result;  // 연산결과를 저장. 3.0 -> 3
    private boolean power;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCE    = (Button) findViewById(R.id.btnCE);
        btnC     = (Button) findViewById(R.id.btnC);
        btnDel   = (Button) findViewById(R.id.btnDel);
        btnAdd   = (Button) findViewById(R.id.btnAdd);
        btnSub   = (Button) findViewById(R.id.btnSub);
        btnMul   = (Button) findViewById(R.id.btnMul);
        btnDiv   = (Button) findViewById(R.id.btnDiv);
        btnResult= (Button) findViewById(R.id.btnResult);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        for(int i=0 ;i<ids.length ; i++){
            btnNum[i] = (Button)findViewById(ids[i]);
        }
        power = true;
        findViewById(R.id.btnPow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(power){ // 켜져있으면(power==true), 파워를 끝다(power=false)
                    power = false;
                    tvResult.setText("");
                }else{ // 껴져있으면(power==false), 파워를 켠다(power=true)
                    power = true;
                    tvResult.setText("0");
                }
                n1 = 0; n2=0; op=""; //연산을 위한 임시변수들 초기화 작업
                btnCE.setEnabled(power);
                btnC.setEnabled(power);
                btnDel.setEnabled(power);
                btnAdd.setEnabled(power);
                btnSub.setEnabled(power);
                btnMul.setEnabled(power);
                btnDiv.setEnabled(power);
                btnResult.setEnabled(power);
                btnPoint.setEnabled(power);
                for (int i=0 ; i<btnNum.length ; i++){
                    btnNum[i].setEnabled(power);
                }
            }
        });
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n2 = 0;
                tvResult.setText("0");
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=0; n2=0; op="";
                tvResult.setText("0");
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 123.8 -> 123.
                                          // 4 -> 0
                String temp = tvResult.getText().toString();
                int length = temp.length();
                if(length>1){
                    tvResult.setText(temp.substring(0, length-1));
                }else{
                    tvResult.setText("0");
                }
                n2 = Double.parseDouble(tvResult.getText().toString());
            }
        });
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(op.equals("")){
                    n1 = n2;
                }else if(op.equals("+")){
                    n1 += n2;
                }else if(op.equals("-")){
                    n1 -= n2;
                }else if(op.equals("*")){
                    n1 *= n2;
                }else if(op.equals("/")){
                    n1 /= n2;
                }
                op = "";
                n2 = 0;
                result = String.valueOf(n1);
                // 1.011(O)   111.0(X -> 111)
                if(result.indexOf(".0") == result.length()-2){
                    tvResult.setText(result.substring(0, result.length()-2));
                }else{
                    tvResult.setText(result);
                }
                n1=0;
            }
        });
        btnPoint.setOnClickListener(numOnClickListener);
        for(int i=0 ; i<btnNum.length ;i++){
            btnNum[i].setOnClickListener(numOnClickListener);
        }
        btnAdd.setOnClickListener(opOnClickListener);
        btnSub.setOnClickListener(opOnClickListener);
        btnMul.setOnClickListener(opOnClickListener);
        btnDiv.setOnClickListener(opOnClickListener);
    }
    View.OnClickListener opOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(op.equals("")){
                n1 = n2;
            }else if(op.equals("+")){
                n1 += n2;
            }else if(op.equals("-")){
                n1 -= n2;
            }else if(op.equals("*")){
                n1 *= n2;
            }else if(op.equals("/")){
                n1 /= n2;
            }
            op = ((Button)v).getText().toString();
            n2 = 0;
            result = String.valueOf(n1);
            // 1.011(O)   111.0(X -> 111)
            if(result.indexOf(".0") == result.length()-2){
                tvResult.setText(result.substring(0, result.length()-2));
            }else{
                tvResult.setText(result);
            }
        }
    };
    View.OnClickListener numOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(n2==0 && !tvResult.getText().toString().equals("0.") &&
                    !tvResult.getText().toString().equals("0.0") &&
                    !tvResult.getText().toString().equals("0.00")){
                tvResult.setText("");
            }
            switch (v.getId()){
                case R.id.btnNum0:
                case R.id.btnNum1:
                case R.id.btnNum2:
                case R.id.btnNum3:
                case R.id.btnNum4:
                case R.id.btnNum5:
                case R.id.btnNum6:
                case R.id.btnNum7:
                case R.id.btnNum8:
                case R.id.btnNum9:tvResult.append(((Button)v).getText()); break;
                case R.id.btnPoint:
                    if(tvResult.getText().toString().equals("")){
                        tvResult.setText("0.");
                    }else if (tvResult.getText().toString().indexOf(".")==-1){
                        tvResult.append(".");
                    }else{
                        Toast.makeText(getApplicationContext(),
                          "실수에 소수점이 두개면 안돼", Toast.LENGTH_SHORT).show();
                    }
            }
            n2 = Double.parseDouble(tvResult.getText().toString());
        }
    };
}








