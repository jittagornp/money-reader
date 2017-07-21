/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.commons.moneyreader;

import java.math.BigInteger;

/**
 * @author jittagornp <http://jittagornp.me>
 * create : 2017/07/21
 */
public abstract class AbstractThaiBlockReader {

    private final String NUMBER[] = {"ศูนย์", "หนึ่ง", "สอง", "สาม", "สี่", "ห้า", "หก", "เจ็ด", "แปด", "เก้า"};
    private final String LEVEL[] = {"", "สิบ", "ร้อย", "พัน", "หมื่น", "แสน"};

    protected abstract String asString(KeyPair keyPair);

    protected abstract BigInteger getBaseValue();

    protected String getNumberText(int number) {
        return NUMBER[number];
    }

    protected String getLevelText(int level) {
        return LEVEL[level];
    }

    //A * 10^x
    private BigInteger getLatestValue(KeyPair keyPair) {
        return BigInteger.valueOf(keyPair.getNumber())
                .multiply(getBaseValue().pow(keyPair.getLevel()));
    }

    private boolean isMoreThanZero(BigInteger number) {
        return number.compareTo(BigInteger.ZERO) > 0;
    }

    private boolean isLessThanTen(BigInteger number) {
        return number.compareTo(BigInteger.TEN) < 0;
    }

    public String read(BigInteger number) {
        if (isLessThanTen(number)) {
            return getNumberText(number.intValue());
        }

        StringBuilder result = new StringBuilder();
        do {
            KeyPair keyPair = map(number);
            result.append(asString(keyPair));
            number = number.mod(getLatestValue(keyPair));//number = number % latestValue
        } while (isMoreThanZero(number));

        return result.toString();
    }

    private KeyPair map(BigInteger number) {
        BigInteger result = number;
        int level = 0;
        //result = result / 10^x > 0
        while (isMoreThanZero(result = result.divide(getBaseValue()))) {
            number = result;
            level = level + 1;
        }

        return new KeyPair(number.intValue(), level);
    }
}
