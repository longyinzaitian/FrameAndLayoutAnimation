package com.husy.frameandlayoutanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.frame)
    TextView frame;
    @Bind(R.id.layoutanimation)
    TextView layoutanimation;
    @Bind(R.id.layoutanimation2)
    TextView layoutanimation2;
    @Bind(R.id.layoutanimation3)
    TextView layoutanimation3;
    @Bind(R.id.layoutanimation4)
    TextView layoutanimation4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.frame, R.id.layoutanimation,
            R.id.layoutanimation2,R.id.layoutanimation3,
            R.id.layoutanimation4})
    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.frame:
                startActivity(new Intent(
                        MainActivity.this, FrameAnimActivity.class
                ));
                break;
            case R.id.layoutanimation:
                startActivity(new Intent(
                        MainActivity.this, LayoutAnimActivity.class
                ).putExtra("i",1));
                break;
            case R.id.layoutanimation2:
                startActivity(new Intent(
                        MainActivity.this, LayoutAnimActivity.class
                ).putExtra("i",2));
                break;
            case R.id.layoutanimation3:
                startActivity(new Intent(
                        MainActivity.this, LayoutAnimActivity.class
                ).putExtra("i",3));
                break;
            case R.id.layoutanimation4:
                startActivity(new Intent(
                        MainActivity.this, CodeLayoutAnimActivity.class
                ));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
