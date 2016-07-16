package com.top.jbb.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.top.jbb.utils.DensityUtil;

public class TimeDismissDialog extends Dialog {
	private int FLAG_DISMISS = 1;
	private boolean flag = true;

	public TimeDismissDialog(Context context,String str) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		TextView btn = new TextView(context);
		btn.setText(str);
		LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		lp1.gravity=Gravity.CENTER_HORIZONTAL;
		int dp=DensityUtil.px2dip(context,150);
		btn.setTextSize(DensityUtil.px2dip(context,40));
		btn.setPadding(dp, dp, dp,dp);
		this.setContentView(btn);
	}

	@Override
	public void show() {
		super.show();
		mThread.start();
	}

	@Override
	public void dismiss() {
		super.dismiss();
		flag = false;
	}

	private Thread mThread = new Thread() {
		@Override
		public void run() {
			super.run();
			while (flag) {
				try {
					Thread.sleep(2000);
					Message msg = mHandler.obtainMessage();
					msg.what = FLAG_DISMISS;
					mHandler.sendMessage(msg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == FLAG_DISMISS)
				dismiss();
		}

	};

}
