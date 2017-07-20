/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pamarin.commons.moneyreader;

import java.math.BigDecimal;

/**
 * @author jittagornp <http://jittagornp.me>
 * create : 2017/07/20
 */
public interface NumberReader {

    String read(Integer number);
    
    String read(BigDecimal number);

}
