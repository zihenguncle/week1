package com.bwie.guoziheng.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.bwie.guoziheng.R;

@SuppressLint("AppCompatCustomView")
public class TitleView extends TextView {
    public TitleView(Context context) {
        super(context);
    }

    public TitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //自定义属性
        //动态改变颜色和大小
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleView);
        int color = typedArray.getColor(R.styleable.TitleView_textColor, Color.BLACK);
        setTextColor(color);
        int integer = typedArray.getInteger(R.styleable.TitleView_textSize, 25);
        setTextSize(integer);
        //回收
        typedArray.recycle();
    }

}
