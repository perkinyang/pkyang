package com.top.jbb.activity.tel400;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.top.jbb.R;
import com.top.jbb.adapter.tel400.Tel400OrderProgressAdapter;
import com.top.jbb.bean.tel400.Tel400OrderProcessBean;

public class Tel400OrderProgressActivity extends Activity {
	
	private ListView listView;
	private List<Tel400OrderProcessBean> telList=new ArrayList<Tel400OrderProcessBean>();
	private Tel400OrderProgressAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_400_order_progress);
		listView=(ListView)this.findViewById(R.id.list);
		init();
		mAdapter = new Tel400OrderProgressAdapter(Tel400OrderProgressActivity.this,telList);
		listView.setAdapter(mAdapter);
		initBack();
	}
	
	private void initBack() {
		TextView back = (TextView) this.findViewById(R.id.top_return);
		back.setText(" 订单进度");
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
	
	private void init(){
		{Tel400OrderProcessBean bean=new Tel400OrderProcessBean();
		bean.setOrderId(1);
		bean.setOrderNumber("201604012123213000434");
		bean.setStatus(10);
		bean.setUpdateTime("2016-04-12 13:55:12");
		telList.add(bean);}
		
		{Tel400OrderProcessBean bean=new Tel400OrderProcessBean();
		bean.setOrderId(1);
		bean.setOrderNumber("201604012123213000434");
		bean.setStatus(20);
		bean.setUpdateTime("2016-04-13 14:55:16");
		telList.add(bean);}
		
		{Tel400OrderProcessBean bean=new Tel400OrderProcessBean();
		bean.setOrderId(1);
		bean.setOrderNumber("201604012123213000434");
		bean.setStatus(30);
		bean.setUpdateTime("2016-04-14 15:55:19");
		telList.add(bean);}
	}
}
