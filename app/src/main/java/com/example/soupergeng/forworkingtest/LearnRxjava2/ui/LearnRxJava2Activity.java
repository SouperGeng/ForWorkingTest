package com.example.soupergeng.forworkingtest.LearnRxjava2.ui;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.soupergeng.forworkingtest.R;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by AB055833 on 2017/10/13.
 * Email  ab055833gengkunzhou@ab-insurance.com
 */

public class LearnRxJava2Activity extends AppCompatActivity {
    private static final String TAG = "LearnRxJava2Activity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        setTitle("学习RxJava");
        Log.e(TAG,"0其他任务在执行");
        observable.subscribeOn(Schedulers.newThread()).subscribe(observer);
        Log.e(TAG,"1其他任务在执行");
    }

    public static void main(String[] args){
        // 不支持Lamda，暂时不用这个
//        Flowable.just("Hello world").subscribe(System.out::println);
//        Log.e(TAG,"0其他任务在执行");
//        observable.subscribeOn(Schedulers.newThread()).subscribe(observer);
//        Log.e(TAG,"1其他任务在执行");
    }

    Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> e) throws Exception {
//            Thread.sleep(2000);
            SystemClock.sleep(5000);
            Log.e(TAG,"服务员从厨师那取得 扁食   "+Thread.currentThread().getName());
            e.onNext("扁食");
            Log.e(TAG,"服务员从厨师那取得 拌面   "+Thread.currentThread().getName());
            e.onNext("拌面");
            Log.e(TAG,"服务员从厨师那取得 蒸饺   "+Thread.currentThread().getName());
            e.onNext("蒸饺");
            Log.e(TAG,"厨师告知服务员菜上好了   "+Thread.currentThread().getName());
            e.onComplete();
        }
    });

    Observer<String> observer = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {
            Log.e(TAG,"来个沙县套餐！！！   "+Thread.currentThread().getName());
        }

        @Override
        public void onNext(String s) {
            Log.e(TAG,"服务员端给顾客  " + s  +    Thread.currentThread().getName());
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {
            Log.e(TAG,"服务员告诉顾客菜上好了   "+Thread.currentThread().getName());
        }
    };







}
