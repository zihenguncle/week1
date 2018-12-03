package com.bwie.guoziheng;

import android.app.Service;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.guoziheng.customview.HeadView;
import com.bwie.guoziheng.customview.LableView;
import com.bwie.guoziheng.dao.DataDao;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private HeadView headView;
    private LableView lableView,searchfound;
    private DataDao dao;
    private ImageView imageView;
    private String[] str = new String[]{"考拉三周年人气热榜销","电动牙刷","豆豆鞋","沐浴露","日东红茶","榴莲","尤妮佳","雅诗兰黛"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //获取资源id
        headView = findViewById(R.id.headview);
        lableView = findViewById(R.id.lableview);
        searchfound = findViewById(R.id.searchfound);
        imageView = findViewById(R.id.laji);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SearchActivity.this);
                builder.setTitle("狠心删除搜索历史吗？");
                builder.setNegativeButton("在考虑一下", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("狠心删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dao.delall();
                        lableView.removeAllViews();
                    }
                });
                builder.show();

            }
        });

        dao = new DataDao(this);

        //查询数据库
        final List<String> select = dao.select();

        for (int i = 0; i < select.size(); i++) {
            final TextView textView = new TextView(SearchActivity.this);
            //设置属性
            textView.setText(select.get(i));
            textView.setTextColor(Color.BLACK);
            textView.setBackgroundResource(R.drawable.textstyle);
            textView.setTextSize(18);
            textView.setPadding(10,10,10,10);
            lableView.addView(textView);
            final int index = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SearchActivity.this,select.get(index),Toast.LENGTH_SHORT).show();
                }
            });
        }
        //点击事件
        headView.setOnButtonClick(new HeadView.onButtonClick() {
            @Override
            public void setButtonClick(String str) {
                final TextView textView = new TextView(SearchActivity.this);
                //设置属性
                textView.setText(str);
                textView.setTag(str);
                textView.setTextColor(Color.BLACK);
                textView.setBackgroundResource(R.drawable.textstyle);
                textView.setTextSize(18);
                textView.setPadding(10,10,10,10);
                lableView.addView(textView);
                dao.add(str);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SearchActivity.this,String.valueOf(v.getTag()),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        for (int i = 0; i < str.length; i++) {
            TextView textView = new TextView(SearchActivity.this);
            //设置属性
            textView.setText(str[i]);
            textView.setTextColor(Color.BLACK);
            textView.setBackgroundResource(R.drawable.textstyle);
            textView.setTextSize(18);
            textView.setPadding(10,10,10,10);
            searchfound.addView(textView);
            final int index = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SearchActivity.this,str[index],Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
