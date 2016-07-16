package com.top.jbb.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.top.jbb.R;
import com.top.jbb.activity.pay.ShoppingCartActivity;
import com.top.jbb.view.AddAndSubView.OnNumChangeListener;

public class SelectPicPopupWindow extends PopupWindow implements OnNumChangeListener {

	private TextView submit,cancel,priceCount,numberText;
	private View mMenuView;
	private String number;
	private int price;
	private int payCount;
	private Context context;
	public SelectPicPopupWindow(Context context,String number,int price) {
		super(context);
		this.context=context;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.pop, null);
		LinearLayout subAdd = (LinearLayout) mMenuView.findViewById(R.id.detail_400_order_sub_add);
		AddAndSubView addAndSubView = new AddAndSubView(context);
		addAndSubView.setOnNumChangeListener(this);
		subAdd.addView(addAndSubView);
		
		numberText=(TextView) mMenuView.findViewById(R.id.detail_400_pop_number);
		submit=(TextView) mMenuView.findViewById(R.id.detail_400_submit);
		cancel=(TextView) mMenuView.findViewById(R.id.detail_400_cancel);
		priceCount=(TextView) mMenuView.findViewById(R.id.detail_400_count);
		this.number=number;
		this.price=price;
		init();
		
		cancel.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				dismiss();
			}});
		
		submit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				enterPayment();
				dismiss();
			}});
	}
	 
	private void init(){
		
		this.setContentView(mMenuView);
		// 设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(LayoutParams.FILL_PARENT);
		// 设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);
		// 设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(false);
		// 设置SelectPicPopupWindow弹出窗体动画效果
		this.setAnimationStyle(R.style.PopupAnimation);
		// 实例化一个ColorDrawable颜色为半透明
		ColorDrawable dw = new ColorDrawable(0xd0000000);
		// 设置SelectPicPopupWindow弹出窗体的背景
		this.setBackgroundDrawable(dw);
		// mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
//		mMenuView.setOnTouchListener(new OnTouchListener() {
//			public boolean onTouch(View v, MotionEvent event) {
//				int height = mMenuView.findViewById(R.id.pop_layout).getTop();
//				int y = (int) event.getY();
//				if (event.getAction() == MotionEvent.ACTION_UP) {
//					if (y < height) {
//						dismiss();
//					}
//				}
//				return true;
//			}
//		});
		payCount=price;
		numberText.setText(number);
		priceCount.setText("¥"+String.valueOf(price/100)+"元");
	}

	@Override
	public void onNumChange(View view, int num) {
		payCount=price*num;
		priceCount.setText("¥ "+String.valueOf(payCount/100)+"元");
	}
	
	private void enterPayment(){
		Intent intent=new Intent(context,ShoppingCartActivity.class);
		intent.putExtra("count", payCount/100);
		intent.putExtra("orderNumber", String.valueOf(System.currentTimeMillis()));
		intent.putExtra("title", "400电话下单");
		context.startActivity(intent);
	}
}