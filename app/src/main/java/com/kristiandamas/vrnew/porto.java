package com.kristiandamas.vrnew;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class porto extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.porto);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w =getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    public void open3 (View view){
        Intent broswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1Pjsfyxl7m1dHNc2VphWRdim2gyGIx2Dl"));
        startActivity(broswerIntent);
    }
    public void open7 (View view){
        Intent broswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://drive.google.com/open?id=1ObayNs-7KOFh2MQlA1vIS51BbCHs4CIl"));
        startActivity(broswerIntent);
    }
}

