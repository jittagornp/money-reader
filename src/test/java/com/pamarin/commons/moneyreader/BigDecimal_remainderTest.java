package com.pamarin.commons.moneyreader;


import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author jittagornp <http://jittagornp.me>
 * create : 2017/07/21
 */
public class BigDecimal_remainderTest {

    @Test
    public void shouldBe0_whenXIs0AndYIs10() {

        BigDecimal x = BigDecimal.ZERO;
        BigDecimal y = BigDecimal.TEN;

        BigDecimal output = x.remainder(y);
        BigDecimal expected = x;

        assertEquals(expected, output);
    }

    @Test
    public void shouldBe1_whenXIs1AndYIs10() {

        BigDecimal x = BigDecimal.ONE;
        BigDecimal y = BigDecimal.TEN;

        BigDecimal output = x.remainder(y);
        BigDecimal expected = x;

        assertEquals(expected, output);
    }
    
    @Test
    public void shouldBe2_whenXIs2AndYIs10() {

        BigDecimal x = BigDecimal.valueOf(2);
        BigDecimal y = BigDecimal.TEN;

        BigDecimal output = x.remainder(y);
        BigDecimal expected = x;

        assertEquals(expected, output);
    }
    
    @Test
    public void shouldBe0_whenXIs10AndYIs10() {

        BigDecimal x = BigDecimal.TEN;
        BigDecimal y = BigDecimal.TEN;

        BigDecimal output = x.remainder(y);
        BigDecimal expected = BigDecimal.ZERO;

        assertEquals(expected, output);
    }

}
