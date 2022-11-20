package com.techelevator.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class MoneyTest {

    private Money money;

    @Before
    public void setup() {
        money = new Money();
        money.setBalance(BigDecimal.valueOf(10.00));
    }

    @Test
    public void boGoDo_return_9_if_input_10() {
        BigDecimal expected = BigDecimal.valueOf(9.00);
        BigDecimal result = money.boGoDo(BigDecimal.valueOf(10.00));
        Assert.assertEquals(expected, result);

    }
    @Test
    public void testStringToBigDecimal () {
        BigDecimal test = BigDecimal.valueOf(12.40);
        BigDecimal expected = test.setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = money.stringToBigDecimal("12.40");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getChange_1150_passed_in_returns_11_2_0_0() {
        money.addToBalance(BigDecimal.valueOf(1.50));
        int[] expected = {11, 2, 0, 0};
        int[] result = money.getChange();
        Assert.assertArrayEquals(expected, result);
    }
    @Test
    public void getChange_860_passed_in_returns_8_2_1_0() {
        money.decreaseBalance(BigDecimal.valueOf(1.40));
        int[] expected = {8, 2, 1, 0};
        int[] result = money.getChange();
        Assert.assertArrayEquals(expected, result);
    }
    @Test
    public void getChange_1140_returns_11_1_1_1() {
        money.addToBalance(BigDecimal.valueOf(1.40));
        int[] expected = {11, 1, 1, 1};
        int[] result = money.getChange();
        Assert.assertArrayEquals(expected, result);
    }
    @Test
    public void getChange_1115_returns_11_0_1_1() {
        money.addToBalance(BigDecimal.valueOf(1.15));
        int[] expected = {11, 0, 1, 1};
        int[] result = money.getChange();
        Assert.assertArrayEquals(expected, result);
    }
    @Test
    public void getChange_1130_returns_11_1_0_1() {
        money.addToBalance(BigDecimal.valueOf(1.30));
        int[] expected = {11, 1, 0, 1};
        int[] result = money.getChange();
        Assert.assertArrayEquals(expected, result);
    }
    @Test
    public void getChange_1105_returns_11_0_0_1() {
        money.addToBalance(BigDecimal.valueOf(1.05));
        int[] expected = {11, 0, 0, 1};
        int[] result = money.getChange();
        Assert.assertArrayEquals(expected, result);
    }
    @Test
    public void getChange_1110_passed_returns_11_0_1_0() {
        money.addToBalance(BigDecimal.valueOf(1.10));
        int[] expected = {11, 0, 1, 0};
        int[] result = money.getChange();
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void testAddToBalance() {
        money.addToBalance(BigDecimal.valueOf(1.75));
        BigDecimal expected = BigDecimal.valueOf(11.75);
        BigDecimal result = money.getBalance();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testDecreaseBalance() {
        money.decreaseBalance(BigDecimal.valueOf(1.75));
        BigDecimal expected = BigDecimal.valueOf(8.25);
        BigDecimal result = money.getBalance();
        Assert.assertEquals(expected, result);
    }

}
