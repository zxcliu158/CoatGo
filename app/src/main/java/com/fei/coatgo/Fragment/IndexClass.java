package com.fei.coatgo.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.fei.coatgo.Activity.GListActivity;
import com.fei.coatgo.Activity.InfoActivity;
import com.fei.coatgo.Activity.SearchActivity;
import com.fei.coatgo.Adapter.IndexGrdAdapter;
import com.fei.coatgo.Adapter.IndexGrdListAdapter;
import com.fei.coatgo.Adapter.IndexVpAdapter;
import com.fei.coatgo.Entity.Classify;
import com.fei.coatgo.Entity.Goods;
import com.fei.coatgo.HttpConn.XHttpConn;
import com.fei.coatgo.MYAPP;
import com.fei.coatgo.R;
import com.fei.mylibrary.Code.View.OGridView;
import com.fei.mylibrary.Code.VpAnimation.AccordionTransformer;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abcli on 2016/1/21.
 */
public class IndexClass extends Fragment {

    private Context context;
    private ImageView sousou;

    private View view;
    private List<Classify> classifyList = new ArrayList<>();

    private OGridView grd;
    private IndexGrdAdapter adapterGrd;

    private List<ImageView> vpList = new ArrayList<ImageView>();
    private ViewPager viewPager;
    private IndexVpAdapter vpAdapter;

    private OGridView grdList;
    private IndexGrdListAdapter grdListAdapter;
    private List<Goods> grdlistlist = new ArrayList<Goods>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.frm_index, container, false);
        adapterGrd = new IndexGrdAdapter(getActivity(), classifyList);
        grd = (OGridView) view.findViewById(R.id.frm_index_grd);
        viewPager = (ViewPager) view.findViewById(R.id.frm_index_vp);
        grdList = (OGridView) view.findViewById(R.id.frm_index_grdlist);

        vpAdapter = new IndexVpAdapter(vpList);
        viewPager.setAdapter(vpAdapter);
        viewPager.setPageTransformer(true, new AccordionTransformer());
        adapterGrd = new IndexGrdAdapter(getActivity(), classifyList);
        grd.setAdapter(adapterGrd);

        grdListAdapter = new IndexGrdListAdapter(getActivity(), grdlistlist);
        grdList.setAdapter(grdListAdapter);

        sousou=(ImageView)view.findViewById(R.id.frm_index_sousuo);

        SetEvent();

        return view;
    }


    public void SetIndexClass() {
        Log.e("TGS", "DASA");

        String[] name = MYAPP.context.getResources().getStringArray(R.array.Classify);

        int[] img = new int[]{R.mipmap.ic_m_nvzhuang, R.mipmap.ic_m_shoes,
                R.mipmap.ic_m_neiyi, R.mipmap.ic_m_miezhuang,
                R.mipmap.ic_m_nanzhuang, R.mipmap.ic_m_bag,
                R.mipmap.ic_m_new, R.mipmap.ic_m_all};

        for (int i = 0; i < name.length; i++) {
            classifyList.add(new Classify(name[i], String.valueOf(i), img[i]));
        }

    }

    String[] d = null;

    //
    //设置Vp
    public void SetVp() {
        try {
            d = MYAPP.context.getAssets().list("vpImg");
        } catch (IOException e) {

        }
        ImageOptions options = new ImageOptions.Builder()
                .setSize(MYAPP.X, DensityUtil.dip2px(200)) // 图片大小
                        // .setRadius(DensityUtil.dip2px(5))//ImageView圆角半径
                        // .setCrop(true)// 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setLoadingDrawableId(R.mipmap.iconfont_jiazai)//加载中默认显示图片
                .setFailureDrawableId(R.mipmap.iconfont_jiazaishibai)//加载失败后默认显示图片
                .build();

        for (int i = 0; i < d.length; i++) {
            ImageView img = new ImageView(MYAPP.context);
            XHttpConn.getInstance().SetImg(img, "assets://vpImg/" + d[i], options);
            vpList.add(img);
        }
        Log.e("TGs", "Vplist:" + vpList.size() + "   //:d:" + d.length);
        SetGrdList();
    }

    //设置商品列表
    public void SetGrdList() {
        for (int i = 0; i < d.length; i++) {
            Goods g = new Goods();
            g.setComplete("已售12件");
            g.setImgUrl("assets://vpImg/" + d[i]);
            g.setIsMail("包邮");
            g.setOprice("￥232");
            g.setPrice("￥122");
            g.setTilte("测试数据");
            grdlistlist.add(g);
        }


    }

    public IndexClass() {
        SetVp();
        SetIndexClass();
    }

    public void SetEvent(){
        grdList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),InfoActivity.class);
                getActivity().startActivity(intent);
            }
        });
        grd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), GListActivity.class);
                getActivity().startActivity(intent);
            }
        });
        sousou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                getActivity().startActivity(intent);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        adapterGrd.notifyDataSetChanged();
        vpAdapter.notifyDataSetChanged();

}
}
