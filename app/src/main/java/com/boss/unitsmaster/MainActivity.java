// 必须和你的文件夹路径 app/src/main/java/com/boss/unitsmaster/ 对齐
package com.boss.unitsmaster; 

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
// 关键：虽然你在 unitsmaster 包里，但你要引用的 R 是根据 build.gradle 生成的
import com.boss.calendar.R; 

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView = findViewById(R.id.calendarView);
        TextView tvDate = findViewById(R.id.tv_selected_date);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // 这里建议用上我们 language_init.py 生成的多语言标签
            String label = getString(R.string.tv_date_label);
            String date = year + "-" + (month + 1) + "-" + dayOfMonth;
            tvDate.setText(label + date);
        });
    }
}
