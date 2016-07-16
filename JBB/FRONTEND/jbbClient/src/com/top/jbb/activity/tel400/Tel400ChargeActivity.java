package com.top.jbb.activity.tel400;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.top.jbb.R;
import com.top.jbb.activity.pay.ShoppingCartActivity;
import com.top.jbb.utils.TipTools;

public class Tel400ChargeActivity extends Activity implements OnClickListener{
	
	private Button  chargeBtn1;
	private Button  chargeBtn2;
	private Button  chargeBtn3;
	private Button  chargeBtn4;
	private Button  chargeBtn5;
	private Button  chargeBtn6;
	private TextView submit;
	private EditText selfCount;
	private int value=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_400_charge);	
		selfCount=(EditText)this.findViewById(R.id.selfCount);

		selfCount.setOnFocusChangeListener(new OnFocusChangeListener(){
			@Override
			public void onFocusChange(View v, boolean arg1) {
				if(v.hasFocus()){
					recover();
					value=0;
				}
				
			}});
		selfCount.setOnClickListener(this);
		submit=(TextView)this.findViewById(R.id.tel_400_charge_submit);
		submit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				String str=selfCount.getText().toString();
				if(value<=0 && (str==null || str.length()==0)){
					TipTools.tips(Tel400ChargeActivity.this, "请选择金额!");
					return;
				}
				if(value<=0){
					value=Integer.valueOf(str);
				}	
				Intent intent=new Intent(Tel400ChargeActivity.this,ShoppingCartActivity.class);
				intent.putExtra("count", value);
				intent.putExtra("orderNumber", String.valueOf(System.currentTimeMillis()));
				intent.putExtra("title", "400电话充值");
				startActivity(intent);
			}});
		
		init();
		initBack();
	}
	
	private void init(){
		chargeBtn1=(Button)this.findViewById(R.id.tel_400_charge_1);
		chargeBtn2=(Button)this.findViewById(R.id.tel_400_charge_2);
		chargeBtn3=(Button)this.findViewById(R.id.tel_400_charge_3);
		chargeBtn4=(Button)this.findViewById(R.id.tel_400_charge_4);
		chargeBtn5=(Button)this.findViewById(R.id.tel_400_charge_5);
		chargeBtn6=(Button)this.findViewById(R.id.tel_400_charge_6);
		
		chargeBtn1.setOnClickListener(this);
		chargeBtn2.setOnClickListener(this);
		chargeBtn3.setOnClickListener(this);
		chargeBtn4.setOnClickListener(this);
		chargeBtn5.setOnClickListener(this);
		chargeBtn6.setOnClickListener(this);
	}
	
	private void initBack(){
		TextView back=(TextView)this.findViewById(R.id.top_return);
		back.setText(" 充值");
		back.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				finish();		
			}});
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.selfCount){
			recover();
			value=0;
		}
		else{
			selfCount.setText("");
			recover();
			v.setBackgroundResource(R.drawable.tel_400_charge_selected);
			((Button)v).setTextColor(Color.parseColor("#ff6737"));
			value=Integer.valueOf(v.getTag().toString());
		}
	}
	
	private void recover(){
		chargeBtn1.setBackgroundResource(R.drawable.tel_400_charge_select);
		chargeBtn2.setBackgroundResource(R.drawable.tel_400_charge_select);
		chargeBtn3.setBackgroundResource(R.drawable.tel_400_charge_select);
		chargeBtn4.setBackgroundResource(R.drawable.tel_400_charge_select);
		chargeBtn5.setBackgroundResource(R.drawable.tel_400_charge_select);
		chargeBtn6.setBackgroundResource(R.drawable.tel_400_charge_select);
		
		chargeBtn1.setTextColor(Color.parseColor("#525252"));
		chargeBtn2.setTextColor(Color.parseColor("#525252"));
		chargeBtn3.setTextColor(Color.parseColor("#525252"));
		chargeBtn4.setTextColor(Color.parseColor("#525252"));
		chargeBtn5.setTextColor(Color.parseColor("#525252"));
		chargeBtn6.setTextColor(Color.parseColor("#525252"));
	}
}
