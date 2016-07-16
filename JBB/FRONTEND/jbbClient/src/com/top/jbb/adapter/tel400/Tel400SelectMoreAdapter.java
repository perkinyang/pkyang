package com.top.jbb.adapter.tel400;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.top.jbb.R;
import com.top.jbb.activity.tel400.Tel400DetailActivity;
import com.top.jbb.bean.tel400.TelListResult.TelBean;
import com.top.jbb.utils.DensityUtil;

public class Tel400SelectMoreAdapter extends BaseAdapter
{
	private List<TelBean> mList;
	private LayoutInflater mInflater;
	private Context mContext;

	public Tel400SelectMoreAdapter(Context context, List<TelBean> list)
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
	public TelBean getItem(int position)
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
			holder.text = (TextView) convertView.findViewById(R.id.item_tel);
			convertView.setTag(holder);
		}
		ViewHolder holder=(ViewHolder)convertView.getTag();
		final TelBean  bean = getItem(position);
		holder.text.setText(bean.getDisplayNumber());
		holder.text.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(mContext,Tel400DetailActivity.class);
				intent.putExtra("number", bean.getDisplayNumber());
				mContext.startActivity(intent);
			}});
		return convertView;
	}
	
	static private class ViewHolder
	{
		public TextView text;
	}
}