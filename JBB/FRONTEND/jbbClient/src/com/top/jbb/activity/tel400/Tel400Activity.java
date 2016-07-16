package com.top.jbb.activity.tel400;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.top.jbb.R;
import com.top.jbb.bean.tel400.ProductPriceListResult;
import com.top.jbb.data.RunnableData;
import com.top.jbb.utils.Constant;
import com.top.jbb.utils.TipTools;

public class Tel400Activity extends Activity {
	private RelativeLayout select;
	private RelativeLayout charge;
	private RelativeLayout introduction;
	private RelativeLayout additional;
	private RelativeLayout valueAdded;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getProductPriceList();
		setContentView(R.layout.activity_400_main);
		select = (RelativeLayout) this.findViewById(R.id.tel_select);
		select.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Tel400Activity.this,Tel400SelectActivity.class);
				startActivity(intent);
			}
		});

		charge = (RelativeLayout) this.findViewById(R.id.tel_charge);
		charge.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Tel400Activity.this,Tel400ChargeActivity.class);
				startActivity(intent);
			}
		});

		introduction = (RelativeLayout) this.findViewById(R.id.tel_introduction);
		introduction.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				 Intent intent = new Intent(Tel400Activity.this,Tel400DescActivity.class);
				  startActivity(intent);
			}
		});
		
		
		valueAdded = (RelativeLayout) this.findViewById(R.id.tel_value_added);
		valueAdded.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				TipTools.tips(Tel400Activity.this, "==暂不开放==") ;
				//Intent intent = new Intent(Tel400Activity.this,Tel400DescActivity.class);
				 // startActivity(intent);
			}
		});
		
		introduction = (RelativeLayout) this.findViewById(R.id.tel_introduction);
		introduction.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// Intent intent = new Intent(Tel400Activity.this,Tel400DescActivity.class);
				//  startActivity(intent);
				TipTools.tips(Tel400Activity.this, "==暂不开放==") ;
			}
		});

		initBack();
	}

	private void initBack() {
		TextView back = (TextView) this.findViewById(R.id.top_return);
		back.setText(" 400电话");
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
	
	private void getProductPriceList(){
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.GET, Constant.get400listProductPriceUrl,
				null, new RequestCallBack<String>() {
					@Override
					public void onFailure(HttpException arg0, String arg1) {					
					}
					@Override
					public void onSuccess(ResponseInfo<String> response) {
						Gson gson = new Gson();
						ProductPriceListResult result = gson.fromJson(response.result,ProductPriceListResult.class);
						RunnableData.genList(result.getList());
					}
				});

	}
}
