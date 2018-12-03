package com.bwie.guoziheng.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bwie.guoziheng.R;

public class HeadView extends LinearLayout {

    private Context mcontext;

    public HeadView(Context context) {
        super(context);
        init();
    }

    public HeadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mcontext = context;
        init();
    }

    private void init(){
        View view = inflate(mcontext, R.layout.headview,null);
        final EditText edit = view.findViewById(R.id.head_edit_message);
        ImageView image = view.findViewById(R.id.head_image_seach);
        image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //得到输入框的值
                String message = edit.getText().toString();
                if(!message.equals("")){
                    buttonClick.setButtonClick(message);
                }else {
                    Toast.makeText(mcontext,"输入内容不可为空",Toast.LENGTH_SHORT).show();
                }
            }
        });
        addView(view);
    }

    public onButtonClick buttonClick;

    //给接口设置监听
    public void setOnButtonClick(onButtonClick onButtonClick){
        buttonClick = onButtonClick;
    }

    //定义接口
    public interface onButtonClick{
        void setButtonClick(String str);
    }

}
