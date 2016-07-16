package com.top.jbb.adapter.tel400;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.top.jbb.R;
import com.top.jbb.activity.tel400.Tel400DetailActivity;
import com.top.jbb.activity.tel400.Tel400SelectMoreActivity;
import com.top.jbb.bean.tel400.TelListResult.TelBean;
import com.top.jbb.utils.DensityUtil;

public class Tel400SelectAdapter extends BaseAdapter
{
	private List<Map<String,List<TelBean>>> telList;
	private LayoutInflater mInflater;
	private Context mContext;
	private boolean isPromption;
	public Tel400SelectAdapter(Context context, List<Map<String,List<TelBean>>> list,boolean isPromption)
	{
		mInflater = LayoutInflater.from(context);
		mContext = context;
		this.telList = list;
		this.isPromption=isPromption;
	}

	@Override
	public int getCount()
	{
		return telList == null ? 0:telList.size();
	}

	@Override
	public Map<String,List<TelBean>> getItem(int position)
	{
		return telList.get(position);
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{      
		if(convertView==null){
			ViewHolder holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_400_select, null);
			holder.layout1 = (LinearLayout) convertView.findViewById(R.id.arr1);
			holder.layout2 = (LinearLayout) convertView.findViewById(R.id.arr2);
			holder.layout3 = (LinearLayout) convertView.findViewById(R.id.arr3);
			holder.title=(TextView) convertView.findViewById(R.id.tel_400_select_title);
			holder.more=(TextView) convertView.findViewById(R.id.tel_400_select_more);
			convertView.setTag(holder);
		}
		ViewHolder holder=(ViewHolder)convertView.getTag();
		final Map<String,List<TelBean>> bean = getItem(position);

		initData(holder,bean,position);
		
		holder.more.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(mContext,Tel400SelectMoreActivity.class);
				intent.putExtra("type", (String)v.getTag());
				mContext.startActivity(intent);
			}});
		return convertView;
	}
	
	private void initData(final ViewHolder holder,Map<String,List<TelBean>>  bean,int position){
		holder.layout1.removeAllViews();
		holder.layout2.removeAllViews();
		holder.layout3.removeAllViews();
		int color=Color.parseColor("#ff6737");
		if(isPromption){
			holder.more.setVisibility(View.GONE);
			color=Color.parseColor("#ff6737");
		}else{
			color=Color.parseColor("#646464");
			holder.more.setVisibility(View.VISIBLE);
		}
//		if(position==0){
//			holder.more.setVisibility(View.GONE);
//		}else{
//			holder.more.setVisibility(View.VISIBLE);
//			color=Color.parseColor("#646464");
//		}
		for(Map.Entry<String,List<TelBean>> entry:bean.entrySet()){
			holder.title.setText(entry.getKey());
			holder.more.setTag(entry.getKey());
			List<TelBean> list=entry.getValue();
			for(int i=0;i<list.size();i++){
				if(i<3){
					addBtn(holder.layout1,list.get(i),color);
				}else if(i<6){
					addBtn(holder.layout2,list.get(i),color);
				}else{
					addBtn(holder.layout3,list.get(i),color);
				}
			}
			break;
		}
	}
	
	private void addBtn(LinearLayout layout,TelBean number,int color){
		int dp=DensityUtil.px2dip(mContext, 7);
		Button btn = new Button(mContext);
		btn.setId(number.getId());
		btn.setText(number.getDisplayNumber());
		btn.setBackgroundResource(R.drawable.selector_bg);
		btn.setTextColor(color);
		LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		lp1.weight=1;
		lp1.gravity=Gravity.CENTER;
		btn.setPadding(dp, dp, dp,dp);
		
		btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(mContext,Tel400DetailActivity.class);
				intent.putExtra("number", ((Button)v).getText().toString());
				mContext.startActivity(intent);
				
			}});
		
		layout.addView(btn, lp1);
		
		
	}
	
	static private class ViewHolder
	{
		public LinearLayout layout1;
		public LinearLayout layout2;
		public LinearLayout layout3;
		public TextView title;
		public TextView more;
	}
}