package com.fei.coatgo.Activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import com.fei.coatgo.Fragment.IndexClass;
import com.fei.coatgo.Fragment.MyClass;
import com.fei.coatgo.Fragment.SortedClass;
import com.fei.coatgo.MYAPP;
import com.fei.coatgo.R;

public class MainActivity extends FragmentActivity {

    private IndexClass index = null;
    private SortedClass sortedClass=null;
    private MyClass my=null;

    private FragmentManager fm;
    private RadioGroup host_radg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        index=new IndexClass();
        fm.beginTransaction().replace(R.id.main_frm,index).commit();

        host_radg=(RadioGroup)findViewById(R.id.view_host_rdg);
        host_radg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.view_host_rdg_rd1:
                        if (index == null) {
                            index = new IndexClass();
                        }
                        SetShow(group,index);
                        break;
                    case R.id.view_host_rdg_rd2:
                        if (sortedClass == null) {
                            sortedClass = new SortedClass();
                        }
                        SetShow(group,sortedClass);
                        break;
                    case R.id.view_host_rdg_rd3:
                        if (my == null) {
                            my = new MyClass();
                        }
                        SetShow(group,my);
                        break;
                }
            }
        });

        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
       // float density1 = dm.density;
       // int width3 = dm.widthPixels;
       // int height3 = dm.heightPixels;
        MYAPP.X=dm.widthPixels;
        MYAPP.Y=dm.heightPixels;

    }



    private void SetShow(View v, Fragment fragment) {
        Log.e("TGH",fragment.getUserVisibleHint()+"");
//        int[] location = new int[2];
//        v.getLocationOnScreen(location);
//        int x = location[0];
//        int y = location[1];

//        View view = findViewById(R.id.main_frm);
//        int finalRadius = Math.max(view.getWidth(), view.getHeight());
//        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(
//                view, 0, 0, 0, finalRadius);
//        animator.setInterpolator(new AccelerateInterpolator());
//        animator.setDuration(2000);
        fm.beginTransaction().replace(R.id.main_frm, fragment).commit();

        Log.e("TGH", fragment.getUserVisibleHint() + "  END");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

    }
}
