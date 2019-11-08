package com.example.gestureflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    ViewFlipper viewFlipper;
    GestureDetector detector;               //定义手势检测器实例
    final int FLIP_DISTANCE = 50;                       //手势动作两点之间最小的距离

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detector = new GestureDetector(this,this);
        viewFlipper = findViewById(R.id.flipper);

        viewFlipper.addView(addImageView(R.drawable.a));                //为ViewFlipper组件添加6个图片
        viewFlipper.addView(addImageView(R.drawable.b));
        viewFlipper.addView(addImageView(R.drawable.c));
        viewFlipper.addView(addImageView(R.drawable.d));
        viewFlipper.addView(addImageView(R.drawable.e));
        viewFlipper.addView(addImageView(R.drawable.f));


    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        //如果第一个触电事件的x坐标大于第二个触电事件的x坐标超过50，就代表是手势从右向左滑动
        if (motionEvent.getX() - motionEvent1.getX() > FLIP_DISTANCE){
            viewFlipper.showPrevious();
            return true;
        }else if (motionEvent1.getX() - motionEvent.getX() > FLIP_DISTANCE){
            viewFlipper.showNext();
            return true;
        }

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //将该Activity上得触摸事件交给GestureDetector处理

        return detector.onTouchEvent(event);
    }

    private View addImageView(int resId){
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(resId);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        return imageView;
    }

}
