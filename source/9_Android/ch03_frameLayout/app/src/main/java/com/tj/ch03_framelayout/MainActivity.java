package com.tj.ch03_framelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ScrollView sView1, sView2;
    private int idx = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        sView1 = (ScrollView)findViewById(R.id.sView1);
        sView2 = (ScrollView)findViewById(R.id.sView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idx==0){
                    sView2.setVisibility(View.VISIBLE);
                    sView1.setVisibility(View.INVISIBLE);
                    idx=1;
                }else if(idx==1){
                    sView1.setVisibility(View.VISIBLE);
                    sView2.setVisibility(View.INVISIBLE);
                    idx = 0;
                }
            }
        });
    }
}
