package com.top.jbb.utils;

import android.content.Context;
import android.widget.Toast;

public class TipTools {

	public static void tips(Context mContext,String tipStr){
		Toast.makeText(mContext, tipStr, Toast.LENGTH_LONG).show();
	}

}
