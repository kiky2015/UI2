package com.nick.ui2.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.common.collect.Lists;

import java.util.List;

import github.chenupt.multiplemodel.viewpager.ModelPagerAdapter;
import github.chenupt.multiplemodel.viewpager.PagerModelManager;
import github.chenupt.springindicator.SpringIndicator;
import github.chenupt.springindicator.viewpager.ScrollerViewPager;
import com.nick.ui2.fragment.GuideFragment;
import com.nick.ui2.R;

public class SpringActivity extends AppCompatActivity {

    ScrollerViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spring_fragment);

        viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);
        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
        PagerModelManager manager = new PagerModelManager();
        manager.addCommonFragment(GuideFragment.class, getBgRes(), getTitles());
        ModelPagerAdapter adapter = new ModelPagerAdapter(getSupportFragmentManager(), manager);
        viewPager.setAdapter(adapter);
        viewPager.fixScrollSpeed();

        // just set viewPager
        springIndicator.setViewPager(viewPager);
    }

    private List<String> getTitles(){
        return Lists.newArrayList("1", "2", "3", "4");
    }

    private List<Integer> getBgRes(){
        return Lists.newArrayList(Color.parseColor("#ffffff"), Color.parseColor("#ffcc00"), Color.parseColor("#ccccaa"), Color.parseColor("#6655aa"));
    }

    public void back(View v) {
        finish();
        overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
    }
}
