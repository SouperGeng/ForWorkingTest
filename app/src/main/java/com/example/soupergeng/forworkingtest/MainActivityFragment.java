package com.example.soupergeng.forworkingtest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.soupergeng.forworkingtest.Custom.CustomViewActivity;
import com.example.soupergeng.forworkingtest.LearnRxjava2.ui.LearnRxJava2Activity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {

    private Button mCustomViewBtn;
    private Button mRxJavaBtn;
    private Button mDialogBtn;
    private Button mRecylerBtn;

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
        mRxJavaBtn = (Button) view.findViewById(R.id.rxjava_btn);
        mDialogBtn = (Button) view.findViewById(R.id.dialog_btn);
        mRecylerBtn = (Button) view.findViewById(R.id.recyler_btn);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListner();
    }

    private void setListner() {
        mCustomViewBtn.setOnClickListener(this);
        mRxJavaBtn.setOnClickListener(this);
        mDialogBtn.setOnClickListener(this);
        mRecylerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int vId = view.getId();
        switch (vId){
            case R.id.custom_btn:
                startAct();
                break;
            case R.id.rxjava_btn:
                startRxJava();
                break;
            case R.id.dialog_btn:
                openDialog();
                break;
            case R.id.recyler_btn:
                startRecycler();
                break;
            default:
                break;
        }
    }

    private void startRecycler() {
        startActivity(new Intent(getActivity(),DiscoryActivity.class));
    }

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("请根据您的具体情况，声明您及被保险人是否“仅为中国税收居民”");
        builder.setMessage("* 提示：\n" + "\n" + "1、若您和被保险人均“仅为中国税收居民”，则请选择“是”；若您和被保险人其中一人或均不符合“仅为中国税收居民”条件，请选“否”；\n" + "\n" + "2、“仅为中国税收居民”即指不再具有任何非中国大陆地区以外的任何国家/地区的税收居民身份；\n" + "\n" + "3、中国税收居民是指在中国境内有住所，或者无住所而在境内居住满一年的个人。在中国境内有住所是指因户籍、家庭、经济利益关系而在中国境内习惯性居住。在境内居住满一年，是指在一个纳税年度中在中国境内居住365日。临时离境的，不扣减日数。临时离境，是指在一个纳税年度中一次不超过30日或者多次累计不超过90日的离境。");
        builder.setCancelable(false);
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("如果您或者被保险人不是“仅为中国税收居民身份”，根据监管要求本公司暂时无法向您提供在线购买产品服务，建议您前往我公司的就近网点通过线下渠道进行购买。如您有任何疑问，欢迎拨打95569与我们取得联系。非常感谢您的支持与理解。");
                builder.setCancelable(false);
                builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
            }
        }).setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
    }

    private void startAct() {
        Intent intent = new Intent();
        intent.setClass(getContext(),CustomViewActivity.class);
        startActivity(intent);
    }
    private void startRxJava() {
        Intent intent = new Intent();
        intent.setClass(getContext(),LearnRxJava2Activity.class);
        startActivity(intent);
    }
}
