package com.example.user.baemincopy;

import android.os.Bundle;
import android.widget.ListView;

import com.example.user.baemincopy.adapters.FoodAdapter;
import com.example.user.baemincopy.utils.GlobalData;

public class MainActivity extends BaseActivity {

    FoodAdapter mAdapter;

    private android.widget.ListView ultraListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //d adadasdasd
        BindViews();
        SetValues();
        SetUpEvents();
    }

    @Override
    public void SetUpEvents() {
    }

    @Override
    public void SetValues() {
        mAdapter = new FoodAdapter(mContext, GlobalData.foodDataList);
        ultraListView.setAdapter(mAdapter);
    }

    @Override
    public void BindViews() {
        this.ultraListView = (ListView) findViewById(R.id.ultraListView);
    }
}
