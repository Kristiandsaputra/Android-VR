package com.kristiandamas.vrnew;

import android.text.TextPaint;
import android.text.style.URLSpan;

public class span extends URLSpan{
    public span(String url) {
        super(url);
    }
    @Override
    public void updateDrawState( TextPaint ds)
        {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }
}