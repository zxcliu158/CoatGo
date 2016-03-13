package com.fei.coatgo.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fei.coatgo.Entity.Classify;
import com.fei.coatgo.MYAPP;
import com.fei.coatgo.R;

import java.util.List;


public class IndexGrdAdapter extends BaseAdapter {
    private Context context;
    private List<Classify> list;
    private AbsListView.LayoutParams params;

    public IndexGrdAdapter(Context context, List<Classify> list) {
        this.context = context;
        this.list = list;
        params = new AbsListView.LayoutParams(MYAPP.X / 4, MYAPP.X / 4);
    }

    public IndexGrdAdapter(Context context, List<Classify> list, int h, int w) {
        this.context = context;
        this.list = list;
        params = new AbsListView.LayoutParams(h,w);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        How h = null;
        if (convertView == null) {
            h = new How();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_img_tx, null);
            h.img = (ImageView) convertView.findViewById(R.id.item_img_tx_img);
            h.tx = (TextView) convertView.findViewById(R.id.item_img_tx_tx);
            convertView.setTag(h);
        } else {
            h = (How) convertView.getTag();
        }
        Classify cl = list.get(position);
        h.tx.setText(cl.getC_name());
        h.img.setImageResource(cl.getImg_rid());

        convertView.setLayoutParams(params);

        Log.e("TGS", "GRD:" + cl.getC_name() + "  MYAPP.X" + MYAPP.X);
        return convertView;
    }

    class How {
        public ImageView img;
        public TextView tx;
    }
}
