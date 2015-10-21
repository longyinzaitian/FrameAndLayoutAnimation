package com.husy.frameandlayoutanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CodeLayoutAnimActivity extends AppCompatActivity {

    @Bind(R.id.list)
    ListView list;
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_layout_anim);
        ButterKnife.bind(this);
        initData();
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f,1);
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);
        set.setDuration(1000);
        set.setFillAfter(true);
        LayoutAnimationController la = new LayoutAnimationController(set);
        list.setLayoutAnimation(la);
        list.setLayoutAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(CodeLayoutAnimActivity.this,"开始啦",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(CodeLayoutAnimActivity.this,"结束啦",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        list.setAdapter(new ArrayAdapter<String>(
                CodeLayoutAnimActivity.this,R.layout.list_item,R.id.text,arrayList));
    }
    private void initData(){
        for (int i=0;i<20;i++){
            arrayList.add("longyin"+i);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
