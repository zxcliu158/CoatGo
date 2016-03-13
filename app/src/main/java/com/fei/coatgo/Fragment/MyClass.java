package com.fei.coatgo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fei.coatgo.MYAPP;
import com.fei.coatgo.R;

/**
 * Created by abcli on 2016/1/25.
 */
public class MyClass extends Fragment {

    private View view;
    private LinearLayout order;
    private LinearLayout logistics;
    private LinearLayout cart;
    private LinearLayout setting;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frm_my, container, false);
        order=(LinearLayout)view.findViewById(R.id.frm_my_order);
        logistics=(LinearLayout)view.findViewById(R.id.frm_my_logistics);
        cart=(LinearLayout)view.findViewById(R.id.frm_my_cart);
        setting=(LinearLayout)view.findViewById(R.id.frm_my_setting);
        SetLin(order,im[0],nn[0]);
        SetLin(logistics,im[1],nn[1]);
        SetLin(cart,im[2],nn[2]);
        SetLin(setting,im[3],nn[3]);
        return view;
    }

    public void SetLin(LinearLayout lin,int id,String str){
        ImageView img;
        TextView name;
        img=(ImageView)lin.findViewById(R.id.item_img_tx_img);
        name=(TextView)lin.findViewById(R.id.item_img_tx_tx);
        img.setImageResource(id);
        name.setText(str);

    }
    String nn[]=new String[]{};
    int[] im=new int[]{R.mipmap.usericon_order,R.mipmap.usericon_address,
            R.mipmap.usericon_shoppingcart,R.mipmap.usericon_setup,};

   public MyClass(){
       nn= MYAPP.context.getResources().getStringArray(R.array.my_ar);
    }
}
