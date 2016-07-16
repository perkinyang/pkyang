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
import com.top.jbb.bean.user.UserDetailDTO;
import com.top.jbb.utils.CallBackInterface;
import com.top.jbb.utils.Constant;
import com.top.jbb.utils.HttpTools;
import com.top.jbb.utils.TipTools;
import com.top.jbb.utils.ValidateTools;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends Activity implements CallBackInterface{
	
	private TextView next;
	private EditText userName;
	private EditText smsCode;
	private EditText invitationCode;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);	
		userName=(EditText)this.findViewById(R.id.register_register_phone);
		smsCode=(EditText)this.findViewById(R.id.register_code);
		invitationCode=(EditText)this.findViewById(R.id.register_register_invitation);
		next=(TextView)this.findViewById(R.id.register_next);
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
		Map<String,String> map=new HashMap<String,String>();
		map.put("telephone", userName.getText().toString());
		HttpTools.httpPost(Constant.getUserDetailUrl, map, this);
	}

	public boolean validate() {
		if(!ValidateTools.isMobileNO(userName.getText().toString())){
			TipTools.tips(this, Constant.telephoneTip);
			return false;
		}
		if(!ValidateTools.isSmsCode(smsCode.getText().toString())){
			TipTools.tips(this, Constant.smsCodeNoNull);
			return false;
		}
		
		if(!ValidateTools.isInvitationCode(invitationCode.getText().toString())){
			TipTools.tips(this, Constant.invitationCodeNoNull);
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
		TextView getCode=(TextView)this.findViewById(R.id.register_get_code);
		getCode.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				TipTools.tips(RegisterActivity.this, "验证码当前统一为:123456");	
			}});
	}

	@Override
	public void successCallBack(ResponseInfo<String> response,
			Map<String, Object> map2) {
		Gson gson=new Gson();
		UserDetailDTO resp=gson.fromJson(response.result, UserDetailDTO.class);
		if(resp.getResult()<0){
			TipTools.tips(this, resp.getErrorMsg());
		}else if(resp.getObj()!=null){
			TipTools.tips(this,"该用户已经注册!");
		}else{
			Intent intent = new Intent(this, SetPWDActivity.class);
			intent.putExtra("telephone", userName.getText().toString());
			intent.putExtra("smsCode", smsCode.getText().toString());
			intent.putExtra("invitationCode", invitationCode.getText().toString());
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
		return true;
	}

	@Override
	public void postCallBack(Map<String, Object> map) {
		
	}
}
