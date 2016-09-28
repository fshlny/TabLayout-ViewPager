package com.fsh.weixintab;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fsh.weixintab.adapter.SimpleFragmentPagerAdapter;
import com.fsh.weixintab.fragment.PageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] tabs;
    private int[] tabImgs = new int[]{R.drawable.tab_message,R.drawable.tab_address,
                                R.drawable.tab_friend,R.drawable.tab_setting};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = this.getResources().getStringArray(R.array.weixintab);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(),this,initFragment());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        for (int i=0;i<tabLayout.getTabCount();i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null){
                View customView = getTabView(i);
                if (customView != null)
                    tab.setCustomView(customView);
            }
        }

        tabLayout.getTabAt(0).getCustomView().setSelected(true);
    }

    private List<PageFragment> initFragment(){
        List<PageFragment> fragments = new ArrayList<>();
        for (int i=0;i<tabs.length;i++){
            fragments.add(new PageFragment(tabs[i]));
        }
        return fragments;
    }

    public View getTabView(int position) {
        if (position >= tabs.length) {
            return null;
        }
        View v = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) v.findViewById(R.id.tab_text);
        tv.setText(tabs[position]);
        ImageView img = (ImageView) v.findViewById(R.id.tab_image);
        img.setImageResource(tabImgs[position]);
        return v;
    }
}
