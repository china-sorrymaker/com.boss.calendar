package com.boss.unitsmaster; // 1. 严格对齐物理路径

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
// 2. 删掉 import com.boss.calendar.R，因为就在本包下，不需要导包

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 3. 这里会自动去找 com.boss.unitsmaster.R
        setContentView(R.layout.activity_main);

        CalendarView calendarView = findViewById(R.id.calendarView);
        TextView tvDate = findViewById(R.id.tv_selected_date);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // 获取我们 language_init.py 脚本生成的翻译
            // 如果报错找不到 tv_date_label，说明脚本还没跑或者 XML 没对上
            try {
                String label = getString(R.string.tv_date_label);
                String date = year + "-" + (month + 1) + "-" + dayOfMonth;
                tvDate.setText(label + date);
            } catch (Exception e) {
                tvDate.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
            }
        });
    }
}
