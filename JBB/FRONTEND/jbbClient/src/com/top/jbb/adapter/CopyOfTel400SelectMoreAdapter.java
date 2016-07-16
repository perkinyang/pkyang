package com.top.jbb.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

import com.top.jbb.R;
import com.top.jbb.activity.tel400.Tel400DetailActivity;
import com.top.jbb.bean.tel400.TelListResult.TelBean;
import com.top.jbb.utils.DensityUtil;

import java.util.List;

public class CopyOfTel400SelectMoreAdapter extends BaseAdapter
{
	private List<List<TelBean>> mList;
	private LayoutInflater mInflater;
	private Context mContext;

	public CopyOfTel400SelectMoreAdapter(Context context, List<List<TelBean>> list)
	{
		mInflater = LayoutInflater.from(context);
		mContext = context;
		this.mList = list;
	}

	@Override
	public int getCount()
	{
		return mList == null ? 0:mList.size();
	}

	@Override
	public List<TelBean> getItem(int position)
	{
		return mList.get(position);
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
			convertView = mInflater.inflate(R.layout.item_400_select_more, null);
			holder.layout1 = (LinearLayout) convertView.findViewById(R.id.tel_400_selet_more_item);
			convertView.setTag(holder);
		}
		ViewHolder holder=(ViewHolder)convertView.getTag();
		List<TelBean>  bean = getItem(position);
		initData(holder,bean);
		return convertView;
	}
	
	private void initData(final ViewHolder holder,List<TelBean> bean){
		holder.layout1.removeAllViews();
		if(bean.get(0)!=null){
			addBtn(holder.layout1,bean.get(0));
		}
		if(bean.get(1)!=null){
			addBtn(holder.layout1,bean.get(1));
		}
		if(bean.get(2)!=null){
			addBtn(holder.layout1,bean.get(2));
		}
	}
	
	private void addBtn(LinearLayout layout,TelBean number){
		int dp=DensityUtil.px2dip(mContext, 7);
		Button btn = new Button(mContext);
		btn.setId(number.getId());
		btn.setText(number.getDisplayNumber());
		btn.setBackgroundResource(R.drawable.selector_bg);
		LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		lp1.weight=1;
		lp1.gravity=Gravity.CENTER;
		btn.setPadding(dp, dp, dp,dp);
		btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(mContext,Tel400DetailActivity.class);
				mContext.startActivity(intent);
				
			}});
		layout.addView(btn, lp1);
	}
	
	static private class ViewHolder
	{
		public LinearLayout layout1;
	}
}