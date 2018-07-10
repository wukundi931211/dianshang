package com.bawei.tablayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bawei.tablayoutdemo.fragment.FragmentOne;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TiitleBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablelayout01);
        viewPager = findViewById(R.id.vp);
        bar = findViewById(R.id.main_titlebar);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        //关联
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }



    class MyViewPagerAdapter extends FragmentPagerAdapter {

        private final String[] title = new String[]{
                "推荐", "热点", "视频", "推荐", "热点", "视频", "推荐", "热点", "视频"};


        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {


            }
            if (position == 1) {


            }
            return FragmentOne.newInstance(title[position], "");
        }

        @Override
        public int getCount() {
            return title.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
