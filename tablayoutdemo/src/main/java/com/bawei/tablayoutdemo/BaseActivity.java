package com.bawei.tablayoutdemo;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity  extends AppCompatActivity{
    protected TiitleBar bar;

    protected abstract  void initView();
}
