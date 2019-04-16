package com.tj.ch03_tablegridlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edit1, edit2;
    private Button[] btnNum = new Button[10];
    private int[] ids = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3,
             R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7,
             R.id.BtnNum8, R.id.BtnNum9};
    private Button btnAdd, btnSub, btnMul, btnDiv;
    private TextView textResult;
    private String num1, num2;
    private int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edit1 = (EditText)findViewById(R.id.Edit1);
        edit2 = (EditText)findViewById(R.id.Edit2);
        /*btnNum[0] = (Button)findViewById(R.id.BtnNum0);
        btnNum[9] = (Button)findViewById(R.id.BtnNum9);*/
        for(int i=0 ; i<ids.length ; i++){
            btnNum[i] = (Button)findViewById(ids[i]);
        }
        btnAdd = (Button)findViewById(R.id.BtnAdd);
        btnSub = (Button)findViewById(R.id.BtnSub);
        btnMul = (Button)findViewById(R.id.BtnMul);
        btnDiv = (Button)findViewById(R.id.BtnDiv);
        textResult = (TextView)findViewById(R.id.TextResult);
        for(int i=0 ; i<ids.length ; i++){
            final int idx = i;
            btnNum[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edit1.isFocused()){
                        //edit1.setText(edit1.getText().toString()+btnNum[i].getText());
                        edit1.append(btnNum[idx].getText());
                    }else if(edit2.isFocused()){
                        edit2.append(btnNum[idx].getText());
                    }else{
                        Toast.makeText(getApplicationContext(),
                            "숫자입력에디터에 터치하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("덧셈 계산결과 : "+result);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("뺄셈 계산결과 : "+result);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("곱셈 계산결과 : "+result);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("나눗셈 계산결과 : "+result);
            }
        });
    }
}
















