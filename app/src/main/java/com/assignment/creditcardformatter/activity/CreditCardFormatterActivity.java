package com.assignment.creditcardformatter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.assignment.creditcardformatter.R;
import com.assignment.creditcardformatter.fragments.CreditCardFormatFragment;
import com.assignment.creditcardformatter.fragments.CreditCardNumberFragment;

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
