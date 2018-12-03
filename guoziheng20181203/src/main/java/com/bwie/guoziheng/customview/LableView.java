package com.bwie.guoziheng.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class LableView extends LinearLayout {

    //最高的孩子
    private int mMaxChildHeight;

    //边距
    private int marginLeft = 20;
    private int marginTop = 20;

    public LableView(Context context) {
        super(context);
    }

    public LableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //得到父控件的宽高
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        //得到孩子的大小
        measureChildren(widthMeasureSpec,heightMeasureSpec);

        findMaxChildHeight();

        int left = 0,top = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if(left != 0){
                if((left + view.getMeasuredWidth())>widthSize){
                    top += mMaxChildHeight + marginTop;
                    left = 0;
                }
            }

            left += view.getMeasuredWidth()+marginLeft;
        }
        setMeasuredDimension(widthSize,(top + mMaxChildHeight)>heightSize?heightSize:top + mMaxChildHeight);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        findMaxChildHeight();

        int left = 0,top = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = getChildAt(i);
            if(left != 0){
                if((left + view.getMeasuredWidth())>getWidth()){
                    top += mMaxChildHeight + marginTop;
                    left = 0;
                }
            }
            view.layout(left,top,left + view.getMeasuredWidth(),top + mMaxChildHeight);
            left += view.getMeasuredWidth() + marginLeft;
        }
    }

    //找到最高的孩子
    private void findMaxChildHeight(){
        mMaxChildHeight = 0;
        //得到孩子的个数
        int mchildCount = getChildCount();
        //遍历找到最高的孩子
        for (int i = 0; i < mchildCount; i++) {
            View view = getChildAt(i);
            if(mMaxChildHeight<view.getMeasuredHeight()){
                mMaxChildHeight = view.getMeasuredHeight();
            }
        }
    }
}
