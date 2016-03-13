package com.fei.coatgo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fei.coatgo.Entity.Goods;
import com.fei.coatgo.HttpConn.XHttpConn;
import com.fei.coatgo.MYAPP;
import com.fei.coatgo.R;

import org.xutils.image.ImageOptions;

import java.util.List;

/**
 * Created by abcli on 2016/1/23.
 */
public class IndexGrdListAdapter extends BaseAdapter {

    private Context context;
    private List<Goods> list;

    public IndexGrdListAdapter(Context context, List<Goods> list) {
        this.context = context;
        this.list = list;
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
        How how = null;
        if (convertView == null) {
            how = new How();
            convertView = LayoutInflater.from(context).inflate(R.layout.view_item_grd_list, null);
            how.complete=(TextView)convertView.findViewById(R.id.item_grd_lis_complete);
            how.img=(ImageView)convertView.findViewById(R.id.item_grd_lis_img);
            how.isMail=(TextView)convertView.findViewById(R.id.item_grd_lis_mail);
            how.price=(TextView)convertView.findViewById(R.id.item_grd_lis_price);
            how.oprice=(TextView)convertView.findViewById(R.id.item_grd_lis_oprice);
            how.tilte=(TextView)convertView.findViewById(R.id.item_grd_lis_tilte);
            convertView.setTag(how);
        } else {
            how=(How)convertView.getTag();
        }
        Goods g=list.get(position);

        how.tilte.setText(g.getTilte());
        how.oprice.setText(g.getOprice());
        how.isMail.setText(g.getIsMail());
        how.complete.setText(g.getComplete());
        how.price.setText(g.getPrice());
        XHttpConn.getInstance().SetImg(how.img,g.getImgUrl(),options);

        return convertView;
    }
    ImageOptions options=new ImageOptions.Builder()
            .setSize(MYAPP.X/2, MYAPP.X/2)
           // .setSize(MYAPP.X, DensityUtil.dip2px(200)) // 图片大小
                    // .setRadius(DensityUtil.dip2px(5))//ImageView圆角半径
            .setCrop(true)// 如果ImageView的大小不是定义为wrap_content, 不要crop.
            .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
            .setLoadingDrawableId(R.mipmap.iconfont_jiazai)//加载中默认显示图片
            .setFailureDrawableId(R.mipmap.iconfont_jiazaishibai)//加载失败后默认显示图片
            .build();

    class How {
        public ImageView img;
        public TextView tilte, price, oprice, complete, isMail;
    }
}
