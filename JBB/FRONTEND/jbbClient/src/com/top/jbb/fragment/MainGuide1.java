package com.top.jbb.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.top.jbb.R;
import com.top.jbb.activity.tel400.Tel400Activity;

public class MainGuide1 extends Fragment {
	
	private TextView guide400;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main_guide_1, container, false);
		TextView g400=(TextView)view.findViewById(R.id.guide_400);
		g400.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getActivity(), Tel400Activity.class);
				startActivity(intent);
			}});
		return view;
	}
}
