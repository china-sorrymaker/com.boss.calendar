package com.boss.calendar;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.boss.calendar.R; // 准确定位

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView = findViewById(R.id.calendarView);
        TextView tvDate = findViewById(R.id.tv_selected_date);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // 月份从 0 开始，所以 +1
            String date = year + "-" + (month + 1) + "-" + dayOfMonth;
            tvDate.setText(date);
        });
    }
}
