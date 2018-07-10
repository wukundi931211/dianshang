package com.bawei.tablayoutdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.view.View;
import android.widget.TextView;

public class TiitleBar extends RelativeLayout implements View.OnClickListener {

    ImageView back;//点击就销毁
    TextView title;
    BarListener barListener;

    public TiitleBar(Context context) {
        super(context);
        //初始化标题栏
        initBar(context,null);
    }

    public TiitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBar(context,attrs);
    }

    public TiitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //初始化属性
    private void initBar(Context context, AttributeSet attrs) {
        //初始化布局 寻找你要找的
        View view = LayoutInflater.from(context).inflate(R.layout.title_bar,this);
        back = view.findViewById(R.id.title_bar_back);
        title = view.findViewById(R.id.title_bar);

        back.setOnClickListener(this);

        if (attrs !=null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TiitleBar);
            String string = typedArray.getString(R.styleable.TiitleBar_title);
            typedArray.recycle();
            title.setText(string);
        }
    }

    //单击事件
    @Override
    public void onClick(View v) {
            if (v.getId() == back.getId()){
                if (barListener!=null){
                    barListener.back();
                }
            }
    }
    /**
     * 设置是否
     */
    public void setHideBack(boolean isHide){
        if (isHide){
            back.setVisibility(GONE);
        }else {
            back.setVisibility(VISIBLE);
        }

    }

    /**
     * 设置返回监听接口
     */
    public interface BarListener {
        void back(); // 处理返回
    }
    //外放接口
    public void setBarListener(BarListener barListener) {
        this.barListener = barListener;
    }
}
