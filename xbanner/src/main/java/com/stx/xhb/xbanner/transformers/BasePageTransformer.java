package com.stx.xhb.xbanner.transformers;

import android.print.PrinterId;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by jxnk25 on 2016/10/18.
 *
 * link https://xiaohaibin.github.io/
 * email： xhb_199409@163.com
 * github: https://github.com/xiaohaibin
 * description：
 */
public abstract class BasePageTransformer implements ViewPager.PageTransformer {

    private final String LOG_TAG = "BasePageTransformer";
    @Override
    public void transformPage(View view, float position) {
        if (position < -1.0f) {
            //不可见
            Log.i(LOG_TAG, "handleInvisiblePage: "+view.toString()+" "+position);
            handleInvisiblePage(view, position);
        } else if (position <= 0.0f) {
            Log.i(LOG_TAG, "handleLeftPage: "+view.toString()+" "+position);
            handleLeftPage(view, position);
        } else if (position <= 1.0f) {
            Log.i(LOG_TAG, "handleRightPage: "+view.toString()+" "+position);
            handleRightPage(view, position);
        } else {
            Log.i(LOG_TAG, "handleInvisiblePage: "+view.toString()+" "+position);
            handleInvisiblePage(view, position);
        }
    }

    public abstract void handleInvisiblePage(View view, float position);

    public abstract void handleLeftPage(View view, float position);

    public abstract void handleRightPage(View view, float position);

    public static BasePageTransformer getPageTransformer(Transformer effect) {
        switch (effect) {
            case Default:
                return new DefaultPageTransformer();
            case Alpha:
                return new AlphaPageTransformer();
            case Rotate:
                return new RotatePageTransformer();
            case Cube:
                return new CubePageTransformer();
            case Flip:
                return new FlipPageTransformer();
            case Accordion:
                return new AccordionPageTransformer();
            case ZoomFade:
                return new ZoomFadePageTransformer();
            case ZoomCenter:
                return new ZoomCenterPageTransformer();
            case ZoomStack:
                return new ZoomStackPageTransformer();
            case Stack:
                return new StackPageTransformer();
            case Depth:
                return new DepthPageTransformer();
            case Zoom:
                return new ZoomPageTransformer();
            case Scale:
                return new ScalePageTransformer();
            default:
                return new DefaultPageTransformer();
        }
    }
}