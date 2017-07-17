package com.github.clerfayt.imageviewer;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;

public class ZoomImageView extends ImageView {

    private int zoomControler = 0;

    public ZoomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public ZoomImageView(Context context) {
        super(context);
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        if (zoomControler < 20) zoomControler = Math.min(getWidth()/2, getHeight()/2);
//        this.getDrawable().setBounds((getWidth()/2)-zoomControler, (getHeight()/2)-zoomControler, (getWidth()/2)+zoomControler, (getHeight()/2)+zoomControler);
//    }
//
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//        if(keyCode == KeyEvent.KEYCODE_DPAD_UP){ // zoom in
//            zoomControler += 10;
//        }
//        if(keyCode == KeyEvent.KEYCODE_DPAD_DOWN){ // zoom out
//            zoomControler -= 10;
//        }
//
//        invalidate();
//        return true;
//    }
}
