package com.top.jbb.adapter.tel400;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.top.jbb.R;
import com.top.jbb.bean.tel400.ValueAddBean;

public class Tel400ValueAddAdapter extends BaseAdapter
{
	private List<ValueAddBean> telList;
	private LayoutInflater mInflater;
	private Context mContext;
	public Tel400ValueAddAdapter(Context context, List<ValueAddBean> list)
	{
		mInflater = LayoutInflater.from(context);
		mContext = context;
		this.telList = list;
	}

	@Override
	public int getCount()
	{
		return telList == null ? 0:telList.size();
	}

	@Override
	public ValueAddBean getItem(int position)
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
			convertView = mInflater.inflate(R.layout.item_400_value_add, null);
			holder.title=(TextView) convertView.findViewById(R.id.value_add_name);
			//holder.layout=(RelativeLayout)convertView.findViewById(R.id.more);
			holder.price=(TextView) convertView.findViewById(R.id.price);
			convertView.setTag(holder);
		}
		ViewHolder holder=(ViewHolder)convertView.getTag();
		final ValueAddBean bean = getItem(position);
		holder.title.setText(bean.getName());
		holder.price.setText(bean.getPrice()+"元/年");
		//holder.layout.setOnClickListener(new OnClickListener(){
			//@Override
		//	public void onClick(View v) {
//				Intent intent=new Intent(mContext,Tel400SelectMoreActivity.class);
//				intent.putExtra("type", (String)v.getTag());
//				mContext.startActivity(intent);
		//	}});
		return convertView;
	}
	static private class ViewHolder
	{
		public TextView title;
		public RelativeLayout layout;
		public TextView price;
	}
}