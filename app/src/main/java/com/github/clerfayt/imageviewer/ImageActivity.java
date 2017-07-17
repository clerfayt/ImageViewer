package com.github.clerfayt.imageviewer;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import com.github.clerfayt.imageviewer.utils.DecodeUtils;

import java.io.File;

public class ImageActivity extends Activity {

    private ImageViewTouch imageView;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        this.imageView = (ImageViewTouch)findViewById(R.id.imageView);

        Intent receivedIntent = getIntent();
        String receivedAction = receivedIntent.getAction();
        System.out.println(receivedAction);
        if(receivedAction.equals(Intent.ACTION_VIEW)) {
            Uri uri = receivedIntent.getData();

            final DisplayMetrics metrics = getResources().getDisplayMetrics();
            int size = (int) (Math.min(metrics.widthPixels, metrics.heightPixels) / 0.55);

            Bitmap bitmap = DecodeUtils.decode(this, uri, size, size);
            this.imageView.setImageBitmap(bitmap, null, -1, -1);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.imageView.setImageBitmap(null);
    }
}
