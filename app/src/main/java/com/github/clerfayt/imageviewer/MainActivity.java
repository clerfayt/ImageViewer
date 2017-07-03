package com.github.clerfayt.imageviewer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText path = (EditText)findViewById(R.id.filepath);
        Button b = (Button)findViewById(R.id.showbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filePath = path.getText().toString();
                Intent i = new Intent(getApplicationContext(), ImageActivity.class);
                i.setAction(Intent.ACTION_VIEW);
                File file = new File(filePath);
                Uri data = Uri.fromFile(file);
                i.setData(data);
                startActivity(i);
            }
        });

    }
}
