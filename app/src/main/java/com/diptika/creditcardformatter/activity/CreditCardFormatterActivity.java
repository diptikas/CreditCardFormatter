package com.diptika.creditcardformatter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.diptika.creditcardformatter.R;
import com.diptika.creditcardformatter.fragments.CreditCardFormatFragment;
import com.diptika.creditcardformatter.fragments.CreditCardNumberFragment;

public class CreditCardFormatterActivity extends AppCompatActivity {
    public CreditCardFormatFragment cardFormatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_formatter);

        cardFormatFragment=new CreditCardFormatFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container_card, cardFormatFragment).commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container_number, new CreditCardNumberFragment()).commit();


    }
}
