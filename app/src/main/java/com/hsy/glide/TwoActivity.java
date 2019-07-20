package com.hsy.glide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.hsy.glide.utils.GlideUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by luo on 2019/7/19.
 * <p>
 * 采用依赖包的封装
 */

public class TwoActivity extends Activity {


    @BindView(R.id.cirview)
    ImageView cirview;
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.relativelayout)
    RelativeLayout relativelayout;
    @BindView(R.id.imgs)
    ImageView imgs;
    @BindView(R.id.imgs2)
    ImageView imgs2;
    @BindView(R.id.imgs3)
    ImageView imgs3;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.activity_image)
    ScrollView activityImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);

        initView();

    }


    public String url1 = "http://img5.imgtn.bdimg.com/it/u=3691544771,740678494&fm=23&gp=0.jpg";
    public String url2 = "http://a.hiphotos.baidu.com/image/h%3D200/sign=7f12fce71630e924d0a49b317c096e66/d52a2834349b033b23af1d351cce36d3d539bd3e.jpg";
    public String url3 = "http://www.5068.com/uploads/allimg/160401/1-160401145114-50.jpg";

    private void initView() {
        //高斯模糊
        GlideLibUtils.showLinearLayoutBlurBg(this, R.mipmap.ic_launcher, url1, layout);
        //圆角
        GlideLibUtils.showCircle(getApplication(), R.mipmap.ic_launcher, url2, cirview);
        //relaytiveLay
        GlideLibUtils.showRelativeLayoutBg(this, R.mipmap.ic_launcher, url1, relativelayout);
        //一般图片，支持imageview，layout
        GlideLibUtils.showImage(this, R.mipmap.ic_launcher, url2, img);
        //多种特效高斯模糊+圆角
        GlideLibUtils.showCircleAndBlur(getApplication(), R.mipmap.ic_launcher, url2, imgs);
        //矩形圆角
        GlideLibUtils.showCircle(getApplication(), R.mipmap.ic_launcher, url2, imgs2);
//
    }


    public static void launch(Context mContext) {

        Intent intent = new Intent(mContext,TwoActivity.class);
        mContext.startActivity(intent);
    }
}
