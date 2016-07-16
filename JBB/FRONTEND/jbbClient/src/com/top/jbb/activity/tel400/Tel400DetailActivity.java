package com.top.jbb.activity.tel400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.top.jbb.R;
import com.top.jbb.bean.tel400.ProductPrice;
import com.top.jbb.bean.tel400.ProductPriceListResult;
import com.top.jbb.bean.tel400.ProductPriceResult;
import com.top.jbb.data.RunnableData;
import com.top.jbb.utils.CallBackInterface;
import com.top.jbb.utils.Constant;
import com.top.jbb.utils.DensityUtil;
import com.top.jbb.utils.HttpTools;
import com.top.jbb.utils.LoginInfo;
import com.top.jbb.view.FlowLayout;
import com.top.jbb.view.SelectPicPopupWindow;
import com.top.jbb.view.TimeDismissDialog;

public class Tel400DetailActivity extends Activity implements CallBackInterface{
	
	private TextView orderBtn;
	private TextView orderIntent;
	private TextView custome;
	private TextView textNumber;
	private int minPrice=100;
	private String number;
	private LinearLayout comboLayout1;
	private LinearLayout comboLayout2;
	private TextView comboTitle;
	private int value;
	private List<Button> buttonList=new ArrayList<Button>();
	private FlowLayout	addtionalServiceLayOut;
	private FlowLayout	addValueServiceLayOut;
	private SelectPicPopupWindow menuWindow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_400_detail);
		number=this.getIntent().getStringExtra("number");
		init();
		initBack();
	}

	
	private void init(){
		if(RunnableData.packagePriceList==null){
			getProductPriceList();
		}
		
		addtionalServiceLayOut=(FlowLayout)this.findViewById(R.id.addtional_service);
		addValueServiceLayOut=(FlowLayout)this.findViewById(R.id.add_value_service);
		
		comboTitle=(TextView)this.findViewById(R.id.combo_title);
		textNumber=(TextView)findViewById(R.id.number);
		textNumber.setText(number);
		
		comboLayout1=(LinearLayout)this.findViewById(R.id.combo1);
		comboLayout2=(LinearLayout)this.findViewById(R.id.combo2);
		custome=(TextView)this.findViewById(R.id.detail_400_order_custome);
		custome.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {				
				Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:4000888888"));
				startActivity(intent);
				
			}});
		
		orderBtn=(TextView)this.findViewById(R.id.detail_400_order);
		orderBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {	
				menuWindow = new SelectPicPopupWindow(Tel400DetailActivity.this,number,value);
				//显示窗口
				menuWindow.showAtLocation(Tel400DetailActivity.this.findViewById(R.id.bottom_position), Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0); //设置layout在PopupWindow中显示的位置
//				Intent intent = new Intent(Tel400DetailActivity.this,SelectPicPopupWindow.class);
//				startActivity(intent);
//				Intent intent=new Intent(Tel400DetailActivity.this,ShoppingCartActivity.class);
//				intent.putExtra("count", value/100);
//				intent.putExtra("orderNumber", String.valueOf(System.currentTimeMillis()));
//				intent.putExtra("title", "400电话下单");
//				startActivity(intent);
			}});
		
		
		orderIntent=(TextView)this.findViewById(R.id.detail_400_order_intent);
		orderIntent.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
//				TimeDismissDialog dialog=new TimeDismissDialog(Tel400DetailActivity.this,"提交成功");
//				dialog.show();
				try {
					saveIntention();
				} catch (Exception e) {
				}
			}});
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("number", number);
		HttpTools.httpGet(Constant.get400MinumnPriceUrl, map, this);
		
		initAdditionalFunction();
		
		initAddValueService();
	}
	
	private void initBack() {
		TextView back = (TextView) this.findViewById(R.id.top_return);
		back.setText(" 号码详情");
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}

	private void initAdditionalFunction(){
		for(ProductPrice p:RunnableData.additionalFunctionList){
			if(p.getPrice()<=0){
				addTextView(addtionalServiceLayOut,p.getServiceName());
			}
		}
	}
	private void initAddValueService(){
		for(ProductPrice p:RunnableData.valueAddServiceList){
			if(p.getPrice()<=0){
				addTextView(addValueServiceLayOut,p.getServiceName());
			}
		}
	}
	
	
	@Override
	public void successCallBack(ResponseInfo<String> response,
			Map<String, Object> map2) {		
		Gson gson = new Gson();
		ProductPriceResult result = gson.fromJson(response.result,ProductPriceResult.class);
		if(result.getObj()!=null){
			minPrice=result.getObj().getPrice();
		}
		int num=0;
		for(ProductPrice price:RunnableData.packagePriceList){
			if(price.getPrice() < minPrice){
				continue;
			}
			if(num<3){
				addBtn(comboLayout1,price.getPrice());
			}else{
				addBtn(comboLayout2,price.getPrice());
			}
			num++;
			if(num>=6){
				break;
			}
		}
		addBtn(comboLayout2,100);
		num++;
		if(num>0 && num<3){
			for(int i=0;i<3-num;i++){
				addPositionBtn(comboLayout1,1000);
			}
		}else if(num>3 && num<6){
			for(int i=0;i<6-num;i++){
				addPositionBtn(comboLayout2,1000);
			}
		}
		if(num==0){
			comboTitle.setVisibility(View.GONE);
		}
		
	}
	
	private void addTextView(FlowLayout layout,String str){
		int dp=DensityUtil.dip2px(this,2);
		int dp2=DensityUtil.dip2px(this,8);
		TextView btn = new TextView(this);
		btn.setText(str);
		btn.setTextSize(14);
		LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		lp1.gravity=Gravity.CENTER;
		lp1.setMargins(dp, dp2, dp,dp2);
		layout.addView(btn, lp1);
	}
	
	
	private void addBtn(LinearLayout layout,int price){
		int dp=DensityUtil.dip2px(this,5);
		Button btn = new Button(this);
		btn.setId(price);
		btn.setText(price/100 +"元");
		btn.setTag(price);
		btn.setBackgroundResource(R.drawable.tel_400_select_bg_normal);
		LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		lp1.weight=1;
		lp1.gravity=Gravity.CENTER;
		lp1.setMargins(dp, dp, dp,dp);
		btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				for(Button v1:buttonList){
					v1.setTextColor(Color.parseColor("#525252"));
				}
				((Button)v).setTextColor(Color.parseColor("#ff6737"));
				value=Integer.valueOf(v.getTag().toString());
			}});
		layout.addView(btn, lp1);
		buttonList.add(btn);
		if(buttonList.size()==1){
			btn.setTextColor(Color.parseColor("#ff6737"));
			value=Integer.valueOf(btn.getTag().toString());
		}
	}
	
	private void addPositionBtn(LinearLayout layout,int price){
		int dp=DensityUtil.dip2px(this,5);
		Button btn = new Button(this);
		btn.setId(price);
		btn.setText(price/100 +"元");
		btn.setTextColor(Color.parseColor("#ffffff"));
		btn.setBackgroundResource(R.drawable.tel_400_selector_position_bg);//
		LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		lp1.weight=1;
		lp1.gravity=Gravity.CENTER;
		lp1.setMargins(dp, dp, dp,dp);		
		layout.addView(btn, lp1);
	}

	@Override
	public void failCallBack(Map<String, Object> map) {
	}
	
	@Override
	public boolean preCallBack(Map<String, Object> map) {
		return true;
	}
	
	@Override
	public void postCallBack(Map<String, Object> map) {
	}
	
	private void getProductPriceList(){
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.GET, Constant.get400listProductPriceUrl,
				null, new RequestCallBack<String>() {
					@Override
					public void onFailure(HttpException arg0, String arg1) {
						Log.e("=====", "------------------"+arg1);
					}
					@Override
					public void onSuccess(ResponseInfo<String> response) {
						Gson gson = new Gson();
						ProductPriceListResult result = gson.fromJson(response.result,ProductPriceListResult.class);
						RunnableData.genList(result.getList());
					}
				});

	}
	
	private void saveIntention() throws Exception{
		JSONObject json=new JSONObject();
		json.put("userId", LoginInfo.id);
		json.put("contactName","11");
		json.put("productId", LoginInfo.id);
		json.put("contactPhone", LoginInfo.telephone);
		json.put("areaCode", "1");
		json.put("status", "1");
		json.put("remark", "1");
		HttpUtils httpUtils = new HttpUtils();
		RequestParams params = new RequestParams();
		if(json!=null){
			params.setBodyEntity(new StringEntity(json.toString()));
		}
		params.setHeader("Content-Type", "application/json");
		httpUtils.send(HttpMethod.POST,Constant.saveIntentionUrl,params, new RequestCallBack<String>() {
					@Override
					public void onFailure(HttpException arg0, String arg1) {
					}

					@Override
					public void onSuccess(ResponseInfo<String> response) {
						TimeDismissDialog dialog=new TimeDismissDialog(Tel400DetailActivity.this,"提交成功");
						dialog.show();
					}
				});

	}

}
