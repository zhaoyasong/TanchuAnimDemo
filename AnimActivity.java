package com.uitest.zys.kotlindemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class AnimActivity extends AppCompatActivity {
    
    private ImageView mIv_0;
    private ImageView mIv_1;
    private ImageView mIv_2;
    private ImageView mIv_3;
    private ImageView mIv_home;
    private boolean isOpen = false;
    
    private List<View> viewList = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        initView();
    }
    
    private void initView() {
        mIv_0 = findViewById(R.id.iv_0);
        mIv_1 = findViewById(R.id.iv_1);
        mIv_2 = findViewById(R.id.iv_2);
        mIv_3 = findViewById(R.id.iv_3);
        mIv_home = findViewById(R.id.iv_home);
        viewList.add(mIv_0);
        viewList.add(mIv_1);
        viewList.add(mIv_2);
        viewList.add(mIv_3);
        mIv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    //关闭
                    isOpen = false;
                    showCloseAnim();
                } else {
                    //开启
                    isOpen = true;
                    showOpenAnim();
                }
            }
        });
    }
    
    private void showCloseAnim() {
        int size = viewList.size();
        if (size % 2 == 0) {
            //是偶数
            for (int i = 0; i < size; i++) {
                if (i < size / 2) {
                    //坐标轴下边
                    AnimatorSet set = new AnimatorSet();
                    double x = -Math.cos(Math.PI * (size - 1 - 2 * i) / (4 * size - 4)) * 600;
                    double y = Math.sin(Math.PI * (size - 1 - 2 * i) / (4 * size - 4)) * 600;
                    set.playTogether(ObjectAnimator.ofFloat(viewList.get(i), "translationX", (float) x, 0),
                            ObjectAnimator.ofFloat(viewList.get(i), "translationY", (float) y, 0));
                    set.setInterpolator(new BounceInterpolator());
                    set.setDuration(500).setStartDelay(100 * i);
                    set.start();
                    
                } else {
                    //坐标轴上边
                    AnimatorSet set = new AnimatorSet();
                    double x = -Math.cos(Math.PI * (2 * i - size + 1) / (4 * size - 4)) * 600;
                    double y = -Math.sin(Math.PI * (2 * i - size + 1) / (4 * size - 4)) * 600;
                    set.playTogether(ObjectAnimator.ofFloat(viewList.get(i), "translationX", (float) x, 0),
                            ObjectAnimator.ofFloat(viewList.get(i), "translationY", (float) y, 0));
                    set.setDuration(500).setStartDelay(100 * i);
                    set.start();
                }
            }
            
            
        } else {
            //是奇数
        }
    }
    
    private void showOpenAnim() {
        int size = viewList.size();
        if (size % 2 == 0) {
            //是偶数
            for (int i = 0; i < size; i++) {
                if (i < size / 2) {
                    //坐标轴下边
                    AnimatorSet set = new AnimatorSet();
                    double x = -Math.cos(Math.PI * (size - 1 - 2 * i) / (4 * size - 4)) * 600;
                    double y = Math.sin(Math.PI * (size - 1 - 2 * i) / (4 * size - 4)) * 600;
                    set.playTogether(ObjectAnimator.ofFloat(viewList.get(i), "translationX", 0, (float) x),
                            ObjectAnimator.ofFloat(viewList.get(i), "translationY", 0, (float) y),
                            ObjectAnimator.ofFloat(viewList.get(i), "alpha", 0, 1).setDuration(2000));
                    set.setDuration(500).setStartDelay(100 * i);
                    set.start();
                    
                } else {
                    //坐标轴上边
                    AnimatorSet set = new AnimatorSet();
                    double x = -Math.cos(Math.PI * (2 * i - size + 1) / (4 * size - 4)) * 600;
                    double y = -Math.sin(Math.PI * (2 * i - size + 1) / (4 * size - 4)) * 600;
                    set.playTogether(ObjectAnimator.ofFloat(viewList.get(i), "translationX", 0, (float) x),
                            ObjectAnimator.ofFloat(viewList.get(i), "translationY", 0, (float) y),
                            ObjectAnimator.ofFloat(viewList.get(i), "alpha", 0, 1).setDuration(2000));
                    set.setDuration(500).setStartDelay(100 * i);
                    set.start();
                }
            }
            
            
        } else {
            //是奇数
        }
    }
}
