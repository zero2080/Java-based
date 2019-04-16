package com.tj.ch06_caltimepicker;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private Button btnStart, btnEnd;
    private RadioButton rdoCal, rdoTime;
    private CalendarView calendarView;
    private TimePicker   timePicker;
    private TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    private long pauseTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("수명주기 및 고급 위젯 예제");
        Log.i("★ 메인액티비티 생명주기 ★", "onCreate() 호출됨");
        chronometer = (Chronometer)findViewById(R.id.chronometer);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnEnd = (Button)findViewById(R.id.btnEnd);
        rdoCal = (RadioButton)findViewById(R.id.rdoCal);
        rdoTime = (RadioButton)findViewById(R.id.rdoTime);
        calendarView = (CalendarView)findViewById(R.id.calendarView);
        timePicker   = (TimePicker)findViewById(R.id.timePicker);
        tvYear = (TextView)findViewById(R.id.tvYear);
        tvMonth = (TextView)findViewById(R.id.tvMonth);
        tvDay = (TextView)findViewById(R.id.tvDay);
        tvHour = (TextView)findViewById(R.id.tvHour);
        tvMinute = (TextView)findViewById(R.id.tvMinute);
        calendarView.setVisibility(View.INVISIBLE); // 안보이게
        timePicker.setVisibility(View.INVISIBLE);   // 안보이게
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.setVisibility(View.VISIBLE); // 캘렌더뷰 보이게
                timePicker.setVisibility(View.INVISIBLE); // timePicker는 안보이게
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendarView.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view,
                                            int year, int month, int dayOfMonth) {
                tvYear.setText(String.valueOf(year));
                tvMonth.setText(String.valueOf(month));
                tvDay.setText(String.valueOf(dayOfMonth));
                tvYear.setTextColor(Color.BLUE);
                tvMonth.setTextColor(Color.BLUE);
                tvDay.setTextColor(Color.BLUE);
            }
        });
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                tvHour.setText(String.valueOf(hourOfDay));
                tvMinute.setText(Integer.toString(minute));
                tvHour.setTextColor(Color.BLUE);
                tvMinute.setTextColor(Color.BLUE);
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SystemClock.elapsedRealtime() : 지금현재의 clockTime(밀리세컨)
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLACK);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("★ 메인액티비티 생명주기 ★", "onStart() 호출됨");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("★ 메인액티비티 생명주기 ★", "onResume() 호출됨");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("★ 메인액티비티 생명주기 ★", "onPause() 호출됨");
        // 중지 상태일 때 타이머를 멈추고 멈춘 시간을 pauseTime 변수에 저장
        pauseTime = SystemClock.elapsedRealtime() - chronometer.getBase();
        chronometer.stop();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("★ 메인액티비티 생명주기 ★", "onStop() 호출됨");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("★ 메인액티비티 생명주기 ★", "onRestart() 호출됨");
        // 중지상태에서 멈춘 chronometer를 pauseTime부터 다시 재개
        chronometer.setBase(SystemClock.elapsedRealtime()-pauseTime);
        chronometer.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("★ 메인액티비티 생명주기 ★", "onDestroy() 호출됨");
    }
}
