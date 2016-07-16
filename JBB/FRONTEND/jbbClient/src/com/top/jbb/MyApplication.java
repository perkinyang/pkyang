package com.top.jbb;

import android.support.multidex.MultiDexApplication;

import com.umeng.socialize.PlatformConfig;

import cn.beecloud.BeeCloud;

public class MyApplication extends MultiDexApplication
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        initPay();
        initUmeng();
    }
    
    private void initPay(){
    	BeeCloud.setSandbox(false);
        BeeCloud.setAppIdAndSecret("8276ee16-71b9-4c9e-af18-ba2c24c35ad3", "9dfd580e-96d7-4b05-9213-6c9e0910b5f1");
    }

    private void initUmeng() {
        PlatformConfig.setWeixin("appId", "appKey");
        PlatformConfig.setQQZone("1105371002", "VGnzmTLzYeMuV1Ni");
        PlatformConfig.setSinaWeibo("1788256153", "ce2ddeeb94fea484e959513f980ab55b");
    }
}
