package com.top.jbb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.top.jbb.R;
import com.top.jbb.data.UserMenu;

import java.util.List;

/**
 * Created by tanghongliang on 16/4/17.
 */
public class UserMenuListAdapter extends BaseAdapter {

    private List<UserMenu> userMenuList;

    private Context context;

    public UserMenuListAdapter(Context context,List<UserMenu> userMenuList) {
        super();
        this.context = context;
        this.userMenuList = userMenuList;
    }

    @Override
    public int getCount() {
        return userMenuList.size();
    }

    @Override
    public Object getItem(int position) {
        return userMenuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item_user_menu, parent, false);
        holder.menuIcon = (ImageView) convertView.findViewById(R.id.menu_icon);
        holder.menuText = (TextView) convertView.findViewById(R.id.menu_title);
        UserMenu userMenu = (UserMenu)getItem(position);
        holder.menuIcon.setImageResource(userMenu.getIcon());
        holder.menuText.setText(userMenu.getText());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),String.valueOf(position),Toast.LENGTH_LONG);
            }
        });
        return convertView;
    }
}


class ViewHolder{
    ImageView menuIcon;
    TextView menuText;
}
