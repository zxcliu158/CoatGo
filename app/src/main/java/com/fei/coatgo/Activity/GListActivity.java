package com.fei.coatgo.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.fei.coatgo.Adapter.IndexGrdListAdapter;
import com.fei.coatgo.Entity.Goods;
import com.fei.coatgo.MYAPP;
import com.fei.coatgo.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GListActivity extends Activity {

    private GridView grd;
    private List<Goods> list = new ArrayList();
    private IndexGrdListAdapter adapter;

    private TextView tilte;
    private TextView choose;

    private TextView def;
    private TextView sales;
    private TextView price;
    private TextView newest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glist);
        init();
        SetEvent();
    }

    private void init() {
        grd = (GridView) findViewById(R.id.gls_grd);
        adapter = new IndexGrdListAdapter(this, list);
        grd.setAdapter(adapter);

        tilte = (TextView) findViewById(R.id.gls_tilte);
        choose = (TextView) findViewById(R.id.gls_choose);

        def = (TextView) findViewById(R.id.gls_def);
        sales = (TextView) findViewById(R.id.gls_sales);
        price = (TextView) findViewById(R.id.gls_price);
        newest = (TextView) findViewById(R.id.gls_newest);

    }

    //设置商品列表
    public void SetGrdList() {
        String[] d = null;
        try {
            d = MYAPP.context.getAssets().list("vpImg");
        } catch (IOException e) {

        }
        list.clear();
        for (int i = 0; i < d.length; i++) {
            Goods g = new Goods();
            g.setComplete("已售12件");
            g.setImgUrl("assets://vpImg/" + d[i]);
            g.setIsMail("包邮");
            g.setOprice("￥232");
            g.setPrice("￥122");
            g.setTilte("测试数据");
            list.add(g);
        }
        adapter.notifyDataSetChanged();

    }

    //设置事件
    private void SetEvent() {
        def.setOnClickListener(oncl);
        sales.setOnClickListener(oncl);
        price.setOnClickListener(oncl);
        newest.setOnClickListener(oncl);
    }

    //设置排行事件字体颜色
    private void Set() {
        def.setTextColor(getResources().getColor(R.color.black));
        sales.setTextColor(getResources().getColor(R.color.black));
        price.setTextColor(getResources().getColor(R.color.black));
        newest.setTextColor(getResources().getColor(R.color.black));
    }

    private View.OnClickListener oncl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Set();
            switch (v.getId()) {
                case R.id.gls_def:
                    Log.e("TGS","默认");
                    break;
                case R.id.gls_sales:
                    Log.e("TGS","销售");
                    break;
                case R.id.gls_price:
                    Log.e("TGS","价格");
                    break;
                case R.id.gls_newest:
                    Log.e("TGS","最新");
                    break;
            }
            ((TextView)v).setTextColor(getResources().getColor(R.color.host_on));
        }
    };

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        SetGrdList();
    }
}
