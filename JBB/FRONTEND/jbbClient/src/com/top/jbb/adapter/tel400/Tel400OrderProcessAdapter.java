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
import com.top.jbb.bean.tel400.Tel400OrderBean;
import com.top.jbb.bean.tel400.ValueAddBean;

public class Tel400OrderProcessAdapter extends BaseAdapter
{
	private List<Tel400OrderBean> telList;
	private LayoutInflater mInflater;
	private Context mContext;
	public Tel400OrderProcessAdapter(Context context, List<Tel400OrderBean> list)
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
	public Tel400OrderBean getItem(int position)
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
			convertView = mInflater.inflate(R.layout.item_400_order_list, null);
			holder.orderNumber=(TextView) convertView.findViewById(R.id.number);
			holder.orderStatus=(TextView) convertView.findViewById(R.id.status);
			//holder.layout=(RelativeLayout)convertView.findViewById(R.id.more);
			holder.price=(TextView) convertView.findViewById(R.id.price);
			convertView.setTag(holder);
		}
		ViewHolder holder=(ViewHolder)convertView.getTag();
		Tel400OrderBean bean = getItem(position);
		holder.orderNumber.setText(bean.getOrderNumber());
		holder.orderStatus.setText(String.valueOf(bean.getStatus()));
		holder.price.setText(bean.getPrice()+"元");
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
		public TextView orderNumber;
		public TextView orderStatus;
		public TextView price;
	}
}