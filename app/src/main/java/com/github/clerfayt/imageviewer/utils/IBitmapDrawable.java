package com.github.clerfayt.imageviewer.utils;

import android.graphics.Bitmap;

import com.github.clerfayt.imageviewer.ImageViewTouchBase;

/**
 * Base interface used in the {@link ImageViewTouchBase} view
 *
 * @author alessandro
 */
public interface IBitmapDrawable {
    Bitmap getBitmap();
}
