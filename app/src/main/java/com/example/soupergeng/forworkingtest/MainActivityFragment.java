package com.example.soupergeng.forworkingtest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private Button mCustomViewBtn;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCustomViewBtn = (Button) view.findViewById(R.id.custom_btn);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListner();
    }

    private void setListner() {
        mCustomViewBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int vId = view.getId();
        switch (vId){
            case R.id.custom_btn:
                startAct();
                break;
            default:
                break;
        }
    }

    private void startAct() {
        Intent intent = new Intent();
        intent.setClass(getContext(),CustomViewActivity.class);
        startActivity(intent);
    }
}
