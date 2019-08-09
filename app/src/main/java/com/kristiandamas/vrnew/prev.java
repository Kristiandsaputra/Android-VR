package com.kristiandamas.vrnew;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class prev extends AppCompatActivity {
    Button prev1;
    Button prev2,prev3,prev4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prev);

        prev2 = (Button)findViewById(R.id.prev2);
        prev1 = (Button)findViewById(R.id.prev1);
        prev3 = (Button)findViewById(R.id.prev3);
        prev4 =(Button)findViewById(R.id.prev4);

        prev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(prev.this,vr.class);
                startActivity(a);
            }
        });
        prev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(prev.this,vr2.class);
                startActivity(a);
            }
        });

        prev3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(prev.this,vr3.class);
                startActivity(a);
            }
        });

        prev4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(prev.this,vr4.class);
                startActivity(a);
            }
        });



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w =getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

    }
}

