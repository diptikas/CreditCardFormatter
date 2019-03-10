package com.assignment.creditcardformatter.utils;

import android.text.TextUtils;

public class CreditCardUtils {
    public static final int NONE = 0;

    public static final int VISA = 1;
    public static final int MASTERCARD = 2;
    public static final int DINERS = 3;
    public static final int AMEX = 4;

    public static final String VISA_PREFIX = "4";
    public static final String MASTERCARD_PREFIX = "51,52,53,54,55,";
    public static final String DINERS_PREFIX = "30,36";
    public static final String AMEX_PREFIX = "34,37,";


    /**
     * Return Card Type according to given input card number
     * @param cardNumber
     * @return
     */
    public static int getCardType(String cardNumber) {

        if (cardNumber.substring(0, 1).equals(VISA_PREFIX))
            return VISA;
        else if (MASTERCARD_PREFIX.contains(cardNumber.substring(0, 2) + ","))
            return MASTERCARD;
        else if (AMEX_PREFIX.contains(cardNumber.substring(0, 2) + ","))
            return AMEX;
        else if (DINERS_PREFIX.contains(cardNumber.substring(0, 2) + ","))
            return DINERS;

        return NONE;
    }

}
