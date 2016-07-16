package com.top.jbb.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.http.ResponseInfo;
import com.top.jbb.R;
import com.top.jbb.bean.common.Response;
import com.top.jbb.utils.CallBackInterface;
import com.top.jbb.utils.Constant;
import com.top.jbb.utils.HttpTools;
import com.top.jbb.utils.TipTools;
import com.top.jbb.utils.ValidateTools;

import java.util.HashMap;
import java.util.Map;

public class UpdatePWDActivity extends Activity implements CallBackInterface{
	
	private TextView next;
	private EditText pwd;
	private EditText pwd2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update_passwd);
		pwd=(EditText)this.findViewById(R.id.update_pwd_pwd);
		pwd2=(EditText)this.findViewById(R.id.update_pwd_pwd1);
		next=(TextView)this.findViewById(R.id.update_pwd_next);
		next.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				next(arg0);
			}});
		initBack();
	}
	
	private void next(View v){
		String telepone=this.getIntent().getStringExtra("telephone");
		String smsCode=this.getIntent().getStringExtra("smsCode");
	
		Map<String,String> map=new HashMap<String,String>();
		map.put("telephone",telepone);
		map.put("passwd", pwd.getText().toString());
		map.put("smsCode", smsCode);
		HttpTools.httpPost(Constant.setPwdUrl, map, this);
	}

	@Override
	public void successCallBack(ResponseInfo<String> response,Map<String, Object> map2) {
		Gson gson=new Gson();
		Response resp=gson.fromJson(response.result, Response.class);
		if(resp.getResult()<0){
			TipTools.tips(this, resp.getErrorMsg());
		}else{
			Intent intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
			finish();	
		}
	}

	@Override
	public void failCallBack(Map<String, Object> map) {
		TipTools.tips(this, map.get("desc").toString());
		
	}

	@Override
	public boolean preCallBack(Map<String, Object> map) {
		if(!ValidateTools.isPasswd(pwd.getText().toString())){
			TipTools.tips(this, Constant.pwdNoNull);
			return false;
		}
		
		if(!pwd.getText().toString().equals(pwd2.getText().toString())){
			TipTools.tips(this, Constant.pwdNoEqual);
			return false;
		}
		return true;
	}

	@Override
	public void postCallBack(Map<String, Object> map) {
		
		
	}
	
	private void initBack(){
		TextView back=(TextView)this.findViewById(R.id.top_return);
		back.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				finish();		
			}});
	}
}
