package com.kristiandamas.vrnew;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

public class vr2 extends AppCompatActivity {
    Button lobby,lift,bed;
    Button back;
    private VrPanoramaView panoWidgetView;
    private ImageLoaderTask backgroundImageLoaderTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vr2);
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
                Intent a = new Intent(vr2.this, vr.class);
                startActivity(a);
            }
        });

        lift = (Button)findViewById(R.id.lift);
        lift.getBackground().setAlpha(64);
        lift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(vr2.this, vr3.class);
                startActivity(a);
            }
        });

        bed = (Button)findViewById(R.id.bed);
        bed.getBackground().setAlpha(64);
        bed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(vr2.this, vr4.class);
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

        String panoImageName = "pool.jpg";

        task = new ImageLoaderTask(panoWidgetView ,viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
}