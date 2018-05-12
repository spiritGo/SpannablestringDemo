package com.example.spirit.spannablestringdemo;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.widget.Toast;

public class Demo2 extends Activity {
    private double nLenStart = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int nCnt = event.getPointerCount();
        int action = event.getAction();
        if ((action & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_DOWN && 2 == nCnt) {
            for (int i = 0; i < nCnt; i++) {
                float x = event.getX(i);
                float y = event.getY(i);
                Point pt = new Point((int) x, (int) y);
            }

            int xlen = Math.abs((int) event.getX(0) - (int) event.getX(1));
            int ylen = Math.abs((int) event.getY(0) - (int) event.getY(1));
            nLenStart = Math.sqrt((double) xlen * xlen + (double) ylen * ylen);
        } else if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_UP
                && 2 == nCnt) {
            for (int i = 0; i < nCnt; i++) {
                float x = event.getX(i);
                float y = event.getY(i);
                Point pt = new Point((int) x, (int) y);
            }

            int xlen = Math.abs((int) event.getX(0) - (int) event.getX(1));
            int ylen = Math.abs((int) event.getY(0) - (int) event.getY(1));
            double nLenEnd = Math.sqrt((double) xlen * xlen + (double) ylen * ylen);

            //通过两个手指开始距离和结束距离，来判断放大缩小
            if (nLenEnd > nLenStart) {
                Toast.makeText(getApplicationContext(), "放大", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "缩小", Toast.LENGTH_SHORT).show();
            }
            System.out.println(nLenEnd - nLenStart);
        }
        return true;
    }
}

