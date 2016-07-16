package com.top.jbb.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.lidroid.xutils.http.ResponseInfo;
import com.top.jbb.R;
import com.top.jbb.utils.CallBackInterface;
import com.top.jbb.utils.Constant;
import com.top.jbb.utils.TipTools;
import com.top.jbb.utils.ValidateTools;

import java.util.Map;

public class ForgetPwdActivity extends Activity implements CallBackInterface {
	
	private TextView next;
	private EditText userName;
	private EditText smsCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forget_passwd);
		
		userName=(EditText)this.findViewById(R.id.forget_pwd_phone);
		smsCode=(EditText)this.findViewById(R.id.forget_pwd_sms_code);
		
		next=(TextView)this.findViewById(R.id.forget_next);
		next.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				next(arg0);
			}});
		
		initGetCode();
		
		initBack();
	}
	
	private void next(View v){
		if(!validate()){
			return;
		}
		Intent intent = new Intent(this, UpdatePWDActivity.class);
		intent.putExtra("telephone", userName.getText().toString());
		intent.putExtra("smsCode", smsCode.getText().toString());
		startActivity(intent);
		finish();
		
//		Map<String,String> map=new HashMap<String,String>();
//		map.put("telephone", userName.getText().toString());
//		map.put("smsCode", smsCode.getText().toString());
//		HttpTools.httpPost(Constant.forgetPwdUrl, map, this);
	}

	@Override
	public void successCallBack(ResponseInfo<String> response,
			Map<String, Object> map2) {
		
		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		finish();
	}

	@Override
	public void failCallBack(Map<String, Object> map) {
		TipTools.tips(this, map.get("data").toString());
	}

	@Override
	public boolean preCallBack(Map<String, Object> map) {
		if(userName.getText().toString()==null || userName.getText().toString().length()<=0){
			TipTools.tips(this, Constant.telephoneTip);
			return false;
		}
		if(smsCode.getText().toString()==null || smsCode.getText().toString().length()<=0){
			TipTools.tips(this, Constant.smsCodeNoNull);
			return false;
		}
		return true;
	}

	@Override
	public void postCallBack(Map<String, Object> map) {
		
	}
	
	public boolean validate() {
		if(!ValidateTools.IsIntNumber(userName.getText().toString())){
			TipTools.tips(this, Constant.telephoneTip);
			return false;
		}
		if(!ValidateTools.isSmsCode(smsCode.getText().toString())){
			TipTools.tips(this, Constant.smsCodeNoNull);
			return false;
		}
		return true;
	}
	
	private void initBack(){
		TextView back=(TextView)this.findViewById(R.id.top_return);
		back.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				finish();		
			}});
	}
	
	private void initGetCode(){
		TextView getCode=(TextView)this.findViewById(R.id.forget_pwd_get_code);
		getCode.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				TipTools.tips(ForgetPwdActivity.this, "验证码当前统一为:123456");	
			}});
	}
}
