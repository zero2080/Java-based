package com.tj.ch01_hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClicked(View view){
        Toast.makeText(getApplicationContext(),
                "시작합니다", Toast.LENGTH_SHORT).show();
    }
}
