package com.top.jbb.activity.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.top.jbb.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by tanghongliang on 16/4/30.
 */
public class ThirdLoginActivity extends Activity{

    private UMShareAPI mShareAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_login);

        TextView weixinLogo = (TextView)findViewById(R.id.weixin_logo);
        TextView weiboLogo = (TextView)findViewById(R.id.sina_weibo_logo);
        TextView qqLogo = (TextView)findViewById(R.id.qq_logo);

        mShareAPI = UMShareAPI.get(this);

        weixinLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShareAPI.doOauthVerify(getParent(),SHARE_MEDIA.WEIXIN,new UMAuthListener() {
                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        //完成先判断

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        System.out.println("fuck");
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }

                });
            }
        });

        weiboLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShareAPI.doOauthVerify(getParent(), SHARE_MEDIA.SINA,new UMAuthListener() {
                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        //完成先判断
                        System.out.println("fuck======");
                        Toast.makeText(getBaseContext(), "lovee", Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        System.out.println("=====fuck");
                        Toast.makeText(getBaseContext(),"fuck",Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                        Toast.makeText(getBaseContext(), "lllll", Toast.LENGTH_LONG);
                    }

                });
            }
        });

        qqLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShareAPI.doOauthVerify(getParent(), SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        //完成先判断
                        System.out.println("fuck");
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        System.out.println("fuck");
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }

                });
            }
        });
    }


    //第三方login
    public void thirdLogin(int userAccountType) {

    }
}
