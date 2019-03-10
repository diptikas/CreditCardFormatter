package com.diptika.creditcardformatter.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.diptika.creditcardformatter.R;

import static com.diptika.creditcardformatter.utils.CreditCardUtils.AMEX;
import static com.diptika.creditcardformatter.utils.CreditCardUtils.DINERS;
import static com.diptika.creditcardformatter.utils.CreditCardUtils.MASTERCARD;
import static com.diptika.creditcardformatter.utils.CreditCardUtils.NONE;
import static com.diptika.creditcardformatter.utils.CreditCardUtils.VISA;


public class CreditCardFormatFragment extends Fragment {
    private TextView tvNumber;
    private TextView tvName;
    private TextView tvInvalidCard;
    private ImageView ivType;


    public CreditCardFormatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_card_format, container, false);
        tvNumber = view.findViewById(R.id.tv_card_number);
        tvName = view.findViewById(R.id.tv_member_name);
        tvInvalidCard= view.findViewById(R.id.tv_error);
        ivType = view.findViewById(R.id.iv_type);
        return view;
    }

    public TextView getNumber() {
        return tvNumber;
    }

    public TextView getName() {
        return tvName;
    }

    public ImageView getCardType() {
        return ivType;
    }

    /**
     * Set Drawable based on card type
     * @param type
     */
    public void setCardType(int type) {
        switch (type) {
            case VISA:
                ivType.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_visa));
                break;
            case MASTERCARD:
                ivType.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_mastercard));
                break;
            case AMEX:
                ivType.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_amex));
                break;
            case DINERS:
                ivType.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_diners));
                break;
            case NONE:
                ivType.setImageResource(android.R.color.transparent);
                tvInvalidCard.setVisibility(View.VISIBLE);
                break;

        }
    }
}

