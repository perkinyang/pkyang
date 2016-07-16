package com.top.jbb.fragment.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.top.jbb.R;
import com.top.jbb.activity.user.UserDetailActivity;
import com.top.jbb.adapter.UserMenuListAdapter;
import com.top.jbb.data.UserMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanghongliang on 16/4/12.
 */
public class UserPortalFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View userPortalView = inflater.inflate(R.layout.fragment_user_portal,null);
        initListView(userPortalView);
        ImageView userIconView = (ImageView)userPortalView.findViewById(R.id.user_icon);
        userIconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(),UserDetailActivity.class);
                startActivity(intent);
            }
        });
        return userPortalView;
    }

    private void initListView(View userPortalView) {
        ListView userMenuListView = (ListView)userPortalView.findViewById(R.id.user_menu_list_view);
        List<UserMenu> userMenuList = initUserMenuList();
        userMenuListView.setAdapter(new UserMenuListAdapter(userPortalView.getContext(),userMenuList));
    }

    private List<UserMenu> initUserMenuList() {

        List<UserMenu> userMenuList = new ArrayList<UserMenu>();

        UserMenu orderMenu = new UserMenu(R.drawable.icon_order,"我的订单");

        UserMenu walletMenu = new UserMenu(R.drawable.icon_wallet,"我的钱包");

        UserMenu couponMenu = new UserMenu(R.drawable.icon_coupon,"优惠券");

        UserMenu partnerMenu = new UserMenu(R.drawable.icon_partner,"合伙人");

        UserMenu settingMenu = new UserMenu(R.drawable.icon_setting,"设置");

        UserMenu feedbackMenu = new UserMenu(R.drawable.icon_feedback,"建议与反馈");

        userMenuList.add(orderMenu);
        userMenuList.add(walletMenu);
        userMenuList.add(couponMenu);
        userMenuList.add(partnerMenu);
        userMenuList.add(settingMenu);
        userMenuList.add(feedbackMenu);

        return userMenuList;
    }


}
