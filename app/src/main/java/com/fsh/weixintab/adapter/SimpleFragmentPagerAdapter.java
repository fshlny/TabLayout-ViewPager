package com.fsh.weixintab.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fsh.weixintab.fragment.PageFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private List<PageFragment> mFragments;
    public SimpleFragmentPagerAdapter(FragmentManager fm,Context context,List<PageFragment> fragments) {
        super(fm);
        this.mContext = context;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
