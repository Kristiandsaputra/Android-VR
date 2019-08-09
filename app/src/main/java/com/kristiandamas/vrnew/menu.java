package com.kristiandamas.vrnew;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

public class menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        final Button vr;
        final Button porto;
        Button cnt;
        final Button about;
        HorizontalScrollView scrollView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w =getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        vr = (Button)findViewById(R.id.vr);
        vr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menu.this,prev.class);
                startActivity(i);
            }
        });
        cnt = (Button)findViewById(R.id.cnt);
        cnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(menu.this,contact.class);
                startActivity(a);
            }
        });
        about =(Button)findViewById(R.id.us);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(menu.this,about.class);
                startActivity(a);
            }
        });
        porto =(Button)findViewById(R.id.porto);
        porto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(menu.this,porto.class);
                startActivity(a);
            }
        });
    }
    public void open(View view) {
        Intent broswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.area55studio.com/"));
        startActivity(broswerIntent);
    }
    public void open2(View view) {
        Intent broswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=T0dii5y8K-g&feature=youtu.be"));
        startActivity(broswerIntent);
    }

}
