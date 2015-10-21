package com.husy.frameandlayoutanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LayoutAnimActivity extends AppCompatActivity {

    @Bind(R.id.list)
    ListView list;
    @Bind(R.id.list2)
    ListView list2;
    @Bind(R.id.list3)
    ListView list3;
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_anim);
        ButterKnife.bind(this);
        initData();
        list.setAdapter(new ArrayAdapter<String>(
                LayoutAnimActivity.this, R.layout.list_item, R.id.text, arrayList));
        list2.setAdapter(new ArrayAdapter<String>(
                LayoutAnimActivity.this, R.layout.list_item, R.id.text, arrayList));
        list3.setAdapter(new ArrayAdapter<String>(
                LayoutAnimActivity.this, R.layout.list_item, R.id.text, arrayList));
        if (getIntent().getIntExtra("i",0)==1){
            list.setVisibility(View.VISIBLE);
        }else if (getIntent().getIntExtra("i",0)==2){
            list2.setVisibility(View.VISIBLE);
        }else{
            list3.setVisibility(View.VISIBLE);
        }
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            arrayList.add("longyin" + i);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
