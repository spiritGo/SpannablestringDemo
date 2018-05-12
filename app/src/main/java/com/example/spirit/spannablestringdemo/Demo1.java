package com.example.spirit.spannablestringdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

public class Demo1 extends Activity {

    private int width;
    private int height;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        final ImageView img = findViewById(R.id.img);
        img.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
                .OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                width = img.getWidth();
                height = img.getHeight();
                img.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                System.out.println(width + ", " + height);
            }
        });


        GestureDetector detector = new GestureDetector(this, new GestureDetector
                .OnGestureListener() {
            //用户按下屏幕就会触发；
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            //如果是按下的时间超过瞬间，而且在按下的时候没有松开或者是拖动的，那么onShowPress就会执行
            @Override
            public void onShowPress(MotionEvent e) {

            }

            //一次单独的轻击抬起操作,也就是轻击一下屏幕，立刻抬起来，才会有这个触发，当然,如果除了Down以外
            // 还有其它操作,那就不再算是Single操作了,所以也就不会触发这个事件
            //点击一下非常快的（不滑动）Touchup：
            //onDown->onSingleTapUp->onSingleTapConfirmed
            //点击一下稍微慢点的（不滑动）Touchup：
            //onDown->onShowPress->onSingleTapUp->onSingleTapConfirmed
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            //在屏幕上拖动事件。无论是用手拖动view，或者是以抛的动作滚动，都会多次触发,这个方法
            // 在ACTION_MOVE动作发生时就会触发
            // 滑屏：手指触动屏幕后，稍微滑动后立即松开
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float
                    distanceY) {
                return false;
            }

            //长按触摸屏，超过一定时长，就会触发这个事件    触发顺序：    onDown->onShowPress->onLongPress
            @Override
            public void onLongPress(MotionEvent e) {

            }

            //滑屏，用户按下触摸屏、快速移动后松开，由1个MotionEvent ACTION_DOWN, 多个ACTION_MOVE, 1个ACTION_UP触发
            //参数解释：
            //e1：第1个ACTION_DOWN MotionEvent
            //e2：最后一个ACTION_MOVE MotionEvent
            //velocityX：X轴上的移动速度，像素/秒
            //velocityY：Y轴上的移动速度，像素/秒
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float
                    velocityY) {
                return false;
            }
        });
    }
}
