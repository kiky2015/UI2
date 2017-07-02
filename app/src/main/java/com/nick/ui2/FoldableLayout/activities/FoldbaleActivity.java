package com.nick.ui2.FoldableLayout.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.alexvasilkov.android.commons.adapters.ItemsAdapter;
import com.alexvasilkov.android.commons.utils.Views;
import com.nick.ui2.R;

import java.util.ArrayList;
import java.util.List;

public class FoldbaleActivity extends BaseActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.foldablelayout);

        ListView listView = Views.find(this, R.id.main_list);
        List<String> list = new ArrayList<>();
        list.add("FoldableListActivity");
        list.add("UnfoldableDetailsActivity");
        listView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,list));
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        Class[] cls = {FoldableListActivity.class,UnfoldableDetailsActivity.class};
        intent = new Intent(this,cls[position]);
        startActivity(intent);
    }

    public void back(View v) {
        finish();
        overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
    }
}
