package com.hsy.glide;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by luo on 2019/7/19.
 * 这些都是采用 jar 包别人封装的工具类
 */

public class GlideLibUtils {


    /**
     * 实现高斯模糊
     * @param context
     * @param errorimg
     * @param url
     * @param imgeview
     */
    public static void showImageBlur(Application context, int errorimg,
                                                    String url, ImageView imgeview) {
        //radius取值1-25,值越大图片越模糊
        Glide.with(context)
                .load(url)
                .error(errorimg)
                .bitmapTransform(new BlurTransformation(context, 15))
                .into(imgeview);
    }


    /**
     * LinearLayout 显示背景的高斯模糊
     * @param context
     * @param errorimg
     * @param url
     * @param bgLayout
     */
    public static void showLinearLayoutBlurBg(Context context, int errorimg,
                                         String url, final LinearLayout bgLayout) {
        Glide.with(context).load(url).asBitmap().error(errorimg)
                // 设置错误图片

                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                // 缓存修改过的图片
                .placeholder(errorimg)
                // 高斯模糊处理
                .transform(new BlurTransformation(context))
                // 设置占位图
                .into(new SimpleTarget<Bitmap>() {

                    @SuppressLint("NewApi")
                    @Override
                    public void onResourceReady(Bitmap loadedImage,
                                                GlideAnimation<? super Bitmap> arg1) {
                        BitmapDrawable bd = new BitmapDrawable(loadedImage);

                        bgLayout.setBackground(bd);

                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        // TODO Auto-generated method stub
                        super.onLoadFailed(e, errorDrawable);

                        bgLayout.setBackgroundDrawable(errorDrawable);
                    }

                });

    }

    /**
     * RelativeLayout 显示背景
     * @param context
     * @param errorimg
     * @param url
     * @param bgLayout
     */

    public static void showRelativeLayoutBg(Context context, int errorimg, String url,
                                     final RelativeLayout bgLayout) {
        // 设置错误图片
        Glide.with(context).load(url).asBitmap().error(errorimg)
                // 缓存修改过的图片
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                // 设置占位图
                .placeholder(errorimg)
                .into(new SimpleTarget<Bitmap>() {

                    @SuppressLint("NewApi")
                    @Override
                    public void onResourceReady(Bitmap loadedImage,
                                                GlideAnimation<? super Bitmap> arg1) {
                        BitmapDrawable bd = new BitmapDrawable(loadedImage);

                        bgLayout.setBackground(bd);

                    }

                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        // TODO Auto-generated method stub
                        super.onLoadFailed(e, errorDrawable);

                        bgLayout.setBackgroundDrawable(errorDrawable);
                    }

                });

    }

    /**
     * 显示原图
     * @param context
     * @param errorimg
     * @param url
     * @param imgeview
     */
    public static void showImage(Context context, int errorimg,
                                           String url, ImageView imgeview) {
        Glide.with(context)
                .load(url)
                .error(errorimg)
                .into(imgeview);
    }



    /**
     * 原图基础上变换设置圆形图
     * @param context
     * @param errorimg
     * @param url
     * @param imgeview
     */
    public static void showCircle(Application context, int errorimg,
                                                    String url, ImageView imgeview) {
        Glide.with(context)
                .load(url)
                .error(errorimg)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(imgeview);
    }





    /**
     *
     * 多种样式（模糊+圆角） ImageView
     *原图基础上变换成圆图 +毛玻璃（高斯模糊）
     * @param context  上下文
     * @param errorimg 错误的资源图片
     * @param url      图片链接
     * @param imgeview 组件
     */
    public static void showCircleAndBlur(Application context, int errorimg,
                                                    String url, ImageView imgeview) {
        Glide.with(context).load(url)
                // 设置错误图片
                .error(errorimg)
                // 设置高斯模糊，圆角
                .bitmapTransform(new BlurTransformation(context, 15), new CropCircleTransformation(context))
                // 缓存修改过的图片
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imgeview);
    }

    /**
     * 原图处理成矩形圆角
     *  ImageView
     * @param context  上下文
     * @param errorimg 错误的资源图片
     * @param url      图片链接
     * @param imgeview 组件
     */
    public static void showRoundedCorners(Application context, int errorimg,
                                                     String url, ImageView imgeview) {
        Glide.with(context).load(url)
                // 设置错误图片
                .error(errorimg)
                // 设置矩形圆角
                .bitmapTransform(new RoundedCornersTransformation(context, 30, 0,
                        RoundedCornersTransformation.CornerType.ALL))
                // 缓存修改过的图片
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(imgeview);
    }


}
