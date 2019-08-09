package com.kristiandamas.vrnew;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

public class vr4 extends AppCompatActivity {
    private VrPanoramaView panoWidgetView;
    private ImageLoaderTask backgroundImageLoaderTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vr4);
        Button lobby,pool,lift;
        Button back;

        back =(Button)findViewById(R.id.close);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        lobby = (Button)findViewById(R.id.lobby);
        lobby.getBackground().setAlpha(64);
        lobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(vr4.this, vr.class);
                startActivity(a);
            }
        });

        pool = (Button)findViewById(R.id.pool);
        pool.getBackground().setAlpha(64);
        pool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(vr4.this, vr2.class);
                startActivity(a);
            }
        });

        lift = (Button)findViewById(R.id.lift);
        lift.getBackground().setAlpha(64);
        lift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(vr4.this, vr3.class);
                startActivity(a);
            }
        });



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w =getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        panoWidgetView = (VrPanoramaView) findViewById(R.id.test_);
        LoadPanoImage();
    }
    private synchronized void LoadPanoImage(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()){
            task.cancel(true);
        }
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        String panoImageName = "bedrom.jpg";

        task = new ImageLoaderTask(panoWidgetView ,viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
}
