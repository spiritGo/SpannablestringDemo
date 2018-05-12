package com.example.spirit.spannablestringdemo;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MImageView extends LinearLayout {

    private ViewDragHelper viewDragHelper;
    private View child0;
    private double disDown;
    private int measuredHeight;
    private int measuredWidth;

    public MImageView(Context context) {
        super(context);
        init();
    }

    public MImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        viewDragHelper = ViewDragHelper.create(this, callback);
    }

    private ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(@NonNull View child, int pointerId) {
            return child == child0;
        }

        @Override
        public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
            return left;
        }

        @Override
        public int getViewHorizontalDragRange(@NonNull View child) {
            return super.getViewHorizontalDragRange(child);
        }

        @Override
        public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
            return top;
        }

        @Override
        public int getViewVerticalDragRange(@NonNull View child) {
            return super.getViewVerticalDragRange(child);
        }
    };

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        child0 = getChildAt(0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return viewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        measuredWidth = child0.getMeasuredWidth();
        measuredHeight = child0.getMeasuredHeight();
        System.out.println("measuredHeight:"+measuredHeight);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        viewDragHelper.processTouchEvent(event);
        int pointerCount = event.getPointerCount();

        if ((MotionEvent.ACTION_MASK & event.getAction()) == MotionEvent.ACTION_POINTER_DOWN) {
            PointF point = getPoint(event);
            disDown = Math.sqrt(point.x * point.x + point.y * point.y);
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                if (pointerCount == 2) {
                    PointF point = getPoint(event);
                    double disMove = Math.sqrt(point.x * point.x + point.y * point.y);
                    double direction = disMove - disDown;
                    disDown = disMove;

                    measuredWidth += direction;
                    measuredHeight += direction;
                    ViewGroup.LayoutParams layoutParams = child0.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
//                    System.out.println(layoutParams.width);
                    if (measuredWidth > 10) {
                        child0.setLayoutParams(layoutParams);
                    }
                }
                break;
        }
        return true;
    }

    private PointF getPoint(MotionEvent event) {
        float disDownX = event.getX(1) - event.getX(0);
        float disDownY = event.getY(1) - event.getY(0);
        return new PointF(disDownX, disDownY);
    }
}
