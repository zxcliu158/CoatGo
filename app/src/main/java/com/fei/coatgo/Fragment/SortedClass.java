package com.fei.coatgo.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.fei.coatgo.Activity.GListActivity;
import com.fei.coatgo.Activity.SearchActivity;
import com.fei.coatgo.Adapter.IndexGrdAdapter;
import com.fei.coatgo.Entity.Classify;
import com.fei.coatgo.MYAPP;
import com.fei.coatgo.R;

import java.util.ArrayList;
import java.util.List;


public class SortedClass extends Fragment {
    private Context context;
    private  View view;
    private GridView gridView;
    private TextView sosou;
    private IndexGrdAdapter grdAdapter;
    private List<Classify>list=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.frm_class,container,false);
        sosou=(TextView)view.findViewById(R.id.frm_class_sousou);
        gridView=(GridView)view.findViewById(R.id.frm_class_grd);
        grdAdapter=new IndexGrdAdapter(getActivity(),list, MYAPP.X/3,MYAPP.X/3);
        gridView.setAdapter(grdAdapter);
        Log.e("TGS","SortedClass -onCreateView:");
        SetEvent();
        return view;
    }

    public void SetGrd(){
        String [] cl=MYAPP.context.getResources().getStringArray(R.array.ClassifyQ);
        int[] clImg=new int[]{
                R.mipmap.fushi, R.mipmap.nanzhuang, R.mipmap.xiangbao,
                R.mipmap.nvxie, R.mipmap.nieyi, R.mipmap.huazhuangpin,
                R.mipmap.peishi,R.mipmap.oldman,R.mipmap.muying,
                R.mipmap.jujia,R.mipmap.meishi,R.mipmap.shuma,
                R.mipmap.wenti, R.mipmap.jkj, R.mipmap.newsort
        };
        for(int i=0;i<clImg.length;i++){
            Classify c=new Classify(cl[i],i+"",clImg[i]);
            list.add(c);
        }

    }
   public SortedClass(){
       SetGrd();
    }

    public void SetEvent(){

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), GListActivity.class);
                getActivity().startActivity(intent);

            }
        });

        sosou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SearchActivity.class);
                getActivity().startActivity(intent);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        grdAdapter.notifyDataSetChanged();
    }
}
