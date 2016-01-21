package main.java.test;

import main.java.bignumbers.BigNumber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright (C) Coderion sp. z o.o
 */
public class BigNumberTest extends Assert{

    private BigNumber bigNumber;
    private BigNumber bigNumber2;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addTest_TC01() {
        bigNumber = new BigNumber("300");
        bigNumber2 = new BigNumber("400");

        assertEquals(bigNumber.add(bigNumber2).getValue(), new BigNumber("700").getValue());
    }

    @Test
    public void addTest_TC02() {
        bigNumber = new BigNumber("700");
        bigNumber2 = new BigNumber("700");

        assertEquals(this.bigNumber.add(bigNumber2).getValue(), "1400");
    }

    @Test
    public void addTest_TC03() {
        bigNumber = new BigNumber("700");
        bigNumber2 = new BigNumber("300");

        assertEquals(this.bigNumber.add(bigNumber2).getValue(), "1000");
    }

    @Test
    public void addTest_TC04() {
        bigNumber = new BigNumber("7000000000000");
        bigNumber2 = new BigNumber("30773730000000");

        assertEquals(this.bigNumber.add(bigNumber2).getValue(), "37773730000000");
    }

    @Test
    public void substractTest_TC01() {
        bigNumber = new BigNumber("700");
        bigNumber2 = new BigNumber("100");

        assertEquals(this.bigNumber.substract(bigNumber2).getValue(), "600");
    }

    @Test
    public void substractTest_TC02() {
        bigNumber = new BigNumber("720");
        bigNumber2 = new BigNumber("100");

        assertEquals(this.bigNumber.substract(bigNumber2).getValue(), "620");
    }

    @Test
    public void substractTest_TC03() {
        bigNumber = new BigNumber("37773730000000");
        bigNumber2 = new BigNumber("7000000000000");

        assertEquals(this.bigNumber.substract(bigNumber2).getValue(), "30773730000000");
    }
}
