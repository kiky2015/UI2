package com.nick.ui2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.nick.ui2.FoldableLayout.activities.FoldbaleActivity;
import com.nick.ui2.activity.ActivityButton;
import com.nick.ui2.activity.CircleActivity;
import com.nick.ui2.activity.CollapseCalendarActivity;
import com.nick.ui2.activity.FloatingActivity;
import com.nick.ui2.activity.ProgressActivity;
import com.nick.ui2.activity.SpringActivity;
import com.yalantis.euclid.library.EuclidActivity;
import com.yalantis.euclid.library.EuclidListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends EuclidActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class[] aa = {SpringActivity.class,FoldbaleActivity.class, ActivityButton.class,
                        FloatingActivity.class,CollapseCalendarActivity.class, ProgressActivity.class,
                        CircleActivity.class};
                Intent intent = new Intent(MainActivity.this, aa[selectPosition]);
                startActivity(intent);
            }
        });
    }

    @Override
    protected BaseAdapter getAdapter() {
        Map<String, Object> profileMap;
        List<Map<String, Object>> profilesList = new ArrayList<>();

        int[] avatars = {
                R.drawable.anastasia,
                R.drawable.andriy,
                R.drawable.dmitriy,
                R.drawable.dmitry_96,
                R.drawable.ed,
                R.drawable.illya,
                R.drawable.kirill,
                };
        String[] names = getResources().getStringArray(R.array.array_names);
        String[] namesDescShot = getResources().getStringArray(R.array.desc_shot);
        String[] namesDescLong = getResources().getStringArray(R.array.desc_long);
        for (int i = 0; i < avatars.length; i++) {
            profileMap = new HashMap<>();
            profileMap.put(EuclidListAdapter.KEY_AVATAR, avatars[i]);
            profileMap.put(EuclidListAdapter.KEY_NAME, names[i]);
            profileMap.put(EuclidListAdapter.KEY_DESCRIPTION_SHORT, namesDescShot[i]);
            profileMap.put(EuclidListAdapter.KEY_DESCRIPTION_FULL,namesDescLong[i]);
            profilesList.add(profileMap);
        }

        return new EuclidListAdapter(this, R.layout.list_item, profilesList);
    }

}
