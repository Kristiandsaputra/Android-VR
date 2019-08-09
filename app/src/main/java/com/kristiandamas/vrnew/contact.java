package com.kristiandamas.vrnew;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class contact extends AppCompatActivity {
    TextView of,tlp,tlp2,jogja,kediri;
    Typeface tf1,tf2,tf3,tf4,tf5;
    Button ig,fb,be;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w =getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        of=(TextView)findViewById(R.id.of);
        stripUnderlines(of);
        tf1=Typeface.createFromAsset(getAssets(),"font/Botera-Regular.otf");
        of.setTypeface(tf1);

        tlp=(TextView)findViewById(R.id.tlp);
        stripUnderlines(tlp);
        tlp.setMovementMethod(LinkMovementMethod.getInstance());
        tf2=Typeface.createFromAsset(getAssets(),"font/Botera-Regular.otf");
        tlp.setTypeface(tf2);

        tlp2 =(TextView)findViewById(R.id.tlp2);
        stripUnderlines(tlp2);
        tlp2.setMovementMethod(LinkMovementMethod.getInstance());
        tf3=Typeface.createFromAsset(getAssets(),"font/Botera-Regular.otf");
        tlp2.setTypeface(tf3);

        jogja = (TextView)findViewById(R.id.jogja);
        stripUnderlines(jogja);
        jogja.setMovementMethod(LinkMovementMethod.getInstance());
        tf4=Typeface.createFromAsset(getAssets(),"font/Botera-Regular.otf");
        jogja.setTypeface(tf4);

        kediri = (TextView)findViewById(R.id.kediri);
        stripUnderlines(kediri);
        kediri.setMovementMethod(LinkMovementMethod.getInstance());
        tf5=Typeface.createFromAsset(getAssets(),"font/Botera-Regular.otf");
        kediri.setTypeface(tf5);
    }
    public void open4(View view) {
        Intent broswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/area55studio/"));
        startActivity(broswerIntent);
    }
    public void open5(View view) {
        Intent broswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/area55studio/"));
        startActivity(broswerIntent);
    }
    public void open6 (View view){
        Intent broswerInten = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.behance.net/area55visu09af"));
        startActivity(broswerInten);
    }
    private void stripUnderlines(TextView textView) {
        Spannable s = new SpannableString(textView.getText());
        URLSpan[] spans = s.getSpans(0, s.length(), URLSpan.class);
        for (URLSpan span: spans) {
            int start = s.getSpanStart(span);
            int end = s.getSpanEnd(span);
            s.removeSpan(span);
            span = new span(span.getURL());
            s.setSpan(span, start, end, 0);
        }
        textView.setText(s);
    }
}
