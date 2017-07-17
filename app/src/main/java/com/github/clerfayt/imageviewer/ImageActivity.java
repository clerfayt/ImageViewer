package com.github.clerfayt.imageviewer;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.io.File;

public class ImageActivity extends Activity {

    private ImageView imageView;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        this.imageView = (ImageView)findViewById(R.id.imageView);

        Intent receivedIntent = getIntent();
        String receivedAction = receivedIntent.getAction();
        System.out.println(receivedAction);
        if(receivedAction.equals(Intent.ACTION_VIEW)) {
            String receivedType = receivedIntent.getType(); //"image/jpeg"
//            String filePath = receivedIntent.getData().getEncodedPath();
//            Uri uri = Uri.fromFile(new File(filePath));
//            if (filePath.startsWith("/external/images/media/"))
//                uri = Uri.fromFile(new File(getRealPathFromURI(getContentResolver(), uri)));
            Uri uri = receivedIntent.getData();
            this.imageView.setImageBitmap(null);
            this.imageView.setImageURI(uri);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.imageView.setImageBitmap(null);
    }

    //https://stackoverflow.com/questions/3401579/get-filename-and-path-from-uri-from-mediastore#3414749
    //does not work: curosr==null
    public String getRealPathFromURI(ContentResolver resolver, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = resolver.query(contentUri, proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

}
