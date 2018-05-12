package com.example.spirit.spannablestringdemo;

import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Demo3 extends Activity {

//    private double disDown;
//    private ImageView img;
//    private LinearLayout parent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        img = findViewById(R.id.img);
//        parent = findViewById(R.id.parent);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        int pointerCount = event.getPointerCount();
//
//        if ((MotionEvent.ACTION_MASK & event.getAction()) == MotionEvent.ACTION_POINTER_DOWN) {
//            PointF point = getPoint(event);
//            disDown = Math.sqrt(point.x * point.x + point.y * point.y);
//        }
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_MOVE:
//                if (pointerCount == 2) {
//                    PointF point = getPoint(event);
//                    double disMove = Math.sqrt(point.x * point.x + point.y * point.y);
//                    double direction = disMove - disDown;
//                    disDown = disMove;
//
//                    ViewGroup.LayoutParams layoutParams = img.getLayoutParams();
//                    layoutParams.width += direction;
//                    layoutParams.height += direction;
//                    if (layoutParams.width < 10) {
//                        layoutParams.width = 10;
//                        layoutParams.height = 10;
//                        toast();
//                    } else if (layoutParams.width > 2666) {
//                        layoutParams.width = 2666;
//                        layoutParams.height = 2666;
//                        toast();
//                    }
//                    System.out.println(layoutParams.width);
//                    img.setLayoutParams(layoutParams);
//                }
//                break;
//        }
//        return true;
//    }
//
//    private PointF getPoint(MotionEvent event) {
//        float disDownX = event.getX(1) - event.getX(0);
//        float disDownY = event.getY(1) - event.getY(0);
//        return new PointF(disDownX, disDownY);
//    }
//
//    private void toast() {
//        Toast.makeText(this, "长路漫漫，总有尽头", Toast.LENGTH_SHORT).show();
//    }
}
