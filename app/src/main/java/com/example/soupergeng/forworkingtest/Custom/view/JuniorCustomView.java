package com.example.soupergeng.forworkingtest.Custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by AB055833 on 2017/8/16.
 * Email  ab055833gengkunzhou@ab-insurance.com
 *
 * 初级自定义View练习
 *   自定义绘制的方式是重写绘制方法，其中最常用的是 onDraw()
     绘制的关键是 Canvas 的使用
     Canvas 的绘制类方法： drawXXX() （关键参数：Paint）
     Canvas 的辅助类方法：范围裁切和几何变换
     可以使用不同的绘制方法来控制遮盖关系
 *
 */

public class JuniorCustomView extends View {

    private Paint mPaint;

    public JuniorCustomView(Context context) {
        this(context,null);
    }

    public JuniorCustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public JuniorCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化画笔和其他
     * Paint.setStyle(Style style) 设置绘制模式
     Paint.setColor(int color) 设置颜色
     Paint.setStrokeWidth(float width) 设置线条宽度
     Paint.setTextSize(float textSize) 设置文字大小
     Paint.setAntiAlias(boolean aa) 设置抗锯齿开关
     */

    private void init() {
        mPaint = new Paint();
        //设置画笔颜色
        mPaint.setColor(Color.RED);
        //是否抗锯齿
        mPaint.setAntiAlias(true);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //会在原有的绘制效果上加一层半透明的遮罩
        canvas.drawColor(Color.parseColor("#88110011"));
        //画矩形
        canvas.drawRect(100,100,200,200,mPaint);
        mPaint.setStrokeWidth(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(400,100,500,200,mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        //画圆
        canvas.drawCircle(100, 400, 100, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(350, 400, 100, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(2.0f);
        mPaint.setAntiAlias(false);
        canvas.drawCircle(600, 400, 100, mPaint);

        //画点
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(20);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(100,600,mPaint);

        //画椭圆
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(1);
        mPaint.setAntiAlias(true);
        canvas.drawOval(100,700,450,800,mPaint);

        //画线
        canvas.drawLine(100,750,450,750,mPaint);

        //画多个线条  汉字  工字
        float[] points = {20, 800, 120, 800, 70, 800, 70, 920, 20, 920, 120, 920};
        canvas.drawLines(points,mPaint);

        //画圆角矩形
        RectF rectF = new RectF(600,600,900,900);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(rectF,50,50,mPaint);

        //绘制弧形或扇形
        mPaint.setColor(Color.RED);
        RectF rectG = new RectF(100.0f,1000.0f,500.0f,1400.0f);
        canvas.drawArc(rectG,-120,20,true,mPaint);
        canvas.drawArc(rectG,20,140,false,mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectG,180,45,true,mPaint);

        //绘制自定义图形
        Path path = new Path();
        mPaint.setStyle(Paint.Style.FILL);
        // 第一组
        path.addCircle(650,1150,100, Path.Direction.CW);
        canvas.drawPath(path,mPaint);
        // 第二组
        Path path1 = new Path();
        path1.moveTo(650,1300);
        mPaint.setColor(Color.CYAN);
        mPaint.setStrokeWidth(20);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);
        path1.lineTo(750,1300);
        path1.rLineTo(100,-100);
        canvas.drawPath(path1,mPaint);



    }
}
