package com.top.jbb.activity.tel400;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.top.jbb.R;
import com.top.jbb.view.AddAndSubView;
import com.top.jbb.view.TimeDismissDialog;

public class Tel400OrderActivity extends Activity {
	
	private TextView submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_400_order);
		LinearLayout linearLayout1 = (LinearLayout)findViewById(R.id.tel_400_order_sub_add);
        AddAndSubView addAndSubView = new AddAndSubView(Tel400OrderActivity.this,1);
		linearLayout1.addView(addAndSubView);
		submit=(TextView)this.findViewById(R.id.detail_400_order_submit);
		submit.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				TimeDismissDialog dialog=new TimeDismissDialog(Tel400OrderActivity.this,"下单成功！");
				dialog.show();
				
			}});
		
		initBack();
	}
	
	private void initBack() {
		TextView back = (TextView) this.findViewById(R.id.top_return);
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
}
