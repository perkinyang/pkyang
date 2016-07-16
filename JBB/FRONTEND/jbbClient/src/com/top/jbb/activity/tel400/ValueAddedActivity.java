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
import com.top.jbb.adapter.tel400.Tel400ValueAddAdapter;
import com.top.jbb.bean.tel400.ValueAddBean;

public class ValueAddedActivity extends Activity{
	private ListView listView;
	private List<ValueAddBean> telList=new ArrayList<ValueAddBean>();
	private Tel400ValueAddAdapter mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_400_value_add);	
		listView=(ListView)this.findViewById(R.id.list);
		init();
		mAdapter = new Tel400ValueAddAdapter(ValueAddedActivity.this,telList);
		listView.setAdapter(mAdapter);
		initBack();
		
	}
	
	private void initBack() {
		TextView back = (TextView) this.findViewById(R.id.top_return);
		back.setText(" 400增值服务");
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
	
	private void init(){
		for(int i=0;i<8;i++){
			ValueAddBean value=new ValueAddBean();
			value.setId(12);
			value.setName("测试测试");
			value.setPrice(300);
			telList.add(value);
		}
	}
}
