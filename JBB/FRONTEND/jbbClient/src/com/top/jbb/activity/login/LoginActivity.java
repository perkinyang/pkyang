package com.top.jbb.activity.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lidroid.xutils.http.ResponseInfo;
import com.top.jbb.R;
import com.top.jbb.activity.MainActivity;
import com.top.jbb.bean.user.UserLogin;
import com.top.jbb.utils.CallBackInterface;
import com.top.jbb.utils.Constant;
import com.top.jbb.utils.HttpTools;
import com.top.jbb.utils.LoginInfo;
import com.top.jbb.utils.TipTools;
import com.top.jbb.utils.ValidateTools;
import com.top.jbb.view.address.ChangeAddressDialog;
import com.top.jbb.view.address.ChangeAddressDialog.OnAddressCListener;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity implements CallBackInterface{
	private AutoCompleteTextView userName;
	private EditText passwd;
	private TextView button;
	private TextView register;
	private TextView pwd;
	private SharedPreferences latestSP;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		latestSP = this.getSharedPreferences("latestsp", MODE_PRIVATE);
		userName=(AutoCompleteTextView)this.findViewById(R.id.userName);
		passwd=(EditText)this.findViewById(R.id.passwd);
		register=(TextView)this.findViewById(R.id.login_register);
		pwd=(TextView)this.findViewById(R.id.login_pwd);
		
		button=(TextView)this.findViewById(R.id.logBT);
		button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				login(arg0);
			}});
		
		register.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				register(arg0);
			}});
		
		pwd.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				forgetPwd(arg0);
			}});
		
	}
	
	private void login(View v){
		Map<String,String> map=new HashMap<String,String>();
		map.put("telephone", userName.getText().toString());
		map.put("passwd", passwd.getText().toString());
		HttpTools.httpPost(Constant.loginUrl, map, this);
	}
	
	private void register(View v){
		Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
		startActivity(intent);
		//finish();
	}
	
	private void forgetPwd(View v){
		Intent intent = new Intent(LoginActivity.this, ForgetPwdActivity.class);
		startActivity(intent);
		//finish();
	}

	@Override
	public void successCallBack(ResponseInfo<String> response,Map<String, Object> map2) {
		Gson gson = new Gson();
		UserLogin msg = gson.fromJson(response.result,UserLogin.class);
		if(msg.getResult()<1){
			TipTools.tips(this, msg.getErrorMsg());
			return;
		}
		LoginInfo.id=msg.getUserLogin().getId();
		LoginInfo.telephone=userName.getText().toString();
		latestSP.edit().putString("userName", userName.getText().toString()).commit();
		latestSP.edit().putString("passwd", passwd.getText().toString()).commit();
		LoginInfo.userName=userName.getText().toString();
		LoginInfo.passwd=passwd.getText().toString();
		//Intent intent = new Intent(LoginActivity.this, FillPersonDetailActivity.class);
		Intent intent = new Intent(LoginActivity.this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// 它可以关掉所要到的界面中间的activity
		startActivity(intent);
		finish();
		
	}

	@Override
	public void failCallBack(Map<String, Object> map) {
		TipTools.tips(this, map.get("desc").toString());
	}

	@Override
	public boolean preCallBack(Map<String, Object> map) {
		if(!ValidateTools.isMobileNO(userName.getText().toString())){
			TipTools.tips(this, Constant.userNameNoNull);
			return false;
		}
		if(!ValidateTools.isPasswd(passwd.getText().toString())){
			TipTools.tips(this, Constant.pwdNoNull);
			return false;
		}
		return true;
	}

	@Override
	public void postCallBack(Map<String, Object> map) {
		
	}
	
	
	private void test(){
		ChangeAddressDialog dialog=new ChangeAddressDialog(this);
		dialog.setAddresskListener(new OnAddressCListener(){

			@Override
			public void onClick(String province, String city, String area,
					String areaCode) {
				TipTools.tips(LoginActivity.this, province+city+area);
				
			}});
		dialog.show();
	}
}
