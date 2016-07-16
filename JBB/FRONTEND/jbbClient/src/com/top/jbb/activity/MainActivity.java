package com.top.jbb.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.top.jbb.R;
import com.top.jbb.fragment.user.UserPortalFragment;
import com.top.jbb.fragment.MainFragment;
import com.top.jbb.fragment.MessageFragment;

public class MainActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;

    private LayoutInflater layoutInflater;

    private Class fragmentArray[] = {MainFragment.class, MessageFragment.class, UserPortalFragment.class};

    //Tab选项卡图片
    private int tabIconArray[] = {R.drawable.icon_home, R.drawable.icon_info, R.drawable.icon_my};

    //Tab选项卡的文字
    private String tabTextArray[] = {"首页", "消息", "我的"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab_layout);
        initView();
	}

    private void initView() {
        //实例化布局对象
        layoutInflater = LayoutInflater.from(this);
        //实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.real_tab_content);

        int count = fragmentArray.length;

        for(int i = 0; i < count; i++){
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(tabTextArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            //设置Tab按钮的背景
//            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.ic_launcher);
        }

        mTabHost.setBackgroundColor(getResources().getColor(R.color.nav));

    }


    /**
     * 给Tab按钮设置图标和文字
     */
    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_icon);
        tabIcon.setImageResource(tabIconArray[index]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_text);
        tabText.setText(tabTextArray[index]);
        return view;
    }
}
