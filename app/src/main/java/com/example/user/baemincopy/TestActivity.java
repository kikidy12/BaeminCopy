package com.example.user.baemincopy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import net.daum.mf.map.api.MapView;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

//다음이 제공하는 MapView객체 생성 및 API Key 설정
 MapView mapView = new MapView(this);
        //xml에 선언된 map_view 레이아웃을 찾아온 후, 생성한 MapView객체 추가
         RelativeLayout container = (RelativeLayout) findViewById(R.id.map_view);
        container.addView(mapView);

    }
}
