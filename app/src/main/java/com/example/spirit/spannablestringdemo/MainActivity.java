package com.example.spirit.spannablestringdemo;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_spannable;
    private String str = "hello, I am a student!";
    private SpannableString spannableString;
    private ImageView img;
    private int width;
    private int height;
    private double tempHeight;
    private double tempWidth;
    private double v4;
    private double move;
    private ViewGroup.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

////        tv_spannable = findViewById(R.id.tv_spannable);
//        spannableString = new SpannableString(str);
//
////        ForegroundColorSpanDemo();
//        img = findViewById(R.id.img);
////        touchEventDemo();
//        img.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
//                .OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                width = img.getLayoutParams().width;
//                height = img.getLayoutParams().height;
//                img.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                tempWidth = width;
//                tempHeight = height;
//                params = img.getLayoutParams();
//            }
//        });
    }


//    private float downY2;
//    private float downX2;
//    private float downY1;
//    private float downx1;
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                downx1 = event.getX();
//                downY1 = event.getY();
//                break;
//            case MotionEvent.ACTION_POINTER_DOWN:
//                downX2 = event.getX();
//                downY2 = event.getY();
//
//                break;
//            case MotionEvent.ACTION_MOVE:
//                if (event.getPointerCount() == 2) {
//                    point3(event);
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//        return true;
//    }
//
//    private void point3(MotionEvent event) {
//
//        float x1 = event.getX(0);
//        float y1 = event.getY(0);
//        float x2 = event.getX(1);
//        float y2 = event.getY(1);
//
//        float moveX = x2 - x1;
//        float moveY = y2 - y1;
//        float downDisX = downX2 - downx1;
//        float downDisY = downY2 - downY1;
//        double sqrt = Math.sqrt(downDisX * downDisX + downDisY * downDisY);
//        double moveSqrt = Math.sqrt(moveX * moveX + moveY * moveY);
//        float v = x1 - downx1;
//        float v1 = y1 - downY1;
//        double moveScale = Math.sqrt(v * v + v1 * v1);
//        if (moveSqrt > sqrt) {
//            System.out.println("放大");
//            moveScale += 0;
//        } else {
//            System.out.println("缩小");
//            moveScale -= moveScale * 2;
//        }
//        System.out.println("moveScale:" + moveScale);
//
//        tempHeight += moveScale;
//        tempWidth += moveScale;
//        System.out.println(tempHeight+", "+tempWidth);
//        params.width = (int) tempWidth;
//        params.height = (int) tempHeight;
//        img.setLayoutParams(params);
//
//        downX2 = x2;
//        downx1 = x1;
//        downY1 = y1;
//        downY2 = y2;
//    }

    private void ForegroundColorSpanDemo() {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor
                ("#0099EE"));
        spannableString.setSpan(foregroundColorSpan, 0, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv_spannable.setText(spannableString);
    }
}
