/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.commons.moneyreader;

/**
 * @author jittagornp <http://jittagornp.me>
 * create : 2017/07/21
 */
public class KeyPair {

    private final int number;

    private final int level;

    public KeyPair(int number, int level) {
        this.number = number;
        this.level = level;
    }

    public int getNumber() {
        return number;
    }

    public int getLevel() {
        return level;
    }
}
