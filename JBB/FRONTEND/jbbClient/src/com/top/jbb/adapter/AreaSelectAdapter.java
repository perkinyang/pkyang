package com.top.jbb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.top.jbb.R;
import com.top.jbb.bean.common.Area;

import java.util.List;

public class AreaSelectAdapter extends BaseAdapter {
	private List<Area> mList;
	private LayoutInflater mInflater;
	private Context mContext;

	public AreaSelectAdapter(Context context, List<Area> list) {
		mInflater = LayoutInflater.from(context);
		mContext = context;
		this.mList = list;
	}

	@Override
	public int getCount() {
		return mList == null ? 0 : mList.size();
	}

	@Override
	public Area getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			ViewHolder holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_area_select, null);
			holder.area = (TextView) convertView.findViewById(R.id.area);
			convertView.setTag(holder);
		}
		ViewHolder holder = (ViewHolder) convertView.getTag();
		final Area bean = getItem(position);
		holder.area.setText(bean.getName());
		return convertView;
	}

	static private class ViewHolder {
		public TextView area;
	}
}