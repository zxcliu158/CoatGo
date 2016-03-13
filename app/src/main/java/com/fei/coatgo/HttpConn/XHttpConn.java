package com.fei.coatgo.HttpConn;

import android.widget.ImageView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.x;

/**
 * Created by abcli on 2016/1/23.
 */
public class XHttpConn {
    private static XHttpConn conn = null;


    public void GetHtml(String url, final Myface.retHtml rt) {

        RequestParams params = new RequestParams(url);

        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String s) {
                rt.StrHtml(s);
            }

            @Override
            public void onError(Throwable throwable, boolean b) {

            }

            @Override
            public void onCancelled(CancelledException e) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    //绑定图片
    public void SetImg(final ImageView img, String url, ImageOptions options) {

        x.image().bind(img, url, options);
    }

    public static XHttpConn getInstance() {
        if (conn == null) {
            conn = new XHttpConn();
        }
        return conn;
    }

}
