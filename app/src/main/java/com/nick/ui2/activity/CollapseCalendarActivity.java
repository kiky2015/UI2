package com.nick.ui2.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.wefika.calendar.CollapseCalendarView;
import com.wefika.calendar.manager.CalendarManager;

import org.joda.time.LocalDate;
import com.nick.ui2.R;

public class CollapseCalendarActivity extends Activity {

    private CollapseCalendarView mCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse_calendar);

        CalendarManager manager = new CalendarManager(LocalDate.now(), CalendarManager.State.MONTH, LocalDate.now(), LocalDate.now().plusYears(1));

        mCalendarView = (CollapseCalendarView) findViewById(R.id.calendar);
        mCalendarView.init(manager);
    }

    public void back(View v) {
        finish();
        overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
    }
}
