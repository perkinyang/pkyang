package com.top.jbb.activity.login;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.top.jbb.R;
import com.top.jbb.activity.MainActivity;
import com.top.jbb.bean.UserInfo;
import com.top.jbb.bean.UserTypeEnume;
import com.top.jbb.bean.common.Area;
import com.top.jbb.bean.common.AreaResult;
import com.top.jbb.bean.common.IndustryResult;
import com.top.jbb.bean.common.IndustryResult.Industry;
import com.top.jbb.utils.CallBackInterface;
import com.top.jbb.utils.Constant;
import com.top.jbb.utils.HttpTools;
import com.top.jbb.utils.RequestCodeTools;
import com.top.jbb.utils.TipTools;
import com.top.jbb.utils.ValidateTools;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class FillPersonDetailActivity extends Activity implements OnClickListener,CallBackInterface{
	private EditText companyName;
	private EditText contacts;
	private EditText telephone;
	private EditText email;
	private EditText sex;
	private EditText industry;
	private EditText area;
	private EditText street;
	private EditText address;
	private TextView button;
	private TextView companySelect;
	private TextView personSelect;
	private View companySelectIcon;
	private View personSelectIcon;
	private int selectedSexIndex = 0;
	private int selectedIndustryIndex = 0;
	private int selectedStreetIndex = 0;
	private Dialog dialog1;
	private int userType=UserTypeEnume.COMPANY.getUserType();
	private LinearLayout industryLayout;
	private LinearLayout companyNameLayout;
	private Area province,city,areaResult,streetResult;
	private List<Area> streetList;
	private List<Industry> industryList;
	private Industry industrySelected;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fill_person_detail);
		init();
	}

	private void init(){
		companySelect=(TextView)this.findViewById(R.id.fill_person_company);
		personSelect=(TextView)this.findViewById(R.id.fill_person_private);
		companySelectIcon=(View)this.findViewById(R.id.fill_person_company_icon);
		personSelectIcon=(View)this.findViewById(R.id.fill_person_private_icon);
		
		companyName=(EditText)this.findViewById(R.id.detail_company_name);
		companyNameLayout=(LinearLayout)this.findViewById(R.id.detail_company_name_layout);
		industryLayout=(LinearLayout)this.findViewById(R.id.detail_industry_layout);
		
		contacts=(EditText)this.findViewById(R.id.detail_contacts);
		telephone=(EditText)this.findViewById(R.id.detail_telephone);
		email=(EditText)this.findViewById(R.id.detail_email);
		sex=(EditText)this.findViewById(R.id.detail_sex);
		industry=(EditText)this.findViewById(R.id.detail_industry);
		area=(EditText)this.findViewById(R.id.detail_area);
		street=(EditText)this.findViewById(R.id.detail_street);		
		address=(EditText)this.findViewById(R.id.detail_address);
		button=(TextView)this.findViewById(R.id.detail_save);
		
		sex.setOnClickListener(this);
		industry.setOnClickListener(this);
		area.setOnClickListener(this);
		street.setOnClickListener(this);
		
		button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				try {
					save();
				} catch (Exception e) {
					TipTools.tips(FillPersonDetailActivity.this, "处理出错，请稍后再试!");
				}
			}});
		
		companySelect.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				selectCompany();
			}});
		
		personSelect.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				selectPerson();
			}});
		
		getIndustryList();
	}
	
	private void selectCompany(){
		companySelectIcon.setBackgroundResource(R.drawable.icon_current);
		personSelectIcon.setBackgroundResource(R.drawable.icon_current_white);
		companyNameLayout.setVisibility(View.VISIBLE);
		industryLayout.setVisibility(View.VISIBLE);
		userType=UserTypeEnume.COMPANY.getUserType();
	}
	
	private void selectPerson(){
		personSelectIcon.setBackgroundResource(R.drawable.icon_current);
		companySelectIcon.setBackgroundResource(R.drawable.icon_current_white);
		companyNameLayout.setVisibility(View.GONE);
		industryLayout.setVisibility(View.GONE);
		userType=UserTypeEnume.PERSON.getUserType();
	}
	
	private void save() throws Exception{
		JSONObject map=new JSONObject();
		map.put("userType",userType);
		map.put("companyName", companyName.getText().toString());
		map.put("contacts", contacts.getText().toString());
		map.put("telephone", telephone.getText().toString());
		map.put("email", email.getText().toString());
		map.put("sex", Integer.valueOf(sex.getTag().toString()));
		map.put("industry", industrySelected.getCode());
		map.put("industryName", industrySelected.getName());
		map.put("provinceCode",province.getCode());
		map.put("provinceName", province.getName());
		map.put("cityCode", city.getCode());
		map.put("cityName", city.getName());
		map.put("areaCode", areaResult.getCode());
		map.put("areaName", areaResult.getName());
		map.put("streetCode", streetResult.getCode());
		map.put("streetName", streetResult.getName());
		map.put("address", address.getText().toString());
		HttpTools.httpPost(Constant.fillPersonUrl, map, this);
	}
	
	@Override
	public void onClick(View v){
		switch (v.getId()) {
		case R.id.detail_area:	
			areaSelect();
			break;
		case R.id.detail_industry:
			showDialog((EditText)v);
			break;
		case R.id.detail_sex:	
			showDialogSex((EditText)v);
			break;
		case R.id.detail_street:
			if(areaResult==null){
				TipTools.tips(FillPersonDetailActivity.this, "请选择地区!");
			}else{
				showDialogStreet((EditText)v);
			}
			break;
		}
	}
	
	
	private void areaSelect(){
		Intent intent=new Intent(this,AreaListSelectActivity.class);
		startActivityForResult(intent, RequestCodeTools.areaRequestCode);
	}
	
	private void showDialog(final EditText v) {
		
		String text=v.getText().toString();
		int initIndex=0;
		final String arr[] = new String[industryList.size()];
		int i=0;
		for(Industry tmp:industryList){
			arr[i]=tmp.getName();
			if(tmp.getName().equals(text)){
				initIndex=i;
			}
			i++;
		}
		Dialog alertDialog = new AlertDialog.Builder(this)
				.setTitle("请选择行业")
				.setSingleChoiceItems(arr, initIndex,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								selectedIndustryIndex = which;
							}
						})
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						v.setText(arr[selectedIndustryIndex]);
						industrySelected=industryList.get(selectedIndustryIndex);
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				}).create();
		alertDialog.show();
	}
		
	private void showDialogSex(final EditText v) {
		String text=v.getText().toString();
		int initIndex=0;
		if("女".equals(text)){
			initIndex=1;
		}
		
		final String arr[] = new String[2];
		arr[0]="男";
		arr[1]="女";
		Dialog alertDialog = new AlertDialog.Builder(this)
				.setTitle("请选择性别")
				.setSingleChoiceItems(arr, initIndex,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								selectedSexIndex = which;
							}
						})
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						v.setText(arr[selectedSexIndex]);
						v.setTag(selectedSexIndex);
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				}).create();
		alertDialog.show();
	}

	private void showDialogStreet(final EditText v) {
		String text=v.getText().toString();
		int initIndex=0;
		final String arr[] = new String[streetList.size()];
		int i=0;
		for(Area tmp:streetList){
			arr[i]=tmp.getName();
			if(tmp.getName().equals(text)){
				initIndex=i;
			}
			i++;
		}
		Dialog alertDialog = new AlertDialog.Builder(this)
				.setTitle("请选择街道")
				.setSingleChoiceItems(arr, initIndex,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,int which) {
								selectedStreetIndex = which;
							}
						})
				.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						street.setText(arr[selectedStreetIndex]);
						streetResult=streetList.get(selectedStreetIndex);
					}
				})
				.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				}).create();
		alertDialog.show();
	}

	@Override
	public void successCallBack(ResponseInfo<String> response,Map<String,Object> map2) {
		
		UserInfo.address=address.getText().toString();
		UserInfo.userType=userType;
		UserInfo.companyName=companyName.getText().toString();
		UserInfo.telephone=telephone.getText().toString();
		UserInfo.email=email.getText().toString();
		UserInfo.sex=sex.getText().toString();
		UserInfo.industry=industry.getText().toString();
		UserInfo.street=street.getText().toString();
		UserInfo.area=area.getText().toString();
		UserInfo.contacts=contacts.getText().toString();
		Intent intent = new Intent(FillPersonDetailActivity.this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// 它可以关掉所要到的界面中间的activity
		startActivity(intent);
		finish();	
	}

	@Override
	public void failCallBack(Map<String,Object> map) {
		if(dialog1!=null){
			dialog1.dismiss();
			dialog1=null;
		}
		Toast.makeText(this, "请求失败，请检查网络！", Toast.LENGTH_LONG).show();
	}
	
	private void showDialog(){
		dialog1 = new Dialog(this,R.style.loading_dialog);
		dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog1.setContentView(R.layout.dialog1);
		dialog1.setCanceledOnTouchOutside(false);
		dialog1.show();
	}

	@Override
	public boolean preCallBack(Map<String,Object> map) {
		if((this.userType==UserTypeEnume.COMPANY.getUserType())&& (companyName.getText().toString()==null || companyName.getText().toString().length()<=0)){
			TipTools.tips(this, Constant.companyNameNoNull);
			return false;
		}
		if(contacts.getText().toString()==null || contacts.getText().toString().length()<=0){
			TipTools.tips(this, Constant.contactsNoNull);
			return false;
		}
		
		if(telephone.getText().toString()==null || telephone.getText().toString().length()<=0 || !ValidateTools.isMobileNO(telephone.getText().toString())){
			TipTools.tips(this, Constant.telephoneTip);
			return false;
		}
		
		if(email.getText().toString()==null || email.getText().toString().length()<=0 || !ValidateTools.isEmail(email.getText().toString())){
			TipTools.tips(this, Constant.emailTips);
			return false;
		}
		
		if(sex.getText().toString()==null || sex.getText().toString().length()<=0){
			TipTools.tips(this, Constant.sexNoNull);
			return false;
		}
		
		
		if((this.userType==UserTypeEnume.COMPANY.getUserType())&& (industry.getText().toString()==null || industry.getText().toString().length()<=0)){
			TipTools.tips(this, Constant.industryNoNull);
			return false;
		}
		
		if(area.getText().toString()==null || area.getText().toString().length()<=0){
			TipTools.tips(this, Constant.areaNoNull);
			return false;
		}
		
		if(street.getText().toString()==null || street.getText().toString().length()<=0){
			TipTools.tips(this, Constant.streetNoNull);
			return false;
		}
		if(address.getText().toString()==null || address.getText().toString().length()<=0){
			TipTools.tips(this, Constant.addressNoNull);
			return false;
		}
		return true;
	}
	
	@Override
	public void postCallBack(Map<String, Object> map) {
		if(dialog1!=null){
			dialog1.dismiss();
			dialog1=null;
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (resultCode) {
		case RequestCodeTools.areaRequestCode:
			province=(Area)data.getSerializableExtra("province");
			city=(Area)data.getSerializableExtra("city");
			areaResult=(Area)data.getSerializableExtra("area");
			area.setText(province.getName()+city.getName()+areaResult.getName());
			getStreetList();
			street.setText(null);
			streetResult=null;
            break;
		default:
	        break;
		}
	}
	
	
	private void getStreetList(){
		HttpUtils httpUtils = new HttpUtils();
		RequestParams params = new RequestParams();
		params.addQueryStringParameter("code",String.valueOf(areaResult.getCode()));
		params.addQueryStringParameter("level","4");
		httpUtils.send(HttpMethod.GET, Constant.getAreaListUrl,
				params, new RequestCallBack<String>() {
					@Override
					public void onFailure(HttpException arg0, String arg1) {					
						
					}
					@Override
					public void onSuccess(ResponseInfo<String> response) {
						Gson gson = new Gson();
						AreaResult result = gson.fromJson(response.result,AreaResult.class);
						List<Area> list=result.getList();
						if(list==null || list.size()==0){
							return;
						}
						streetList=list;
					}
				});

	}
	
	private void getIndustryList(){
		HttpUtils httpUtils = new HttpUtils();
		httpUtils.send(HttpMethod.GET, Constant.getIndustryListUrl,
				null, new RequestCallBack<String>() {
					@Override
					public void onFailure(HttpException arg0, String arg1) {					
						
					}
					@Override
					public void onSuccess(ResponseInfo<String> response) {
						Gson gson = new Gson();
						IndustryResult result = gson.fromJson(response.result,IndustryResult.class);
						List<Industry> list=result.getList();
						if(list==null || list.size()==0){
							return;
						}
						industryList=list;
					}
				});

	}
}
