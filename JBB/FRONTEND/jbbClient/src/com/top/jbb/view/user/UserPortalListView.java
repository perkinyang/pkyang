package com.top.jbb.view.user;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by tanghongliang on 16/4/14.
 */
public class UserPortalListView extends ListView implements AbsListView.OnScrollListener {



    public UserPortalListView(Context context) {
        super(context);
    }

    public UserPortalListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UserPortalListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
