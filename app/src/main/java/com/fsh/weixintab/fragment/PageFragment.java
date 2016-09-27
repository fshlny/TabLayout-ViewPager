package com.fsh.weixintab.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fsh.weixintab.R;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class PageFragment extends Fragment {
    private String content;
    public PageFragment(){}


    public PageFragment(String content){
        this.content = content;
        Log.e(PageFragment.class.getName(),"初始化........................");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page,container,false);
        TextView tContent = (TextView) view.findViewById(R.id.content);
        tContent.setText(content);
        return view;
    }
}
