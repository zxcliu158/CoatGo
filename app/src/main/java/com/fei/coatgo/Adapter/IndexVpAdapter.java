package com.fei.coatgo.Adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by abcli on 2016/1/22.
 */
public class IndexVpAdapter extends PagerAdapter {

    private List<ImageView> list;

    public  IndexVpAdapter(List<ImageView> list){
        Log.e("TGS","Index vpPager:"+list.size());

        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView(list.get(position));
    }
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager)container).addView(list.get(position));

        return list.get(position);
    }
}
