package com.top.jbb.activity.tel400;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.top.jbb.R;
import com.top.jbb.adapter.MultiItemRowListAdapter;
import com.top.jbb.adapter.tel400.Tel400SelectMoreAdapter;
import com.top.jbb.bean.tel400.TelListResult;
import com.top.jbb.bean.tel400.TelListResult.TelBean;
import com.top.jbb.bean.tel400.ValueAddBean;
import com.top.jbb.utils.Constant;
import com.top.jbb.view.pullpush.PullToRefreshListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tel400SelectMoreActivity extends Activity implements OnClickListener {

	private PullToRefreshListView listView;
	private Tel400SelectMoreAdapter mAdapter;
	private List<TelBean> telList=new ArrayList<TelBean>();
	private final int size=60;
	private int pageNo=0;
	private String type;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_400_select_more);
		type=this.getIntent().getStringExtra("type");
		listView=(PullToRefreshListView)this.findViewById(R.id.list);
		mAdapter = new Tel400SelectMoreAdapter(Tel400SelectMoreActivity.this,telList);
		MultiItemRowListAdapter multiItem=new MultiItemRowListAdapter(this,mAdapter,3,0);
		listView.setAdapter(multiItem);
		getTelList(pageNo);
		listView.setIsAllLoaded(false);
		listView.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener() {
			public void onRefresh() {
				listView.onRefreshComplete (new Date().toLocaleString());
			}
			public void onLoadingMore() {	
				getTelList(pageNo);
			}
		});
		initBack();	
	}
	
	private void initBack() {
		TextView back = (TextView) this.findViewById(R.id.top_return);
		back.setText("  "+type);
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}

	private void getTelList(int page){
		HttpUtils httpUtils = new HttpUtils();
		RequestParams params = new RequestParams();
		params.addQueryStringParameter("limitStart",String.valueOf(page));
		params.addQueryStringParameter("limitEnd",String.valueOf(page*size+size));
		params.addQueryStringParameter("type",type);
		httpUtils.send(HttpMethod.GET, Constant.get400ListUrl,
				params, new RequestCallBack<String>() {
					@Override
					public void onFailure(HttpException arg0, String arg1) {					
					}
					@Override
					public void onSuccess(ResponseInfo<String> response) {
						try {
							listView.onLoadingMoreComplete(false);
						} catch (Exception e) {
						}
						Gson gson = new Gson();
						TelListResult result = gson.fromJson(response.result,TelListResult.class);
						List<TelBean> list=result.getList();
						if(list==null || list.size()==0){
							return;
						}
						telList.addAll(list);
						mAdapter.notifyDataSetChanged();
						pageNo++;
					}
				});

	}

	@Override
	public void onClick(View v) {
		//发送HTTP请求
		
	}
}
