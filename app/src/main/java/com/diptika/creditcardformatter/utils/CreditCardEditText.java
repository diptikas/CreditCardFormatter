package com.diptika.creditcardformatter.utils;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;

public class CreditCardEditText extends AppCompatEditText {
    public Context context;
    private BackButtonListener backButtonListener;

    public CreditCardEditText(Context context) {
        super(context);
        this.context = context;
    }

    public CreditCardEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CreditCardEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void setOnBackButtonListener(BackButtonListener listener) {
        backButtonListener = listener;
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
            Log.d("ET", "onKeyPreIme: ");
            if (backButtonListener != null)
                backButtonListener.onBackClick();
            return true;
        }
        return false;
    }

    public interface BackButtonListener {
        void onBackClick();
    }
}
