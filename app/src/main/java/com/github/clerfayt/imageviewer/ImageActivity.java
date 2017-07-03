package com.github.clerfayt.imageviewer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
        if(receivedAction.equals(Intent.ACTION_VIEW)) {
            String receivedType = receivedIntent.getType();
            if(receivedType.startsWith("image/")) {
                // WHEN USING ACTION_SEND:
//                Uri receivedUri = (Uri)receivedIntent.getParcelableExtra(Intent.EXTRA_STREAM);
//                if (receivedUri != null) {
//                    //TODO RESAMPLE YOUR IMAGE DATA BEFORE DISPLAYING
//                    this.imageView.setImageURI(receivedUri);
//                }
                String filePath = receivedIntent.getData().getEncodedPath();
                File file = new File(filePath);
                Uri uri = Uri.fromFile(file);
                this.imageView.setImageURI(uri);
            }
        }
    }
}
