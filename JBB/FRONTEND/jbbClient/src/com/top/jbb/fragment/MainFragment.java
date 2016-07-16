package com.top.jbb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.top.jbb.R;
import com.top.jbb.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by tanghongliang on 16/4/17.
 */
public class MainFragment extends Fragment {

    private ViewPager mPager;
    private ArrayList<Fragment> fragmentList;
    private int currIndex;// 当前页卡编号
    protected ViewGroup group;
    private ImageView[] tips;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View  mainView =  inflater.inflate(R.layout.fragment_main,container,false);
        init(mainView);
        return mainView;
    }

    public void init(View mainView) {
        group = (ViewGroup) mainView.findViewById(R.id.viewGroup);
        tips = new ImageView[2];
        for (int i = 0; i < tips.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setLayoutParams(new LinearLayout.LayoutParams(10, 10));
            tips[i] = imageView;
            if (i == 0) {
                tips[i].setBackgroundResource(R.drawable.icon_yuan_select);
            } else {
                tips[i].setBackgroundResource(R.drawable.icon_yuan);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 10;
            layoutParams.rightMargin = 10;
            group.addView(imageView, layoutParams);
        }
        mPager = (ViewPager) mainView.findViewById(R.id.viewpager);
        fragmentList = new ArrayList<Fragment>();
        Fragment secondFragment = new MainGuide1();
        Fragment thirdFragment = new MainGuide2();
        fragmentList.add(secondFragment);
        fragmentList.add(thirdFragment);
        mPager.setAdapter(new MyFragmentPagerAdapter(
                getChildFragmentManager(), fragmentList));
        mPager.setCurrentItem(0);// 设置当前显示标签页为第一页
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());// 页面变化时的监听器
//        initNav();
    }
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageSelected(int arg0) {
            currIndex = arg0;
            setImageBackground(arg0 % 2);
        }
    }

    private void setImageBackground(int selectItems) {
        for (int i = 0; i < tips.length; i++) {
            if (i == selectItems) {
                tips[i].setBackgroundResource(R.drawable.icon_yuan_select);
            } else {
                tips[i].setBackgroundResource(R.drawable.icon_yuan);
            }
        }
    }


}
