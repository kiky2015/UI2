package com.nick.ui2.FoldableLayout.activities;

import android.os.Bundle;
import android.view.View;

import com.alexvasilkov.android.commons.utils.Views;
import com.alexvasilkov.foldablelayout.FoldableListLayout;
import com.nick.ui2.FoldableLayout.items.PaintingsAdapter;
import com.nick.ui2.R;
public class FoldableListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foldable_list);
        FoldableListLayout foldableListLayout = Views.find(this, R.id.foldable_list);
        foldableListLayout.setAdapter(new PaintingsAdapter(this));
    }

    public void back(View v) {
        finish();
        overridePendingTransition(R.anim.push_up_in,R.anim.push_up_out);
    }

}
