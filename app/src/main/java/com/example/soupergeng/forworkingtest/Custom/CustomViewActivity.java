package com.example.soupergeng.forworkingtest.Custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.soupergeng.forworkingtest.R;

/**
 * Created by AB055833 on 2017/8/16.
 * Email  ab055833gengkunzhou@ab-insurance.com
 */

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customview_layout);
        setTitle("自定义View");
    }
}
