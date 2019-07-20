package com.hsy.glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.hsy.glide.utils.GlideUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 自定义各种图片显示效果
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.cirview)
    ImageView cirview;
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.relativelayout)
    RelativeLayout relativelayout;
    @BindView(R.id.imgs)
    ImageView imgs;
    @BindView(R.id.imgs2)
    ImageView imgs2;
    @BindView(R.id.imgs3)
    ImageView imgs3;
    @BindView(R.id.btn_next)
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

    }


    public String url1 = "http://img5.imgtn.bdimg.com/it/u=3691544771,740678494&fm=23&gp=0.jpg";
    public String url2 = "http://a.hiphotos.baidu.com/image/h%3D200/sign=7f12fce71630e924d0a49b317c096e66/d52a2834349b033b23af1d351cce36d3d539bd3e.jpg";
    public String url3 = "http://www.5068.com/uploads/allimg/160401/1-160401145114-50.jpg";

    private void initView() {
        //高斯模糊
        GlideUtils.showImageViewBlur(this, R.mipmap.ic_launcher, url1, layout);
        //圆角
        GlideUtils.showImageViewToCircle(getApplication(), R.mipmap.ic_launcher, url2, cirview);
        //relaytiveLay
        GlideUtils.showImageView(this, R.mipmap.ic_launcher, url1, relativelayout);
        //一般图片，支持imageview，layout
        GlideUtils.showImageView(this, R.mipmap.ic_launcher, url2, img);
        //多种特效高斯模糊+圆角
        GlideUtils.showImageViewToCircleAndBlur(getApplication(), R.mipmap.ic_launcher, url2, imgs);
        //矩形圆角
        GlideUtils.showImageViewToCircle(getApplication(), R.mipmap.ic_launcher, url2, imgs2);
//        //遮罩
       //GlideUtils.showImageViewToMask(this, R.mipmap.ic_launcher, url2, imgs3);
    }


    @OnClick(R.id.btn_next)
    public void onViewClicked() {

     TwoActivity.launch(MainActivity.this);
    }
}
