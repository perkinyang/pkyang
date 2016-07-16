package com.top.jbb.activity.tel400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.top.jbb.R;
import com.top.jbb.adapter.tel400.Tel400SelectAdapter;
import com.top.jbb.bean.tel400.TelListResult;
import com.top.jbb.bean.tel400.TelListResult.TelBean;
import com.top.jbb.utils.Constant;
import com.top.jbb.utils.tel400.PromptionStatusEnum;
import com.top.jbb.utils.tel400.Tel400NumberType;

public class Tel400PromptionSelectActivity extends Activity implements OnClickListener {
	private TextView topLevel;
	private TextView superLevel;
	private TextView convenionLevel;
	private TextView mantissaLevel;
	
	private View topLevelIcon;
	private View superLevelIcon;
	private View convenionLevelIcon;
	private View mantissaLevelIcon;
	private List<View> viewList=new ArrayList<View>();
	private List<TextView> textViewList=new ArrayList<TextView>();
	private List<Integer> noSelectedList=new ArrayList<Integer>();
	private List<Integer> selectedList=new ArrayList<Integer>();
	private ImageView banner;
	private int currentIndex=0;
	
	private ListView listView;
	
	private Tel400SelectAdapter mAdapter;
	
	private List<Map<String,List<TelBean>>> telList=new ArrayList<Map<String,List<TelBean>>>();
	
	private String currentArr[]=Tel400NumberType.topType;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_400_select);
		
		listView=(ListView)this.findViewById(R.id.list);
		topLevel=(TextView)this.findViewById(R.id.tel_400_top_level);
		superLevel=(TextView)this.findViewById(R.id.tel_400_super_level);
		convenionLevel=(TextView)this.findViewById(R.id.tel_400_convenion_level);
		mantissaLevel=(TextView)this.findViewById(R.id.tel_400_mantissa_level);
		
		topLevel.setOnClickListener(this);
		superLevel.setOnClickListener(this);
		convenionLevel.setOnClickListener(this);
		mantissaLevel.setOnClickListener(this);
		
		textViewList.add(topLevel);
		textViewList.add(superLevel);
		textViewList.add(convenionLevel);
		textViewList.add(mantissaLevel);
		
		noSelectedList.add(R.drawable.icon_top);
		noSelectedList.add(R.drawable.icon_super);
		noSelectedList.add(R.drawable.icon_convenion);
		noSelectedList.add(R.drawable.icon_mantissa);
		
		selectedList.add(R.drawable.icon_top1);
		selectedList.add(R.drawable.icon_super1);
		selectedList.add(R.drawable.icon_convenion1);
		selectedList.add(R.drawable.icon_mantissa1);
		
		topLevelIcon=(View)this.findViewById(R.id.tel_400_top_level_icon);
		superLevelIcon=(View)this.findViewById(R.id.tel_400_super_level_icon);
		convenionLevelIcon=(View)this.findViewById(R.id.tel_400_convenion_level_icon);
		mantissaLevelIcon=(View)this.findViewById(R.id.tel_400_mantissa_level_icon);
		
		viewList.add(topLevelIcon);
		viewList.add(superLevelIcon);
		viewList.add(convenionLevelIcon);
		viewList.add(mantissaLevelIcon);

		initBack();
		mAdapter = new Tel400SelectAdapter(this,telList,true);
		//MultiItemRowListAdapter wrapperAdapter = new MultiItemRowListAdapter(this, mAdapter, 3, DensityUtil.dip2px(this, 10));
		listView.setAdapter(mAdapter);
		//发送HTTP请求
		new Thread(new Runnable(){
			@Override
			public void run() {
				for(String str:currentArr){
					getTelList(str);
				}
			}}).start();
		
		banner=(ImageView)this.findViewById(R.id.select_banner);
		banner.setVisibility(View.GONE);
	}
	
	private void changeCurrentIcon(int index){
		for(int i=0;i<viewList.size();i++){
			viewList.get(i).setBackgroundResource(R.drawable.icon_current_white);
			Drawable topDrawable = getResources().getDrawable(noSelectedList.get(i));
			topDrawable.setBounds(0, 0, topDrawable.getMinimumWidth(), topDrawable.getMinimumHeight());
			textViewList.get(i).setCompoundDrawables(null,  topDrawable, null,null);
			
			if(i==index){
				viewList.get(i).setBackgroundResource(R.drawable.icon_current);
				Drawable topDrawable2 = getResources().getDrawable(selectedList.get(i));
				topDrawable2.setBounds(0, 0, topDrawable2.getMinimumWidth(), topDrawable2.getMinimumHeight());
				textViewList.get(i).setCompoundDrawables(null, topDrawable2,null , null);
			}
		}
	}

	private void initBack() {
		TextView back = (TextView) this.findViewById(R.id.top_return);
		back.setText(" 促销号选择");
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}

	@Override
	public void onClick(View v) {
		telList.clear();
		switch(v.getId()){  
        case R.id.tel_400_top_level:  
        	currentIndex=0;
        	currentArr=Tel400NumberType.topType;
        	break;
        case R.id.tel_400_super_level:  
        	currentIndex=1;
        	currentArr=Tel400NumberType.superType;
            break;
        case R.id.tel_400_convenion_level:  
        	currentArr=Tel400NumberType.convenionType;
        	currentIndex=2;
            break;
        default:  
        	currentIndex=3;
        	currentArr=Tel400NumberType.mantissaType;
            break;
        } 
		changeCurrentIcon(currentIndex);
		
		//发送HTTP请求
		new Thread(new Runnable(){
			@Override
			public void run() {
				for(String str:currentArr){
					getTelList(str);
				}
			}}).start();
		mAdapter.notifyDataSetChanged();
		
	}
	
	private synchronized void getTelList(final String type){
		HttpUtils httpUtils = new HttpUtils();
		RequestParams params = new RequestParams();
		params.addQueryStringParameter("limitStart","0");
		params.addQueryStringParameter("limitEnd","9");
		params.addQueryStringParameter("type",type);
		params.addQueryStringParameter("promptionStatus",String.valueOf(PromptionStatusEnum.PROMPTION.getCode()));
		httpUtils.send(HttpMethod.GET, Constant.get400ListUrl,
				params, new RequestCallBack<String>() {
					@Override
					public void onFailure(HttpException arg0, String arg1) {
						System.out.println(arg0);
					}
					@Override
					public void onSuccess(ResponseInfo<String> response) {
						Gson gson = new Gson();
						TelListResult result = gson.fromJson(response.result,TelListResult.class);
						List<TelBean> list=result.getList();
						if(list==null || list.size()==0){
							return;
						}
						Map<String,List<TelBean>> map=new HashMap<String,List<TelBean>>();
						List<TelBean> beanList=new ArrayList<TelBean>();
						beanList.addAll(list);
						map.put(type, beanList);
						telList.add(map);
						mAdapter.notifyDataSetChanged();
					}
				});

	}
}
