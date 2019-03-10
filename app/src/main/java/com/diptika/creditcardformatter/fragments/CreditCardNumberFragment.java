package com.diptika.creditcardformatter.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.diptika.creditcardformatter.R;
import com.diptika.creditcardformatter.activity.CreditCardFormatterActivity;
import com.diptika.creditcardformatter.utils.CreditCardEditText;
import com.diptika.creditcardformatter.utils.CreditCardFormattingTextWatcher;


public class CreditCardNumberFragment extends Fragment {
    private CreditCardEditText etNumber;
    private TextView tvNumber;
    private CreditCardFormatterActivity activity;
    private CreditCardFormatFragment cardFormatFragment;

    public CreditCardNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ccnumber, container, false);
        activity = (CreditCardFormatterActivity) getActivity();
        cardFormatFragment = activity.cardFormatFragment;

        tvNumber = cardFormatFragment.getNumber();
        etNumber = view.findViewById(R.id.et_number);

        etNumber.addTextChangedListener(new CreditCardFormattingTextWatcher(etNumber, tvNumber,
                cardFormatFragment.getCardType(),
                new CreditCardFormattingTextWatcher.CreditCardType() {
                    @Override
                    public void setCardType(int type) {
                        Log.d("Card", "setCardType: " + type);
                        cardFormatFragment.setCardType(type);
                    }
                }));

        etNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if (activity != null) {
                        hideSoftKeyboard();
                        activity.onBackPressed();
                        return true;
                    }

                }
                return false;
            }
        });

        etNumber.setOnBackButtonListener(new CreditCardEditText.BackButtonListener() {
            @Override
            public void onBackClick() {
                if (activity != null)
                    hideSoftKeyboard();
            }
        });

        return view;
    }

    private void hideSoftKeyboard() {
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

}

