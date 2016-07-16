package com.top.jbb.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.http.ResponseInfo;
import com.top.jbb.R;
import com.top.jbb.adapter.AreaSelectAdapter;
import com.top.jbb.bean.common.Area;
import com.top.jbb.bean.common.AreaResult;
import com.top.jbb.utils.CallBackInterface;
import com.top.jbb.utils.Constant;
import com.top.jbb.utils.HttpTools;
import com.top.jbb.utils.RequestCodeTools;
import com.top.jbb.utils.TipTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaListSelectActivity extends Activity implements CallBackInterface{
	
	private TextView province;
	private TextView city;
	private ListView listView;
	private Area provinceSelected;
	private Area citySelected;
	private Area areaSelected;
	private List<Area> areaList=new ArrayList<Area>();
	private AreaSelectAdapter mAdapter;
	private int level=1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_area_select);

		province=(TextView)this.findViewById(R.id.area_select_province);
		city=(TextView)this.findViewById(R.id.area_select_city);
		listView=(ListView)this.findViewById(R.id.select_list);

		httpGetData(0);
		initBack();
		
		listView.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				if(level==2){
					province.setText(areaList.get(position).getName());
					provinceSelected=areaList.get(position);
					province.setVisibility(View.VISIBLE);
					httpGetData(provinceSelected.getCode());
				}else if(level==3){
					city.setText(areaList.get(position).getName());
					citySelected=areaList.get(position);
					city.setVisibility(View.VISIBLE);
					httpGetData(citySelected.getCode());
				}else{
					areaSelected=areaList.get(position);
					Intent intent=new Intent(AreaListSelectActivity.this,FillPersonDetailActivity.class);
					intent.putExtra("province", provinceSelected);
					intent.putExtra("city", citySelected);
					intent.putExtra("area", areaSelected);
					setResult(RequestCodeTools.areaRequestCode, intent); 
					finish();
				}
			}});
	}
	
	
	private void httpGetData(int code){
		Map<String,String> map=new HashMap<String,String>();
		map.put("code",String.valueOf(code));
		map.put("level", String.valueOf(level));
		HttpTools.httpGet(Constant.getAreaListUrl, map, this);
	}
	@Override
	public void successCallBack(ResponseInfo<String> response,Map<String, Object> map2) {
		Gson gson = new Gson();
		AreaResult result = gson.fromJson(response.result,AreaResult.class);
		List<Area> list=result.getList();
		if(list==null || list.size()==0){
			return;
		}
		level++;	
		areaList.clear();
		areaList.addAll(list);	
		if(provinceSelected==null){
			mAdapter=new AreaSelectAdapter(this,areaList);
			listView.setAdapter(mAdapter);
		}else{
			mAdapter.notifyDataSetChanged();
		}		
	}

	@Override
	public void failCallBack(Map<String, Object> map) {
		TipTools.tips(this, "==========");
	}

	@Override
	public boolean preCallBack(Map<String, Object> map) {	
		return true;
	}

	@Override
	public void postCallBack(Map<String, Object> map) {		
		
	}
	
	private void initBack(){
		TextView back=(TextView)this.findViewById(R.id.top_return);
		back.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				processBack();	
			}});
	}
	
	public void onBackPressed() {
		processBack();
    }
	
	private void processBack(){
		if(level==2){
			finish();
		}else if(level==3){
			provinceSelected=null;
			province.setVisibility(View.GONE);
			level=1;
			httpGetData(0);
		}else{
			citySelected=null;
			city.setVisibility(View.GONE);
			level=2;
			int code=provinceSelected.getCode();
			httpGetData(code);
		}
	}
}
