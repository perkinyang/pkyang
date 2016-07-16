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
import com.top.jbb.adapter.tel400.Tel400OrderListAdapter;
import com.top.jbb.adapter.tel400.Tel400ValueAddAdapter;
import com.top.jbb.bean.tel400.Tel400OrderBean;
import com.top.jbb.bean.tel400.ValueAddBean;

public class Tel400OrderListActivity extends Activity {
	
	private ListView listView;
	private List<Tel400OrderBean> telList=new ArrayList<Tel400OrderBean>();
	private Tel400OrderListAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_400_order_list);
		listView=(ListView)this.findViewById(R.id.list);
		init();
		mAdapter = new Tel400OrderListAdapter(Tel400OrderListActivity.this,telList);
		listView.setAdapter(mAdapter);
		initBack();
	}
	
	private void initBack() {
		TextView back = (TextView) this.findViewById(R.id.top_return);
		back.setText(" 订单列表");
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
	
	private void init(){
		Tel400OrderBean bean=new Tel400OrderBean();
		bean.setOrderId(1);
		bean.setOrderNumber("201604012123213000434");
		bean.setPrice(500);
		bean.setStatus(20);
		for(int i=0;i<20;i++){
			telList.add(bean);
		}
	}
}
